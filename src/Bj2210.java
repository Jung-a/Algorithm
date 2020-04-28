import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2210
// 15428 KB, 104 ms
public class Bj2210 {
    final static int SIZE = 5;
    public static int[][] board = new int[SIZE][SIZE];
    public static HashSet<String> answerSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                dfs(i, j,board[i][j]+"", 1);
        }
        System.out.println(answerSet.size());
    }

    private static void dfs(int x, int y, String value, int count) {
        if (count == 6) {
            answerSet.add(value);
        } else {
            if (x-1 >= 0) dfs(x-1, y, value+board[x-1][y], count+1); // 위
            if (x+1 < SIZE) dfs(x+1, y, value+board[x+1][y], count+1); // 아래
            if (y-1 >= 0) dfs(x, y-1, value+board[x][y-1], count+1); // 왼쪽
            if (y+1 < SIZE) dfs(x, y+1, value+board[x][y+1], count+1); // 오른쪽
        }
    }
}
