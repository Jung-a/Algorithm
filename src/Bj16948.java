import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16948
public class Bj16948 {
    private static int n, r1, c1, r2, c2;
    private static Queue<Node> queue = new LinkedList<>();
    private static boolean[][] isVisited = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int c = dfs();
        System.out.println(c);
    }

    public static int dfs() {
        int[] rx = new int[]{-2, -2, 0, 0, 2, 2};
        int[] ry = new int[]{-1, 1, -2, 2, -1, 1};
        addQueue(r1, c1, 0);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == r2 && node.y == c2)
                return node.count;
            for (int i = 0; i < 6; i++) {
                int nx = node.x + rx[i];
                int ny = node.y + ry[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n)
                    addQueue(nx, ny, node.count + 1);
            }
        }
        return -1;
    }

    public static void addQueue(int x, int y, int c) {
        if (!isVisited[x][y]) {
            isVisited[x][y] = true;
            queue.add(new Node(x, y, c));
        }
    }
}

class Node {
    int x, y, count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}