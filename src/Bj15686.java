import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14428 KB, 136 ms
// https://www.acmicpc.net/problem/15686
public class Bj15686 {
    private static int n, m, houseNum, chickenRestrauntNum; // 2 <= n <= 50, 1 <= m <= 13
    private static int[][] house, chickenRestraunt, distance;
    private static boolean[] isRemoved; // true=폐업
    private static int answer = Integer.MAX_VALUE;

    private static void getDistance() {
        for (int i = 0; i < houseNum; i++)
            for (int j = 0; j < chickenRestrauntNum; j++)
                distance[i][j] = Math.abs(house[i][0] - chickenRestraunt[j][0])
                        + Math.abs(house[i][1] - chickenRestraunt[j][1]);
    }

    private static void removeChickenRestrant(int start, int count) {
        if (count == chickenRestrauntNum-m) { // m개
            int sum = 0;
            for (int i = 0; i < houseNum; i++) {
                int small = 1000;
                for (int j = 0; j < chickenRestrauntNum; j++)
                    if (!isRemoved[j]) if (small > distance[i][j]) small = distance[i][j];
                sum += small;
            }
            if (sum < answer) answer = sum;
        } else {
            for (int i = start; i < chickenRestrauntNum; i++) {
                if (!isRemoved[i]) {
                    isRemoved[i] = true;
                    removeChickenRestrant(i+1, count+1);
                    isRemoved[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new int[2*n][2];
        chickenRestraunt = new int[13][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) { // 집
                    house[houseNum][0] = i+1;
                    house[houseNum][1] = j+1;
                    houseNum++;
                } else if (info == 2) { // 치킨집
                    chickenRestraunt[chickenRestrauntNum][0] = i+1;
                    chickenRestraunt[chickenRestrauntNum][1] = j+1;
                    chickenRestrauntNum++;
                }
            }
        }
        distance = new int[houseNum][chickenRestrauntNum];
        getDistance();
        isRemoved = new boolean[chickenRestrauntNum];
        removeChickenRestrant(0, 0);
        System.out.println(answer);
    }
}
