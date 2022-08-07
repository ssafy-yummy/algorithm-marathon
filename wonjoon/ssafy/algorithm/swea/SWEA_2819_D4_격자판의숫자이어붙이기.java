package com.ssafy.algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2819_D4_격자판의숫자이어붙이기 {

	static int[][] board = new int[4][4];
	static int N = 7;
	static HashSet<String> hashSet = new HashSet<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			hashSet.clear();
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 풀이
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					bfs(i, j);
				}
			}

			// 출력
			System.out.println("#" + tc + " " + hashSet.size());
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(r, c, String.valueOf(board[r][c])));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.cnt.length() == N) {
				hashSet.add(cur.cnt);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
					String s = cur.cnt + board[nr][nc];
					if (s.length() <= 7) {
						q.offer(new Point(nr, nc, cur.cnt + board[nr][nc]));
					}
				}
			}
		}
	}

	static class Point {
		int r;
		int c;
		String cnt;

		public Point(int r, int c, String cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
