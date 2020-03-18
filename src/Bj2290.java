import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;
// 13792 KB, 104 ms

// 2290번 LCD Test
// https://www.acmicpc.net/problem/2290
public class Bj2290 {
    private static int width;

    private static void type1() { // "    "
        for (int k = 0; k < width; k ++) {
            System.out.print(" ");
        }
    }

    private static void type2() { // " -- "
        System.out.print(" ");
        for (int k = 0; k < width-2; k ++) {
            System.out.print("-");
        }
        System.out.print(" ");
    }

    private static void type3() { // "   |"
        for (int k = 0; k < width-1; k ++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }

    private static void type4() { // "|   "
        System.out.print("|");
        for (int k = 0; k < width-1; k ++) {
            System.out.print(" ");
        }
    }

    private static void type5() { // "|  |"
        System.out.print("|");
        for (int k = 0; k < width-2; k ++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        Scanner sc = new Scanner(System.in);
        int s = Integer.parseInt(st.nextToken());
//        int s = sc.nextInt(); // 1 <= s <= 10
        String n = st.nextToken();
//        String n = sc.next(); // 0 <= n <= 9,999,999,999
        width = s + 2; // 가로 = s + 2

        for (int i = 0; i < 2 * s + 3; i++) {
            for (int j = 0; j < n.length(); j++) {
                if (i == 0) { // 맨위
                    switch (n.charAt(j)) {
                        case '1':
                        case '4':
                            type1();
                            break;
                        default:
                            type2();
                    }
                } else if (i < (2 * s + 3) / 2 ){ // 중간위
                    switch (n.charAt(j)) {
                        case '1':
                        case '2':
                        case '3':
                        case '7':
                            type3();
                            break;
                        case '5':
                        case '6':
                            type4();
                            break;
                        default:
                            type5();
                    }
                } else if (i == (2 * s + 3) / 2) { // 중간
                    switch (n.charAt(j)) {
                        case '1':
                        case '7':
                        case '0':
                            type1();
                            break;
                        default:
                            type2();
                    }
                } else if (i < (2 * s + 3)-1) { // 중간아래
                    switch (n.charAt(j)) {
                        case '6':
                        case '8':
                        case '0':
                            type5();
                            break;
                        case '2':
                            type4();
                            break;
                        default:
                            type3();
                    }
                } else {
                    switch (n.charAt(j)) {
                        case '1':
                        case '4':
                        case '7':
                            type1();
                            break;
                        default:
                            type2();
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
