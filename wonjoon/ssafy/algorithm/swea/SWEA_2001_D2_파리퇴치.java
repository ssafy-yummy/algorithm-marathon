package com.ssafy.algorithm.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_D2_파리퇴치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] board = new int[N + 1][N + 1];
			for (int j = 1; j < N + 1; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k < N + 1; k++) {
					board[j][k] = Integer.parseInt(st.nextToken()) + board[j - 1][k] + board[j][k - 1]
							- board[j - 1][k - 1];
				}
			}

			int ans = 0;

			for (int i = 0; i <= N - M; i++)
				for (int j = 0; j <= N - M; j++) {
					int sum = board[i + M][j + M] - board[i][j + M] - board[i + M][j] + board[i][j];
					if (sum > ans)
						ans = sum;
				}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
