package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1309_S1_동물원 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];

		// dp[N][0] : 사자를 배치하지 않을 때 경우
		// dp[N][1] : 사자를 왼쪽에 배치할 때 경우
		// dp[N][2] : 사자를 오른쪽에 배치할 때 경우
		dp[0][0] = dp[0][1] = dp[0][2] = 1;
		for (int i = 1; i <= N; i++) {
			
			// 현재 사자를 배치하지 않는 경우는 직전의 모든 경우의 합
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			
			// 1:왼쪽 => 배치하지 않거나 오른쪽에 배치한 경우의 합
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			
			// 2:오른쪽 -> 배치하지 않거나 왼쪽에 배치한 경우의 합
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}


		// dp[N][0]: N번째까지 배치할 수 있는 사자의 경우의 수
		System.out.println(dp[N][0]);
	}
}
