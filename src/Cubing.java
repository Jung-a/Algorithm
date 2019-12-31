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
                rubiksCube.printUp();
            }
        }
    }

    static void rolling(char c) {
        switch (c) {
            case 'L':
                rubiksCube.rollingLeft();
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

    }

    // 아랫 면을 시계방향으로 돌림
    public void rollingDown() {

    }

    // 앞 면을 시계방향으로 돌림
    public void rollingFront() {

    }

    // 뒷 면을 시계방향으로 돌림
    public void rollingBack() {}

    // 왼쪽 면을 시계방향으로 돌림
    public void rollingLeft() {
        // 뒷면 기억하기
        char[] temp = new char[] {back[0][0], back[1][0], back[2][0]};
        back[0][0] = down[0][0];
        back[1][0] = down[1][0];
        back[2][0] = down[2][0];

        down[0][0] = front[0][0];
        down[1][0] = front[1][0];
        down[2][0] = front[2][0];

        front[0][0] = up[0][0];
        front[1][0] = up[1][0];
        front[2][0] = up[2][0];

        up[0][0] = temp[0];
        up[1][0] = temp[1];
        up[2][0] = temp[2];
    }

    // 오른쪽 면을 시계방향으로 돌림
    public void rollingRight() {}
}