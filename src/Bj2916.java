import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 22528 KB, 224 ms
// 자와 각도기 https://www.acmicpc.net/problem/2916
public class Bj2916 {
    public static List<Integer> degrees = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            getNewDegree(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (degrees.contains(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void getNewDegree(int d) {
        while (d > 360) { // 각이 360도를 넘어가면 d - 360을 하여 새로운 각도를 만들 수 있다.
            d -= 360;
        }
        if (d > 0 && !degrees.contains(d)) {
            degrees.add(d); // 주어진 각도 추가
            List<Integer> newList = new ArrayList<>();
            for (int degree : degrees) {
                int add = Math.abs(degree - d);
                newList.add(add);
                int sub = Math.abs(degree + d);
                newList.add(sub);
            }
            for (int i : newList) {
                getNewDegree(i);
            }
        }
    }
}
