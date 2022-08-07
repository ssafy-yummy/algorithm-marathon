package com.ssafy.algorithm.swea.star;

import java.util.Scanner;

public class S2447 {
	static int[][] star;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		star = new int[n][n];
		star(0, 0, n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; i++) {
				sb.append(star[i][j] == 1 ? "*" : " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void star(int r, int c, int n) {
		if (n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						continue;

					star[r + i][c + j] = 1;
				}
			}
		} else {

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						continue;

					star(r + n / 3 * i, c + n / 3 * j, n / 3);
				}
			}
		}
	}
}