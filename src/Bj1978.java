import java.util.Arrays;
import java.util.Scanner;

// 1978번 소수 찾기
// https://www.acmicpc.net/problem/1978
public class Bj1978 {

    public static void main(String[] args) {
//        solution1();
//        solution2();
        solution3();
    }

    // 주어진 수의 최대값만큼의 소수값만 구해놓기 14364KB, 112ms
    public static void solution3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n <= 100
        int[] val = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            val[i] = sc.nextInt(); // val <= 1,000
            if (max < val[i]) max = val[i]; // 최댓값 구하기
        }
        boolean[] arr = new boolean[max+1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for(int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                int j = i+i;
                while (j <= max) {
                    arr[j] = false;
                    j += i;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if (arr[val[i]]) answer++;
        }
        System.out.println(answer);
    }

    // 소수를 미리 구해놓기 14372KB, 112ms
    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n <= 100
        boolean[] arr = new boolean[1001];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for(int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                int j = i+i;
                while (j <= 1000) {
                    arr[j] = false;
                    j += i;
                }
            }
        }
        int answer = 0;
        while (0 < n--) {
            int val = sc.nextInt(); // val <= 1,000
            if (arr[val]) answer++;
        }
        System.out.println(answer);
    }

    // 값을 입력받을 때마다 구하기 14376KB, 116ms
    public static void solution1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n <= 100
        int answer = 0;
        while (0 < n--) {
            int val = sc.nextInt(); // val <= 1,000
            if (val == 1) continue;
            boolean isPrimeNum = true;
            for (int i = 2; i < val; i++) {
                if (val % i == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (isPrimeNum) answer++;
        }
        System.out.println(answer);
    }
}
