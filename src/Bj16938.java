import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj16938 {
    private static int n, l, r, x, answer = 0;
    private static int[] questionLevels = new int[16];
    private static boolean[] isVisited = new boolean[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            questionLevels[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        System.out.println(answer);
    }

    public static void dfs(int cur, int sum, int min, int max, int count) {
//        for (int i = 0; i < n; i++) {
//            System.out.print(isVisited[i]);
//        }
//        System.out.println(cur+" "+ sum+" "+ min+" "+ max);
        if (count > 1 && max - min >= x && sum >= l && sum <= r) {
            answer++;
        }
        for (int i = cur; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i + 1, sum + questionLevels[i], Math.min(min, questionLevels[i]), Math.max(max, questionLevels[i]), count+1);
                isVisited[i] = false;
            }
        }
    }
}