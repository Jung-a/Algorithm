import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 부분수열의 합 2 https://www.acmicpc.net/problem/1208
// 86364 KB, 960 ms
public class Bj1208 {
    public static int n, s;
    public static long answer = 0;
    public static int[] nums;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 40
        s = Integer.parseInt(st.nextToken()); // |S| ≤ 1,000,000
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> leftList=new ArrayList<>();
        ArrayList<Integer> rightList=new ArrayList<>();

        getSumList(0,n/2, 0, leftList);
        getSumList(n/2, n, 0, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        System.out.println(rightList);

        int left=0, right=rightList.size()-1;
        while(left < leftList.size() && right >=0) {
            long leftValue = leftList.get(left);
            long rightNum = rightList.get(right);
            if(leftValue + rightNum == s) {
                long leftCount = 0, rightCount = 0; // 중복된는 값 카운트하기
                while(left < leftList.size() && leftList.get(left) == leftValue) {
                    leftCount++;
                    left++;
                }
                while(right >= 0 && rightList.get(right)== rightNum) {
                    rightCount++;
                    right--;
                }
                answer += leftCount * rightCount;
            }
            if(leftValue + rightNum > s) right--;
            if(leftValue + rightNum < s) left++;
        }
        if(s==0) answer--;
        System.out.println(answer);
    }

    static void getSumList(int left, int right, int sum, ArrayList<Integer> list) {
        if(left >= right) {
            list.add(sum);
            return;
        }
        getSumList(left+1, right, sum, list);
        getSumList(left+1, right, sum+nums[left], list);
    }
}
