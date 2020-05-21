import java.util.Scanner;

// 42616 KB, 236 ms
// N과 M(1) https://www.acmicpc.net/problem/15649
public class Bj15649 {
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

    public static void solution(int cur, int sum, String s) {
        if (sum == m) {
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
