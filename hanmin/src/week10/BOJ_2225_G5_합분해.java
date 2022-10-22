package hanmin.src.week10;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2225_G5_합분해 {
	static int[][] dp;
	static int N;
	static int K;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K];

		// start
		// N을 1가지로 만드는 경우 = 1
		// N을 j로 만드는 경우 = i-k를 j-1로 만드는 경우의 합
		for (int i = 0; i < N + 1; ++i)
			dp[i][0] = 1;

		for (int j = 1; j < K; ++j) {
			for (int i = 0; i < N + 1; ++i) {
				for (int k = 0; k < i + 1; ++k) {
					dp[i][j] += dp[i - k][j - 1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		// end

		// 출력
		answer = dp[N][K - 1];

		System.out.println(answer);
	}
}
