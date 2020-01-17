import java.util.Scanner;

// 6064번 카잉 달력
// https://www.acmicpc.net/problem/6064
public class Bj6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(0 < T--) {
            int M = sc.nextInt(); // 1 <= M, N <= 40,000
            int N = sc.nextInt();
            int x = sc.nextInt(); // 1 <= x <= M
            int y = sc.nextInt(); // 1 <= y <= N
            System.out.println(solution(M, N, x, y));
        }
    }

    // 23164KB, 324ms
    private static int solution(int M, int N, int x, int y) {
        int years = x;
        int min = Lcm(M, N); // 최소공배수
        if (y == N) y = 0;
        while (years % N != y) {
            years += M;
            if (years > min) return -1; // 최소공배수까지만
        }
        return years;
    }

    // 23008KB, 360ms
    private static int solution2(int M, int N, int x, int y) {
        int years = x;
        int min = Lcm(M, N);
        if (y == N) y = 0;
        while (years % N != y) {
            years += M;
            if (years > N * M) return -1; // N * M 까지
        }
        return years;
    }

    // 시간초과
    private static int solution1(int M, int N, int x, int y) {
        int years = 1;
        int[] kaying = new int[]{1, 1};
        while (kaying[0] != x || kaying[1] != y) {
            if (kaying[0] < M) kaying[0]++;
            else kaying[0] = 1;
            if (kaying[1] < N) kaying[1]++;
            else kaying[1] = 1;
            years++;
            if (kaying[0] == M && kaying[1] == N) return -1;
        }
        return years;
    }

    // 최대공약수 (Greatest Common Divisor)
    public static int Gcd(int a, int b) {
        // 큰 수와 작은 수 구분하기
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 유클리드 호제법
        int r = 0;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return b;
    }

    // 최소공배수 (Least Common Multiple)
    public static int Lcm(int a, int b) {
        return a * b / Gcd(a, b);
    }
}
