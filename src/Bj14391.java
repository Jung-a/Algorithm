import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 55560 KB, 364 ms
// https://www.acmicpc.net/problem/14391
// 14391번 종이 조각
public class Bj14391 {
    public static boolean[][] isHorizontal; // true = 가로, false = 세로
    public static int n, m, answer = 0; // 1 <= n, m <= 4
    public static int[][] nums;
    public static int sum = 0;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            for (int j = 0; j < m; j++)
                nums[i][j] = Integer.parseInt(num.charAt(j)+"");
        }

        isHorizontal = new boolean[n][m];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int a) {
        getAnswer();
        for (int i = a; i < n*m; i++) {
            if (!isHorizontal[i/m][i%m]) {
                isHorizontal[i/m][i%m] = true;
                dfs(i+1);
                isHorizontal[i/m][i%m] = false;
            }
        }
    }

    public static void getAnswer() {
        sum = 0;
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isHorizontal[i][j]) {
                    sb.append(nums[i][j]);
                } else if (sb.length() != 0)
                    add(sb.toString());
            }
            if (sb.length() != 0)
                add(sb.toString());
        }

        sb.setLength(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isHorizontal[j][i]) {
                    sb.append(nums[j][i]);
                } else if (sb.length() != 0)
                    add(sb.toString());
            }
            if (sb.length() != 0)
                add(sb.toString());
        }
        if (answer < sum) answer = sum;
    }

    public static void add(String n) {
        add(Integer.parseInt(n));
    }

    public static void add(int n) {
        sum += n;
        sb.setLength(0);
    }

}
