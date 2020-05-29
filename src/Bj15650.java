import java.util.Scanner;

// 58288 KB, 376 ms
// N과 M(2) https://www.acmicpc.net/problem/15650
public class Bj15650 {
    public static int n, m;
    public static boolean[] isVisited;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1 <= m <= n <= 8
        m = sc.nextInt();
        isVisited = new boolean[n];
        solution(0, 0, "");
        System.out.println(answer);
    }

    // 고른 수열은 오름차순이어야 한다.
    public static boolean isAscending(String s) {
        String[] nums = s.split(" ");
        for (int i = 0; i < nums.length-1; i++) {
            if (Integer.parseInt(nums[i]) > Integer.parseInt(nums[i+1])) return false;
        }
        return true;
    }

    public static void solution(int cur, int sum, String s) {
        if (sum == m && isAscending(s)) { // 중복 없이 M 개를 고른 수열
            answer.append(s+ "\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                solution(i+1, sum+1, s+(i+1)+" ");
                isVisited[i] = false;
            }
        }

    }
}
