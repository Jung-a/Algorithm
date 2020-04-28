import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13016 KB, 76 ms
// https://www.acmicpc.net/problem/14501
public class Bj14501 {
    public static int n, answer = 0;
    public static int[] t, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = new int[n]; p = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        counseling(0, 0);
        System.out.println(answer);
    }

    private static void counseling(int curDay, int curSum) {
        if (answer < curSum) answer = curSum;
        for (int i = curDay, gap = 0; i < n; i++, gap++) {
            if (curDay + gap + t[i] <= n) {
                counseling(curDay+gap+t[i], curSum+p[i]);
            }
        }
    }
}
