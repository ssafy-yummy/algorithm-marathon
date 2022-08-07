package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_S1_미로탐색 {

	static int[][] board;
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] ch;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		ch = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		bfs(0, 0);
		System.out.println(ans + 1);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();

		ch[r][c] = 1;
		q.offer(new Point(r, c, 0));

		while (!q.isEmpty()) {

			Point cur = q.poll();

			if (cur.r == N - 1 && cur.c == M - 1) {
				ans = Math.min(ans, cur.num);
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (check(nr, nc)) {
					ch[nr][nc] = 1;
					q.offer(new Point(nr, nc, cur.num + 1));
				}
			}
		}

	}

	static boolean check(int nr, int nc) {

		if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 1 && ch[nr][nc] == 0) {
			return true;
		}

		return false;
	}

	static class Point {
		int r;
		int c;
		int num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
}
