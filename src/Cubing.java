import java.util.Scanner;

// 5373번 큐빙
// https://www.acmicpc.net/problem/5373
public class Cubing {
    static RubiksCube rubiksCube = new RubiksCube();;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1 < n < 1000

        // U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면
        // +인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향
        for (int i = 0; i < n; i++) {
            int rollingNum = sc.nextInt();
            for (int j = 0; j < rollingNum; j++) {
                String s = sc.next();
                char direction = s.charAt(0);
                rolling(direction);
                if (s.charAt(1) == '-') {
                    rolling(direction);
                    rolling(direction);
                }
            }
            rubiksCube.printUp();
        }
    }

    static void rolling(char c) {
        switch (c) {
            case 'U':
                rubiksCube.rollingUp();
                break;
            case 'D':
                rubiksCube.rollingDown();
                break;
            case 'F':
                rubiksCube.rollingFront();
                break;
            case 'B':
                rubiksCube.rollingBack();
                break;
            case 'L':
                rubiksCube.rollingLeft();
                break;
            case 'R':
                rubiksCube.rollingRight();
                break;
        }
    }
}

class RubiksCube {
    char[][] up, down, front, back, left, right;

    RubiksCube() {
        // 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색
        up = new char[3][3];
        initializeTo('w', up);
        down = new char[3][3];
        initializeTo('y', down);
        front = new char[3][3];
        initializeTo('r', front);
        back = new char[3][3];
        initializeTo('o', back);
        left = new char[3][3];
        initializeTo('g', left);
        right = new char[3][3];
        initializeTo('b', right);
    }

    private void initializeTo(char c, char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = c;
            }
        }
    }

    public void printUp() {
//        for (int i = 0; i < up.length; i++) {
//            for (int j = 0; j < up[0].length; j++) {
//                System.out.print(up[i][j]);
//            }
//            System.out.println();
//        }
        for (char[] cs : up) {
            for (char c : cs) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // 윗 면을 시계방향으로 돌림
    public void rollingUp() {
        rollingUpAndDown(0);
        up = rotate90(up);
    }

    // 아랫 면을 시계방향으로 돌림
    public void rollingDown() {
        rollingUpAndDown(2);
        down = rotate90(down);
    }

    private void rollingUpAndDown(int l) {
        char[] temp = new char[] {back[l][0], back[l][1], back[l][2]};

        back[l][0] = left[l][0];
        back[l][1] = left[l][1];
        back[l][2] = left[l][2];

        left[l][0] = front[l][0];
        left[l][1] = front[l][1];
        left[l][2] = front[l][2];

        front[l][0] = right[l][0];
        front[l][1] = right[l][1];
        front[l][2] = right[l][2];

        right[l][0] = temp[0];
        right[l][1] = temp[1];
        right[l][2] = temp[2];
    }

    // 앞 면을 시계방향으로 돌림
    public void rollingFront() {
        rollingFrontAndBack(2);
        front = rotate90(front);
    }

    // 뒷 면을 시계방향으로 돌림
    public void rollingBack() {
        rollingFrontAndBack(0);
        back = rotate90(back);
    }

    private void rollingFrontAndBack(int l) {
        char[] temp = new char[] {up[l][0], up[l][1], up[l][2]};

        up[l][0] = left[l][0];
        up[l][1] = left[l][1];
        up[l][2] = left[l][2];

        left[l][0] = down[l][0];
        left[l][1] = down[l][1];
        left[l][2] = down[l][2];

        down[l][0] = right[l][0];
        down[l][1] = right[l][1];
        down[l][2] = right[l][2];

        right[l][0] = temp[0];
        right[l][1] = temp[1];
        right[l][2] = temp[2];
    }

    // 왼쪽 면을 시계방향으로 돌림
    public void rollingLeft() {
        rollingLeftAndRight(0);
        left = rotate90(left);
    }

    // 오른쪽 면을 시계방향으로 돌림
    public void rollingRight() {
        rollingLeftAndRight(2);
        right = rotate90(right);
    }

    private void rollingLeftAndRight(int l) {
        char[] temp = new char[] {back[0][l], back[1][l], back[2][l]};

        back[0][l] = down[0][l];
        back[1][l] = down[1][l];
        back[2][l] = down[2][l];

        down[0][l] = front[0][l];
        down[1][l] = front[1][l];
        down[2][l] = front[2][l];

        front[0][l] = up[0][l];
        front[1][l] = up[1][l];
        front[2][l] = up[2][l];

        up[0][0] = temp[0];
        up[1][0] = temp[1];
        up[2][0] = temp[2];
    }

    private char[][] rotate90(char[][] arr) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = arr[2-j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = temp[i][j];
            }
        }
        return arr;
    }
}