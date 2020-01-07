import java.util.Scanner;

// 114499번 주사위 굴리기
// https://www.acmicpc.net/problem/14499
public class Bj14499 {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        Dice dice = new Dice(x, y);
        int k = sc.nextInt();

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
        private int x;
        private int y;
        private int[] diceNum = {0, 0, 0, 0, 0, 0}; // 앞, 왼, 위, 오, 뒤, 아래

        Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void process(int r) {
            if (rollingDice(r)) {
                changeNum();
                System.out.println(diceNum[2]);
            }
        }

        private boolean rollingDice(int r) {
            switch (r) {
                case 1:
                    return east();
                case 2:
                    return west();
                case 3:
                    return south();
                default:
                    return north();
            }
        }

        private void changeNum() {
            int m = getMap(x, y);
            if (m == 0) {
                setMap(x, y, diceNum[5]);
            } else {
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
