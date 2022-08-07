package com.ssafy.algorithm.swea.S1954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

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
			int x = 1;
			int i = 0;
			while (x != n * n +1) {
				snail[r][c] = x++;

				int nr = r + dr[i];
				int nc = c + dc[i];

				if ((nr >= 0 && nr < n) && (nc >= 0 && nc < n) && snail[nr][nc] == 0) {
					r = nr;
					c = nc;
				} else {
					i++;
					i %= 4;
					r += dr[i];
					c += dc[i];
				}
			}

			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					System.out.print(snail[j][j2] + " ");
				}
				System.out.println();
			}
		}
	}
}
