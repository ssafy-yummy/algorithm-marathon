package week10;

import java.util.Scanner;

public class BOJ_G5_2225_합분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int dp[][] = new int[K+1][N+1];
		
		// N:6, K:4일때, dp[4][6] = dp[3][0]+dp[3][1]+...+dp[3][6]이다.
		// 점화식 : dp[K][N] = dp[K-1][0]+dp[K-1][1]+...+dp[K-1][N]
		
		for (int i = 0; i < K+1; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < N+1; i++) {
			dp[1][i] = 1;
		} // 초기화
		
		for (int i = 2; i < K+1; i++) {
			for (int j = 1; j < N+1; j++) {
				for (int k = 0; k < j+1; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 1000000000;	// 1,000,000,000으로 나눈 나머지를 저장한다.
				}
			}
		}

		System.out.println(dp[K][N]);
	}

}
