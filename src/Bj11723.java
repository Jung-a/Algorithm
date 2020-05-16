import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 286748 KB, 908 ms
// 집합 https://www.acmicpc.net/problem/11723
public class Bj11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 3,000,000
        StringBuilder answer = new StringBuilder(); // 출력 값이 많은 경우에는 한 번에 출력하기
        int s = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                s |= (1 << x);
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                s &= ~(1 << x);
            } else if (op.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (0 != ((1 << x) & s)) answer.append("1\n");
                    else answer.append("0\n");
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                s = s ^ (1 << x);
            } else if (op.equals("empty")) s= 0;
            else s = (1 << 21) -1;
        }
        System.out.println(answer);
    }
}
