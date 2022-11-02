package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8394_악수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 1;
		if (N == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
		}

		System.out.println(dp[N]);
	}
}
