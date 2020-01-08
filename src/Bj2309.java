import java.util.Arrays;
import java.util.Scanner;

// 2309번 일곱 난쟁이
// https://www.acmicpc.net/problem/2309
public class Bj2309 {
    private static int[] heights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        heights = new int[9];
        for(int i = 0; i < 9; i++)
            heights[i] = sc.nextInt();
        solution();
    }

    private static void solution() {
        Arrays.sort(heights);

        int sum = 0;
        for(int h : heights) sum += h;

        int first = 0;
        int second = 1;
        while (100 != sum - heights[first] - heights[second]) {
            second++;
            if (second >= 9) {
                first++;
                second = first + 1;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == first || i == second) continue;
            System.out.println(heights[i]);
        }
    }
}
