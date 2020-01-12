import java.util.Arrays;
import java.util.Scanner;

public class Bj1978 {

    // 소수를 미리 구해놓기 14372KB, 112ms
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n <= 100
        int[] val = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            val[i] = sc.nextInt(); // val <= 1,000
            if (max < val[i]) max = val[i];
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
            System.out.println(arr[i]);
            if (arr[i]) answer++;
        }
        System.out.println(answer);
    }

    // 소수를 미리 구해놓기 14372KB, 112ms
    public static void main2(String[] args) {
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
    public static void main1(String[] args) {
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
