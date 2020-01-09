import java.util.Scanner;

// 2869번 달팽이는 올라가고 싶다.
// https://www.acmicpc.net/problem/2869
public class Bj2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1 <= B < A <= V <= 1,000,000,000
        double A = sc.nextInt();
        double B = sc.nextInt();
        double V = sc.nextInt();

        System.out.println(((int)Math.ceil((V - A) / (A - B))) + 1);
    }
}
