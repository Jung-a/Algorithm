import java.util.Scanner;

// 114499번 주사위 굴리기
// https://www.acmicpc.net/problem/14499
public class Bj14499 {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1 <= n, m <= 20
        m = sc.nextInt();
        int x = sc.nextInt(); // 0 <= x <= n-1
        int y = sc.nextInt(); // 0 <= y <= m-1
        Dice dice = new Dice(x, y);
        int k = sc.nextInt(); // 1 <= k <= 1000

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            dice.process(sc.nextInt());
        }
    }

    private static int getN() {
        return n;
    }

    private static int getM() {
        return m;
    }

    private static int getMap(int x, int y) {
        return map[x][y];
    }

    private static void setMap(int x, int y, int val) {
        map[x][y] = val;
    }

    static class Dice {
        private int x; // 주사위 위치. x좌표
        private int y; // 주사위 위치. y좌표
        private int[] diceNum = {0, 0, 0, 0, 0, 0}; // 앞, 왼, 위, 오, 뒤, 아래

        Dice(int x, int y) { // 처음에 입력 받는 주사위의 좌표
            this.x = x;
            this.y = y;
        }

        void process(int r) {
            if (rollingDice(r)) {
                changeMapValue();
                System.out.println(diceNum[2]); //주사위 윗 면의 값 출력
            }
        }

        private boolean rollingDice(int r) {
            switch (r) {
                case 1: // 동쪽
                    return east();
                case 2: // 서쪽
                    return west();
                case 3: // 북쪽
                    return south();
                default: // 남쪽
                    return north();
            }
        }

        private void changeMapValue() {
            int m = getMap(x, y);
            if (m == 0) { // 지도의 값이 0이면, 주사위의 바닥면에 쓰여 있는 수 복사
                setMap(x, y, diceNum[5]);
            } else { // 0이 아니면, 지도에 쓰여있는 수가 주사위 바닥면으로 복사, 칸의 수는 0
                diceNum[5] = m;
                setMap(x, y, 0);
            }
        }

        private boolean east() { // 동
            if (y+1 >= getM()) return false;
            y++;
            int temp = diceNum[5];
            diceNum[5] = diceNum[3];
            diceNum[3] = diceNum[2];
            diceNum[2] = diceNum[1];
            diceNum[1] = temp;
            return true;
        }

        private boolean west() { //서
            if (y-1 < 0) return false;
            y--;
            int temp = diceNum[1];
            diceNum[1] = diceNum[2];
            diceNum[2] = diceNum[3];
            diceNum[3] = diceNum[5];
            diceNum[5] = temp;
            return true;
        }

        private boolean north() { // 남
            if (x+1 >= getN()) return false;
            x++;
            int temp = diceNum[0];
            diceNum[0] = diceNum[2];
            diceNum[2] = diceNum[4];
            diceNum[4] = diceNum[5];
            diceNum[5] = temp;
            return true;
        }

        private boolean south() { // 북
            if (x-1 < 0) return false;
            x--;
            int temp = diceNum[5];
            diceNum[5] = diceNum[4];
            diceNum[4] = diceNum[2];
            diceNum[2] = diceNum[0];
            diceNum[0] = temp;
            return true;
        }
    }
}
