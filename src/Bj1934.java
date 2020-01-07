import java.util.Scanner;

// 1934번 최소공배수
// https://www.acmicpc.net/problem/1934
public class Bj1934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println(Lcm(n1, n2));
            // System.out.println(GcdAndLcm.Lcm(n1, n2));
        }
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
