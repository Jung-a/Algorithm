import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj16922 {
    public static int n, answer = 0;
    public static boolean[] isVisited;
    public static final int[] value = new int[]{1, 5, 10, 50};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n*50+1];
//        dfs(0, 0, 0);
        Queue<Node16922> queue = new LinkedList<>();
        queue.offer(new Node16922(0, 0, 0));
        while (!queue.isEmpty()) {
            Node16922 node = queue.poll();
            if (node.count == n) {
                if (!isVisited[node.sum]) {
                    answer++;
                    isVisited[node.sum] = true;
                }
                continue;
            }
            for (int i = node.start; i < 4; i++) {
                queue.offer(new Node16922(i,node.sum + value[i], node.count + 1));
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int start, int sum, int count) {
        if (count == n) {
            if (!isVisited[sum]) {
                answer++;
                isVisited[sum] = true;
            }
        } else {
            for (int i = start; i < 4; i++) {
                dfs(i, sum + value[i], count + 1);
            }
        }
    }
}
class Node16922 {
    int start, sum, count;

    public Node16922(int start, int sum, int count) {
        this.start = start;
        this.sum = sum;
        this.count = count;
    }
}