import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 6588번 골드바흐의 추측 77004KB 1188ms
// https://www.acmicpc.net/problem/6588
public class Bj6588 {
    private static boolean[] primeNums;
    private static int max = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        int n; // 6 <= n <= 1000000
        while( (n = sc.nextInt()) != 0) {
            values.add(n);
            if (n > max) max = n;
        }
        getPrime(); // 소수 배열 구하기

        int answer = 3;
        for (int i : values) {
            if ((answer = solution(i)) == -1) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.println(i + " = " + answer + " + " + (i - answer));
            }
        }
    }

    private static int solution(int n) {
        for(int j = 0; j < (max+1)/2; j++) {
            if (primeNums[j] && primeNums[n-j]) {
                return j;
            }
        }
        return -1;
    }

    // max값까지의 소수를 구한다
    public static void getPrime() {
        primeNums = new boolean[max+1];
        Arrays.fill(primeNums, true);
        primeNums[0] = primeNums[1] = false;
        for(int i = 2; i < primeNums.length; i++) {
            if (primeNums[i]) {
                int j = i+i;
                while (j <= max) {
                    primeNums[j] = false;
                    j += i;
                }
            }
        }
    }
}
