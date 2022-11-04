package week10;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1309_S1_동물원 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        Scanner scann = new Scanner(System.in);
        N = scann.nextInt();

        dp = new int[N+1][3];
        dp[1][0] = 1; // 사자가 1행에 없을 경우
        dp[1][1] = 1; // 사자가 1행 왼쪽에 있을 경우
        dp[1][2] = 1; // 사자가 1행 오른쪽에 있을 경우

        for (int i = 2; i <= N; i++) {
        	// 해당 행에 사자가 없으면, 윗칸 사자가 3가지 경우가 올 수 있음
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
			// 해당 행에 사자가 왼쪽에 있으면, 윗칸 사자가 없거나 오른쪽에 올 수 있음
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
			// 해당 행에 사자가 오른쪽에 있으면, 윗칸 사자가 없거나 왼쪽에 올 수 있음
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
		}

        int result = 0;
        for (int i = 0; i < 3; i++) {
			result+=dp[N][i];
		}

        System.out.println(result%9901); // 출력

    }
}