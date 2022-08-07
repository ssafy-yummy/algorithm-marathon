package com.ssafy.algorithm.swea.hw_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 과제2_달팽이_숫자 {

	static int n;
	static int[][] board;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			int n = Integer.parseInt(br.readLine());
			board = new int[n][n];

			int idx = 1;

			int dir = 0;
			int r = 0;
			int c = 0;
			while (true) {

				board[r][c] = idx++;
				if (idx > n * n)
					break;

				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 0) {
					dir = (dir + 1) % 4;
				}
				r += dr[dir];
				c += dc[dir];
			}

			System.out.println("#" + tc);

			for (int[] a1 : board) {
				for (int a2 : a1) {
					System.out.print(a2 + " ");
				}
				System.out.println();
			}
		}
	}

}