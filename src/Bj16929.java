import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16929
public class Bj16929 {
    private static int n, m;
    private static char[][] board = new char[51][51];
    private static int[][] isVisited = new int[51][51];
    private static int[] rx = new int[]{0, 1, 0, -1};
    private static int[] ry = new int[]{1, 0, -1, 0};
    private static Stack<Node16929> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i< n; i++) {
            String s = br.readLine();
            System.arraycopy(getChar(s), 0, board[i], 0, s.length());
        }
        if (dfs()) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean dfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisited[i][j] != 0) continue;
                stack.push(new Node16929(i, j, 1));
                while(!stack.isEmpty()) {
                    Node16929 node = stack.pop();
                    if (isVisited[node.x][node.y] != 0) continue;
                    isVisited[node.x][node.y] = node.count;
                    for (int k = 0; k < 4; k++) {
                        int cx = node.x + rx[k];
                        int cy = node.y + ry[k];
                        if (cx >= 0 && cx < n && cy >= 0 && cy < m && board[cx][cy]==board[i][j]) {
                            if (isVisited[cx][cy] == 0)  // 처음 방문
                                stack.push(new Node16929(cx, cy, node.count+1));
                            else if ((node.count - isVisited[cx][cy]) >= 3) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static char[] getChar(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            chars[i] = s.charAt(i);
        return chars;
    }
}

class Node16929 {
    int x, y, count;

    public Node16929(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.count = c;
    }
}

