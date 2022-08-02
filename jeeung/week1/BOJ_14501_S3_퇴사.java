import java.util.*;

public class BOJ_14501_S3_퇴사 {
    static int maxVal;
    static int n;
    static int[][] arr;

    // day를 진행시키면서 가능한 경우의 수를 모두 찾아보는 함수
    public static void backtrack(int day, int val) {
        if (day >= n) {
            if (day == n)
                maxVal = Math.max(maxVal, val); // 가능한 경우의 수 중 가장 큰 값 찾기
            return;
        }

        backtrack(day + 1, val); // val 안바꾸고 다음 날로 넘기기
        backtrack(day + arr[day][0], val + arr[day][1]); // arr의 인덱스만큼 진행하며 진행한 인덱스만큼 val 더하기

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        maxVal = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        backtrack(0, 0);
        System.out.println(maxVal);

    }
}