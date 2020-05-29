import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 149448 KB, 1724 ms
// 합이 0인 네 정수 https://www.acmicpc.net/problem/7453
public class Bj7453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 4000
        int[][] abcd = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int  j = 0; j < 4; j++) {
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] abSums = new int[n * n], cdSums = new int[n * n], choose = new int[]{0, 0};
        int i = 0;
        while (choose[0] != n-1 || choose[1] != n-1) {
            abSums[i] = abcd[choose[0]][0] + abcd[choose[1]][1];
            cdSums[i] = abcd[choose[0]][2] + abcd[choose[1]][3];
            i++;
            choose[0]++;
            if (choose[0] == n) {
                choose[0] = 0;
                choose[1]++;
            }
        }
        abSums[i] = abcd[choose[0]][0] + abcd[choose[1]][1];
        cdSums[i] = abcd[choose[0]][2] + abcd[choose[1]][3];
        Arrays.sort(abSums); // 정렬
        Arrays.sort(cdSums);
        long answer = 0; // 최댓값 = 4000^4
        int left = 0, right = n*n-1;
        while(left < n*n && right >= 0) {
            int sum = abSums[left] + cdSums[right];
            if (sum == 0) { // 동일한 수 만큼 더하기
                long leftCount = 0, rightCount = 0;
                while (left+leftCount < n*n && abSums[left] == abSums[(int) (left+leftCount)]) {
                    leftCount++;
                }
                while (right-rightCount >= 0 && cdSums[right] == cdSums[(int) (right-rightCount)]) {
                    rightCount++;
                }
                answer += leftCount * rightCount;
                left += leftCount;
                right -= rightCount;
            }
            else if (sum > 0) right--;
            else left++;
        }
        System.out.println(answer);
    }

}
