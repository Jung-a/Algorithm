import java.util.Scanner;

// 백준 1748번 수 이어 쓰기 1
// https://www.acmicpc.net/problem/1748
public class Bj1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1 <= n <= 100,000,000
        solution(n);
    }

    // 14256KB 108ms
    private static void solution(int n) {
        int length = (int) Math.log10(n) + 1;
        double answer = length * (n - Math.pow(10,length-1) + 1);
        while (length-- > 1) {
            answer += length * 9 * Math.pow(10,length-1);
        }
        System.out.println((int)answer);
    }
}