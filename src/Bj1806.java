import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1806
// 24232 KB, 912 ms
public class Bj1806 {
    public static final int BIGNUM = 1000000;
    public static int n, s, answer = BIGNUM; // 10 <= n <= 100,000, 0 < s <= 100,000,000
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int sum = nums[i], cnt = 1;
            if (sum >= s) {
                if (answer > cnt) answer = cnt;
            }else {
                for (int j = i+1; j < n; j++) {
                    sum += nums[j];
                    cnt++;
                    if (sum >= s) {
                        if (answer > cnt) answer = cnt;
                        break;
                    }
                }
            }
        }
        if (answer == BIGNUM) System.out.println(0);
        else System.out.println(answer);
    }
}
