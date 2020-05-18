import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 56384 KB, 728 ms
// 삼각형의 값 https://www.acmicpc.net/problem/4902
public class Bj4902 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int n, answer; // n의 최댓값은????????
    public static int[][] nums, prefixSum;

    public static void main(String[] args) throws IOException {
        int number = 1, a, sum;
        while (input()) {
            answer = -1000;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2 * i + 1; j++) {
                    a = i;
                    if (j % 2 == 0) { // 짝수 - 삼각형
                        sum = 0;
                        while(a < n) {
                            sum += getLineSum(a, j, j + (a-i) * 2);
                            answer = Math.max(sum, answer);
                            a++;
                        }
                    } else { // 홀수 - 역삼각형
                        sum = nums[a--][j];
                        while (a >= 0 && j - (i-a) * 2 >= 0 && j < 2*a+1) {
                            sum += getLineSum(a,j - (i-a) * 2, j);
                            answer = Math.max(sum, answer);
                            a--;
                        }
                    }
                }
            }
            System.out.println(number + ". " + answer);
            number++;
        }
    }

    // nums[a][bStart] ~ nums[a][bEnd]까지의 합을 반환 (가로줄의 합)
    public static int getLineSum(int a, int bStart, int bEnd) {
        if (bStart == 0) return prefixSum[a][bEnd];
        return prefixSum[a][bEnd] - prefixSum[a][bStart-1];
    }

    // 입력값 받기
    public static boolean input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ≤ n ≤ 400
        if (n == 0) return false;
        nums = new int[n][2*n-1];
        prefixSum = new int[n][2*n-1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 2 * i + 1; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                sum += nums[i][j];
                prefixSum[i][j] = sum;
            }
        }
        return true;
    }
}
