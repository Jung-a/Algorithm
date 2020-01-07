import java.util.Scanner;

// 2609번 최대공약수와 최소공배수
// https://www.acmicpc.net/problem/2609
public class Bj2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        if(n1 == 0 || n2 == 0) {
            System.out.println("Wrong Input");
            System.exit(0);
        }

        int gcd = Gcd(n1, n2);
        System.out.println(gcd); // 최대공약수
        System.out.println(Lcm(n1, n2, gcd)); // 최소공배수
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

    // 최소공배수 with 최대공약수
    public static int Lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}


/*
Gcd 메소드에서 b가 아니라 r을 반환하게 되면, 입력받는 숫자의 수 중 한개 이상이 최대공배수일 경우 0을 반환하기 때문에
최소공배수에서 "/ by zero" 에러가 발생한다.
 */