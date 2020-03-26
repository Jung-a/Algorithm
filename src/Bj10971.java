import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 17552 KB, 200 ms
// 10971번 외판원 순회2
// https://www.acmicpc.net/problem/10971
public class Bj10971 {
    private static int n;
    private static int[][] w;
    private static boolean[] isVisited;
    private static int minCost = Integer.MAX_VALUE; // 답
    private static List<Integer> path = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 2 <= n <= 10
        w = new int[n][n];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                w[i][j] = Integer.parseInt(st.nextToken()); // 1,000,000 이하의 양의 정수
        }

        isVisited[0] = true; // 시작장소=도착장소
        path.add(0);
        visite(1);

        System.out.println(minCost);
    }

    private static void visite(int cnt) {
        if (cnt == n && w[path.get(path.size() - 1)][0] != 0) {
            int sum = 0;
            for(int i = 0; i < n-1; i++)
                sum += w[path.get(i)][path.get(i+1)];
            sum += w[path.get(n-1)][path.get(0)];
            if (sum < minCost) minCost = sum;
        } else {
            for (int i = 0; i < n; i++) {
                if (!isVisited[i] && w[path.get(path.size() - 1)][i] != 0) {
                    path.add(i);
                    isVisited[i] = true;
                    visite(cnt + 1);
                    path.remove(path.size() - 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
