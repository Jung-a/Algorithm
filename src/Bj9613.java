import java.util.Scanner;

// 9613번 GCD 합
// https://www.acmicpc.net/problem/9613
public class Bj9613 {
    private static int n;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 1 <= t <= 100
        while(t-- > 0) {
            n = sc.nextInt(); // 1 < n <= 100
            nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt(); // 0 < nums < 1,000,000
            }
            System.out.println(solution());
        }
    }

    private static long solution() {
        long gcdSum = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                gcdSum += Gcd(nums[i], nums[j]);
            }
        }
        return gcdSum;
    }

    private static int Gcd(int a, int b) {
        // 유클리드 호제법 사용
        int r = 0;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
}

/*
결과값을 int형으로 선언하면 크기가 너무 작다.
 */
