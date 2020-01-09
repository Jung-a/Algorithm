import java.util.Arrays;
import java.util.Scanner;

// 11048번 이동하기
// https://www.acmicpc.net/problem/11048
public class Bj11048 {
    private static int N, M;
    private static int[][] maze;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 1 <= N <= 1,000
        M = sc.nextInt(); // 1 <= M <= 1,000

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution());
    }

    private static int solution() {
        int[][] maxResult = new int[N][M];
        for(int i = 0; i < N; i++) // 0으로 초기화
            Arrays.fill(maxResult[i], 0);

        maxResult[0][0] = maze[0][0]; // (0, 0) 위치 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j-1 >= 0) maxResult[i][j] = Math.max(maxResult[i][j], maxResult[i][j-1] + maze[i][j]);
                if (i-1 >= 0) maxResult[i][j] = Math.max(maxResult[i][j], maxResult[i-1][j] + maze[i][j]);
                if (j-1 >= 0 && i-1 >= 0) maxResult[i][j] = Math.max(maxResult[i][j], maxResult[i-1][j-1] + maze[i][j]);
            }
        }

        return maxResult[N-1][M-1];
    }
}
