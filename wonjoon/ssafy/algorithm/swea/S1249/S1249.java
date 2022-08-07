package com.ssafy.algorithm.swea.S1249;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1249 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int ans = 0;
	static int[][] board;
	static int[][] ch;
	static Queue<Engineer> engineer;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1249\\input.txt"));

		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt();
			System.out.println(n);
			board = new int[n][n];
			ch = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] tmp = sc.next().split("");
				int[] tmp2 = new int[n];

				for (int j = 0; j < n; j++) {
					tmp2[j] = Integer.parseInt(tmp[j]);
				}
				board[i] = tmp2;
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}

			bfs();

			break;
		}

		sc.close();
	}

	static void bfs() {

	}
	
}
