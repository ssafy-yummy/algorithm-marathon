package com.ssafy.algorithm.swea.hw_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 과제1_농작물_수확하기 {

	static int n;
	static int[][] board;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			n = Integer.parseInt(br.readLine());

			board = new int[n][n];
			visited = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] tmp = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			int start = n / 2;

			int ans = bfs(start, start);

			System.out.printf("#%d %d\n", tc, ans);

		}

	}

	static int bfs(int r, int c) {
		int sum = 0;
		Queue<Node> q = new LinkedList<>();
		sum += board[r][c];
		visited[r][c] = 1;
		q.offer(new Node(r, c));
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if ((nr >= 0 && nr < n) && (nc >= 0 && nc < n)) {
					if (visited[nr][nc] == 0) {
						visited[nr][nc] = 1;
						q.offer(new Node(nr, nc));
						sum += board[nr][nc];
					}
				} else {
					return sum;
				}
			}
		}
		return sum;
	}
}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
