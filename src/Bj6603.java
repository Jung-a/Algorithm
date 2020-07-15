import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14368 KB, 84 ms
// 로또 https://www.acmicpc.net/problem/6603
public class Bj6603 {
    public static StringBuilder answer = new StringBuilder();
    public static boolean[] isVisited;
    public static int[] s;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        while (k != 0) {
            s = new int[k];
            isVisited = new boolean[k];
            for (int i = 0; i < k; i++)
                s[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0);
            answer.append("\n");
            st = new StringTokenizer(br.readLine());
            k  = Integer.parseInt(st.nextToken());
        }
        answer.substring(0, answer.length()-1);
        System.out.println(answer);
    }

    public static void dfs(int cur, int num) {
        if (num == 6) {
            for (int i = 0; i < k; i++) {
                if (isVisited[i]) answer.append(s[i]+" ");
            }
            answer.append("\n");
        } else {
            for(int i = cur; i < k; i++) {
                isVisited[i] = true;
                dfs(i+1, num+1);
                isVisited[i] = false;
            }
        }
    }

}
