import java.util.Arrays;
import java.util.Scanner;

// 1107번 리모컨
// https://www.acmicpc.net/problem/1107
public class Bj1107 {
    private static int N;
    private static boolean[] possibleNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 0 <= N <= 500,000
        int M = sc.nextInt(); // 0 <= M <= 10

        possibleNumbers = new boolean[10];
        Arrays.fill(possibleNumbers, true);
        for(int i = 0; i < M; i++){
            int k = sc.nextInt();
            possibleNumbers[k] = false;
        }

        int bigNumber = bigNumber();
        int smallNumber = smallNumber();
        System.out.println(
                Min((bigNumber+"").length() + StartFrom(bigNumber),
                (smallNumber+"").length() + StartFrom(smallNumber),
                StartFrom(100))
        );
    }

    // 가장 작은 수 반환
    private static int Min(int... ints) {
        int min = ints[0];
        for(int i : ints) {
            if (min > i) min = i;
        }
        return min;
    }

    // N보다 작거나 같은 수 중 가장 큰 수
    private static int smallNumber() {
        int number = N;
        while(!ispossiblenumbers(number)) {
            number--;
            if (number < 0) return 1000000;
        }
        return number;
    }

    // N보다 큰 수 중 가장 작은 수
    private static int bigNumber() {
        int number = N + 1;
        while(!ispossiblenumbers(number)) {
            number++;
            if (number > 1000000) return 1000000;
        }
        return number;
    }

    // number를 리모컨으로 누를 수 있으면 true 반환, 아니면 false 반환
    private static boolean ispossiblenumbers(int number) {
        return ispossiblenumbers(number+"");
    }

    private static boolean ispossiblenumbers(String number) {
        char[] chars = number.toCharArray();
        for (char c : chars) {
            int i = Character.getNumericValue(c);
            if (!possibleNumbers[i]) return false;
        }
        return true;
    }

    // start에서 원하는 채널까지 +/-로 이동한 횟수
    private static int StartFrom(int start) {
        return (N - start) * (start < N ? 1 : -1);
    }

}
