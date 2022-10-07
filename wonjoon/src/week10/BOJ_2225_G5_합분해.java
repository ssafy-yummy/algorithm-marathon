package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_G5_합분해 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[][] dp = new long[K][N + 1];

		for (int i = 0; i < K; i++) {
			dp[i][0] = 1;
			for (int j = 0; j <= N; j++) {
				dp[0][j] = 1;
			}

		}

		// K자리에서 구할 수 있는 N의 경우의 수
		for (int i = 1; i < K; i++) {
			for (int j = 1; j <= N; j++) {
				// i자리에서 구할 수 있는 j의 경우의 수
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] % 1_000_000_000;
			}
		}

		System.out.println(dp[K - 1][N] % 1_000_000_000);

	}
}
