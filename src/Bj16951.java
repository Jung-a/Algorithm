import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj16951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int curTime = 0;
        int answer = n;
        boolean[] isVisited = new boolean[1001];
        for (int i = 0; i < n; i++) {
            int zero = arr[i]-(k*i);
            if (zero <= 0 || isVisited[zero]) continue;
            else isVisited[zero] = true;
            curTime = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] != arr[j]+(k*(i-j))) curTime++;
            }
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + (k*(j-i)) != arr[j]) curTime++;
            }
            answer = Math.min(answer, curTime);
        }
        System.out.println(answer);
    }
}
