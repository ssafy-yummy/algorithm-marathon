package com.ssafy.algorithm.boj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2448_2 {
	static int n;
	static char[][] board;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new char[n][n * 2 - 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], ' ');
		}

		star(0, n - 1, n);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void star(int r, int c, int size) {
		if (size == 3) {
			board[r][c] = '*';
			board[r + 1][c - 1] = '*';
			board[r + 1][c + 1] = '*';
			board[r + 2][c - 2] = '*';
			board[r + 2][c - 1] = '*';
			board[r + 2][c] = '*';
			board[r + 2][c + 1] = '*';
			board[r + 2][c + 2] = '*';
		} else {
			int cut = size / 2;
			// 상단 삼각형
			star(r, c, cut);
			// 하단 좌측 삼각형
			star(r + cut, c - cut, cut);
			// 하단 우측 삼각형
			star(r + cut, c + cut, cut);
		}
	}
}
