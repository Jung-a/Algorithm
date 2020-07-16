import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14368 KB, 84 ms
// 로또 https://www.acmicpc.net/problem/6603
public class Bj6603_2 {
    public static StringBuilder answer = new StringBuilder();
    public static int[] s = new int[13];
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        while (k != 0) {
            for (int i = 0; i < k; i++)
                s[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0, new int[6]);
            answer.append("\n");
            st = new StringTokenizer(br.readLine());
            k  = Integer.parseInt(st.nextToken());
        }
        System.out.println(answer);
    }

    public static void dfs(int cur, int num, int[] ans) {
        if (num == 6) {
            for (int i = 0; i < 6; i++) {
                answer.append(ans[i]).append(" ");
            }
            answer.append("\n");
        } else {
            for(int i = cur; i < k; i++) {
                ans[num] = s[i];
                dfs(i+1, num+1, ans);
            }
        }
    }

}
