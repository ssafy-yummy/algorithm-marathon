package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합
public class BOJ_1915_G4_가장큰정사각형 {

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
				board[i][j + 1] = tp;
				dp[i][j + 1] = tp + dp[i - 1][j + 1] + dp[i][j] - dp[i - 1][j];
			}
		}

//		System.out.println();
//		for (int[] is : dp) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] == 1) {

					int size = 1;
					int target = 1;

					while (true) {
						if (i + size > N || j + size > M)
							break;

						target += 2 * size + 1;
						int tmp = dp[i + size][j + size] - dp[i - 1][j + size] - dp[i + size][j - 1] + dp[i - 1][j - 1];
						if (target == tmp) {
							size++;
						} else
							break;
					}
					ans = Math.max(ans, size * size);
				}
			}
		}
		System.out.println(ans);
	}
}
