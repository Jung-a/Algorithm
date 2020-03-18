import java.util.Scanner;

public class Bj2290 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // 1 <= s <= 10
        String n = sc.next(); // 0 <= n <= 9,999,999,999
        int width = s + 2; // 가로 = s + 2
        int height = 2 * s + 3; // 세로 = 2 * s + 3

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < n.length(); j++) {
                if (i == 0) {
                    if (n.charAt(j) == '1' || n.charAt(j) == '4') {
                        for (int k = 0; k < width; k ++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                        for (int k = 0; k < width-2; k ++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    }
                } else if (i < height / 2 ){
                    if (n.charAt(j) == '1' || n.charAt(j) == '2' || n.charAt(j) == '3' || n.charAt(j) == '7') {
                        for (int k = 0; k < width-1; k ++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    } else if (n.charAt(j) == '5' || n.charAt(j) == '6'){
                        System.out.print("|");
                        for (int k = 0; k < width-1; k ++) {
                            System.out.print(" ");
                        }

                    } else {
                        System.out.print("|");
                        for (int k = 0; k < width-2; k ++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    }
                } else if (i == height / 2) {
                    if (n.charAt(j) == '1' || n.charAt(j) == '7' || n.charAt(j) == '0') {
                        for (int k = 0; k < width; k ++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                        for (int k = 0; k < width-2; k ++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    }
                } else if (i < height-1) {
                    if (n.charAt(j) == '2') {
                        System.out.print("|");
                        for (int k = 0; k < width-1; k ++) {
                            System.out.print(" ");
                        }
                    } else if (n.charAt(j) == '6' || n.charAt(j) == '8' || n.charAt(j) == '0'){
                        System.out.print("|");
                        for (int k = 0; k < width-2; k ++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    } else {
                        for (int k = 0; k < width-1; k ++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    }
                } else {
                    if (n.charAt(j) == '1' || n.charAt(j) == '4' || n.charAt(j) == '7') {
                        for (int k = 0; k < width; k ++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                        for (int k = 0; k < width-2; k ++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

//      --   --        --   --   --   --   --   --
//   |    |    | |  | |    |       | |  | |  | |  |
//   |    |    | |  | |    |       | |  | |  | |  |
//      --   --   --   --   --        --   --
//   | |       |    |    | |  |    | |  |    | |  |
//   | |       |    |    | |  |    | |  |    | |  |
//      --   --        --   --        --   --   --