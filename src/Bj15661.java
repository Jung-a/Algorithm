import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15968 KB, 764 ms
// https://www.acmicpc.net/problem/15661
// 15661번 링크와 스타트
public class Bj15661 {
    public static int n;
    public static int[][] stat;
    public static boolean[] isStartTeam;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "[ \n]");
        n = Integer.parseInt(st.nextToken());
        stat = new int[n][n]; // 4 ≤ N ≤ 20
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j  = 0; j < n; j++)
                stat[i][j] = Integer.parseInt(st.nextToken());
        }
        isStartTeam = new boolean[n];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int start) {
        check();
        for (int i = start+1; i < n; i++) {
            if (!isStartTeam[i]) {
                isStartTeam[i] = true;
                dfs(i);
                isStartTeam[i] = false;
            }
        }

    }

    public static void check() {
        int startSum = 0, linkSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isStartTeam[i] && isStartTeam[j]) startSum += stat[i][j];
                if (!isStartTeam[i] && !isStartTeam[j]) linkSum += stat[i][j];
            }
        }
        if (answer > Math.abs(startSum-linkSum))
            answer = Math.abs(startSum-linkSum);
    }
}
