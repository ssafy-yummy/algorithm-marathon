package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_G5_평범한배낭_DP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K + 1];

		// 입력 & 풀이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			// 물건 하나 당 한 번만 사용할 수 있으므로 뒤에서 부터 진행
			// 개수에 제한이 없으면 앞에서 부터 합산해가면서 진행
			for (int j = K; j >= weight; j--) {

				// dp[j] : j 분이 주어졌을 때 얻을 수 있는 최대 점수
				// j - weight : 이전 문제를 푸는데 얻은 최대 점수
				dp[j] = Math.max(dp[j], dp[j - weight] + value);
				ans = Math.max(ans, dp[j]);
			}
		}

		// 출력
		System.out.println(ans);
	}
}
