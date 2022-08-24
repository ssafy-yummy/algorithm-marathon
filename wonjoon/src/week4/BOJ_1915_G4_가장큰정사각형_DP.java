package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class BOJ_1915_G4_가장큰정사각형_DP2 {

	static int N, M, ans;
	static int[][] board, dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				int tp = Integer.parseInt(tmp[j]);
				dp[i][j + 1] = tp;

				if (tp == 0)
					continue;
				int up = 1;
				int min = min(dp[i - 1][j], dp[i][j], dp[i - 1][j + 1]);
				if (min != 0) {
					up = min + 1;
					dp[i][j + 1] = up;
				}

				ans = Math.max(ans, up * up);
			}
		}

//		System.out.println();
//		for (int[] is : dp) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		System.out.println(ans);

	}

	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
