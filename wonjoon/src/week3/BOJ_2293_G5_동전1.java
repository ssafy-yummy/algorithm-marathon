package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_G5_동전1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		// dp 배열 : 동전을 사용했을 때 만들 수 있는 경우의 수
		// dp[i - coin]은 해당 동전을 사용하지 않았을 때  만들 수 있는 경우의 수
		int[] dp = new int[K + 1];
		dp[0] = 1; // 처음에 1개는 사용해야 함
		for (int coin : coins) {
			for (int i = coin; i < K + 1; i++) {
				dp[i] += dp[i - coin];
			}
		}

		System.out.println(dp[K]);
	}
}
