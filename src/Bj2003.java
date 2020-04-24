import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15756 KB, 164 ms
// https://www.acmicpc.net/problem/2003
public class Bj2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());
        int start = 0, end = 0, answer = 0, sum = 0;
        while (start < n) {
            sum += A[end];
            if (m == sum) answer++;
            end++;
            if (end >= n) {
                start++;
                end = start;
                sum = 0;
            }
        }
        System.out.println(answer);
    }
}
