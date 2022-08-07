package com.ssafy.algorithm.swea.S1954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int n;
	static int[][] snail;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1954\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			System.out.println("#" + tc);

			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];
			int r = 0;
			int c = 0;
			int d = 0;

			for (int i = 1; i <= n * n; i++) {
				snail[r][c] = i;

				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!(check(nr, nc) && snail[nr][nc] == 0)) {
					d = (d + 1) % 4;
				}
				r += dr[d];
				c += dc[d];

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
}