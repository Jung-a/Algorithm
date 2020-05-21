import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 56892 KB, 776 ms
// 두 배열의 합 https://www.acmicpc.net/problem/2143
public class Bj2143 {
    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // -1,000,000,000 <= t <= 1,000,000,000
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 1000
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 1 <= n <= 1000
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Long> aSums = getSubArr(a, n);
        ArrayList<Long> bSums = getSubArr(b, m);
        int left = 0, right = bSums.size()-1;
        while (left < aSums.size() && right >= 0) {
            long s = aSums.get(left) + bSums.get(right);
            if (s == t) {
                long leftCount = 1, rightCount = 1;
                while (left+leftCount < aSums.size() && aSums.get(left).equals(aSums.get((int) (left + leftCount)))) {
                    leftCount++;
                }
                while (right-rightCount >= 0 && bSums.get(right).equals(bSums.get((int) (right - rightCount)))) {
                    rightCount++;
                }
                answer += leftCount * rightCount;
                left += leftCount;
                right -= rightCount;
            } else if (s > t) {
                right--;
            } else { // s < t
                left++;
            }
        }
        System.out.println(answer);
    }

    public static ArrayList<Long> getSubArr(int[] arr, int size) {
        ArrayList<Long> sumList = new ArrayList<>();
        for (int  i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                sumList.add(sum);
            }
        }
        Collections.sort(sumList);
        return sumList;
    }
}
