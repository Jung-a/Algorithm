import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13572 KB, 172 ms
// https://www.acmicpc.net/problem/1182
public class Bj1182 {
    public static int[] nums;
    public static int n;
    public static int s;
    public static boolean[] isvisited;
    public static int answer = 0;

    public static void dfs(int start) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (isvisited[i])
                sum += nums[i];
        }
        if (sum == s) answer++;
        for (int i = start; i < n; i++) {
            if (!isvisited[i]) {
                isvisited[i] = true;
                dfs(i + 1);
                isvisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        isvisited = new boolean[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        dfs(0);
        if (s == 0) answer--;
        System.out.println(answer);
    }
}
