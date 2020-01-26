import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 백준 2933번 미네랄
// https://www.acmicpc.net/problem/2933
public class Bj2933 {
    private static Scanner sc;
    private static int R, C; // 1 <= R, C <= 100

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        Cave.setCave();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int targetR = R - sc.nextInt();
            int targetC;

            // 제거할 미네랄 위치 탐색
            if (i%2==0) { // 창영 (왼쪽에서 오른쪽으로)
                targetC = 0;
                while(targetC < C && !Cave.cave[targetR][targetC]) {
                    targetC++;
                }
            } else { // 상근(오른쪽에서 왼쪽)
                targetC = C-1;
                while(targetC >= 0 && !Cave.cave[targetR][targetC]) {
                    targetC--;
                }
            }

            // 미네랄 제거
            if (targetC >= 0 && targetC < C) {
                Cave.cave[targetR][targetC] = false;
            }

            // 공중에 떠있는 미네랄 탐색 및 내리기
            Cave.downMineral();
        }
        Cave.printCave();
    }

    // 동굴
    private static class Cave {
        private static boolean[][] cave;
        private static boolean[][] isNotConnected;

//        Cave() {
//            /* setCave를 생성자에 넣은 이유
//            cave[][] 참조 시 NullPointerException 방지
//            = 내부 클래스이기 때문에 Cave.setCave() 호출 시 cave[][]는 null이므로 에러 발생
//             */
//            cave = new boolean[R][C];
//            setCave();
//        }

        // 동굴의 상태 입력
        private static void setCave() {
            cave = new boolean[R][C];
            isNotConnected = new boolean[R][C];
            for(int i = 0; i < R; i++) {
                String s = sc.next();
                for(int j = 0; j < C; j++) {
                    cave[i][j] = s.charAt(j) != '.';
                }
            }
        }

        // 동굴의 상태 출력
        private static void printCave() {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if (cave[i][j]) System.out.print('x');
                    else System.out.print('.');
                }
                System.out.println();
            }
        }

        // 공중에 떠있는 미네랄 탐색 및 내리기
        private static void downMineral() {
            // cave[][]를 isNotConnected[][]로 복사
            for(int i = 0; i < R; i++) {
                if (C >= 0) System.arraycopy(cave[i], 0, isNotConnected[i], 0, C);
            }
            Stack<int[]> stack = new Stack<>();
            for (int j = 0; j < C; j++) {
                if (isNotConnected[R-1][j]) {
                    isNotConnected[R-1][j] = false;
                    if (isNotConnected[R-2][j]) stack.push({R-2, j});
                }
            }

//            Arrays.fill(isConect, false);
////            if (C >= 0) System.arraycopy(cave[R - 1], 0, isConect[R - 1], 0, C);
//
//            for(int i = R-1; i >= 0; i--) {
//                for(int j = 0; j < C; j++) {
//                    if (i== R-1 && cave[i][j]) {
//                        while (0)
//                        isConect[i][j] = true;
//                    }
//                }
//            }
//            boolean isDown = true;
//            while(isDown) {
//                isDown = false;
//                for(int i = 0; i < R; i++) {
//                    for(int j = 0; j < C; j++) {
//                        Arrays.fill(isConect, false);
//                        if (isFloat(i, j)) { // 미네랄이 떠있으면 맨 아래로 내린다.
//                            int downJ = j-1;
//                            while(downJ >= 0 && !cave[i][downJ]){
//                                downJ--;
//                            }
//                            cave[i][downJ+1] = true;
//                            cave[i][j] = false;
//                            isDown = true;
//                            // continue나 break를 할 필요 없다!
//                        }
//                    }
//                }
//            }
        }
//
//        // 공중에 떠 있는 미네랄인지 확인
//        // cave[i][j]가 떠있으면 true 반환, 그렇지 않으면 false 반환
//        private static boolean isFloat(int i, int j) {
//            isConect[i][j] = true;
//            if (i == R-1) return false; // 맨 아랫줄은 항상 false;
//            if (cave[i-1][j]) return false; // 바로 아래칸은 비어있다.
//            return false;
//        }

    }
}