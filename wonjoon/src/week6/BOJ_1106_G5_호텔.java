package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_G5_호텔 {

	static int C, N, ans = Integer.MAX_VALUE;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		dp = new int[1101];
		Arrays.fill(dp, Integer.MAX_VALUE);

		// i 만큼의 홍보효과를 내는데 필요한 금액
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int money = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			for (int j = value; j < dp.length; j++) {
				if (dp[j - value] != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], dp[j - value] + money);

				// 적어도 C 이상이므로, dp에서 C값 이상일 때 최소 값이 답
				if (j >= C)
					ans = Math.min(ans, dp[j]);
			}
		}

		System.out.println(ans);
	}
}
