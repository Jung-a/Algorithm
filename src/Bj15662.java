import java.util.Arrays;
import java.util.Scanner;

public class Bj15662 {

    private static int gearNum;
    private static Gear[] gears;
    private static boolean[] isRotate;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gearNum = sc.nextInt(); // 1 <= gearNum <= 1,000
        gears = new Gear[gearNum];
        isRotate = new boolean[gearNum];
        for(int i = 0; i < gearNum; i++) {
            gears[i] = new Gear(sc.next());
        }
        int k = sc.nextInt(); // 1 <= k <= 1,000
        while (0 < k--) {
            int rotatedLoation = sc.nextInt()-1; // 회전시킨 톱니바퀴 번호
            int direction = sc.nextInt(); // 회전 방향 (1: 시계, -1: 반시계)
            checkRotateGears(rotatedLoation);
            for (int i = 0; i < gearNum; i++) {
                if(isRotate[i]) {
                    if (i % 2 == rotatedLoation % 2) gears[i].rotate(direction);
                    else gears[i].rotate(direction * (-1));
                }
            }
        }

        /*
        1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
         */
        int answer = 0;
        for (int i = 0; i < gearNum; i++) {
            if (gears[i].getFirstValue() == '1') answer++;
        }
        System.out.println(answer);
    }

    private static void checkRotateGears(int n) {
        Arrays.fill(isRotate, false);
        isRotate[n] = true;

        // 왼쪽 방향 톱니바퀴 돌리기
        int left = n;
        while (left-1 >= 0 && gears[left-1].getThirdValue() != gears[left].getSeventhValue()) {
            isRotate[left-1] = true;
            isRotate[left] = true;
            left--;
        }

        // 오른쪽 방향 톱니바퀴 돌리기
        int right = n;
        while (right+1 < gearNum && gears[right].getThirdValue() != gears[right+1].getSeventhValue()) {
            isRotate[right] = true;
            isRotate[right+1] = true;
            right++;
        }
    }
}

//// 톱니바퀴
//// N극 = 0, S극 = 1
//class Gear {
//    private static final int VALUENUM = 8;
//    private String values;
//
//    Gear(String s) {
//        values = s;
//    }
//
//    // 회전. 1: 시계방향, -1: 반시계방향
//    public void rotate(int d) {
//        if (d == 1) rotateClockwise();
//        else rotateAnticlockwise();
//    }
//
//    // 시계방향 회전
//    private void rotateClockwise() {
//        values = values.charAt(VALUENUM-1) + values.substring(0, VALUENUM-1);
//    }
//
//    // 반시계방향 회전
//    private void rotateAnticlockwise() {
//        values = values.substring(1, VALUENUM) + values.charAt(0);
//    }
//
//    // 값 출력
//    public String getValues() {
//        return values;
//    }
//
//    // 첫 번째 값(12시 방향) 반환
//    public char getFirstValue() {
//        return values.charAt(0);
//    }
//
//    // 세 번째 값(3시 방향) 반환
//    public char getThirdValue() {
//        return values.charAt(2);
//    }
//
//    // 일곱 번째 값(9시 방향) 반환
//    public char getSeventhValue() {
//        return values.charAt(6);
//    }
//}

