import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17740 KB, 156 ms
// 한윤정이 이탈리아에 가서 아이스크림을 사먹는 데 https://www.acmicpc.net/problem/2422
public class Bj2422 {
    public static int answer = 0;
    static boolean[][] bannedCombination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 200
        int m = Integer.parseInt(st.nextToken()); // 1 <= m <= 10,000
        bannedCombination = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            bannedCombination[a][b] = true;
            bannedCombination[b][a] = true;
        }
        if (n < 3) System.out.println(0);
        else {
            boolean[] isVisited = new boolean[n];
            dfs(0, 0, n, isVisited, new int[]{-1, -1, -1});
            System.out.println(answer);
        }
    }

    public static void dfs(int cur, int count, int n, boolean[] isVisited, int[] choose) {
        if (count == 2 && bannedCombination[choose[0]][choose[1]]) return;
        if (count == 3) {
            if (!bannedCombination[choose[0]][choose[1]] && !bannedCombination[choose[0]][choose[2]]
                    && !bannedCombination[choose[1]][choose[2]]) answer++;
            return;
        }
        for (int i = cur; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                choose[count] = i;
                dfs(i + 1, count + 1, n, isVisited, choose);
                isVisited[i] = false;
            }
        }
    }
}
