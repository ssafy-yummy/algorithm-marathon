package com.ssafy.algorithm.swea.hw_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 과제5_Ladder1 {

	static int ans = 0;
	static int[][] board = new int[100][100];
	static int[][] visited = new int[100][100];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int posC = 0;
		for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					board[i][j] = tmp;

					if (tmp == 2) {
						posC = j;
					}
				}
			}

			dfs(99, posC);
			System.out.println("#" + tc + " " + ans);

		}
	}

	static void dfs(int r, int c) {
		Stack<Node> stack = new Stack<>();

		stack.add(new Node(r, c));

		while (!stack.isEmpty()) {
			Node cur = stack.pop();

			int curR = cur.r;
			int curC = cur.c;

			if (curR == 0) {
				ans = curC;
				break;
			}

			// 왼쪽 확인
			if (curC - 1 >= 0 && board[curR][curC - 1] == 1) {
				board[curR][curC] = 0;
				stack.add(new Node(curR, curC - 1));
			}

			// 오른쪽 확인
			else if (curC + 1 < 100 && board[curR][curC + 1] == 1) {
				board[curR][curC] = 0;
				stack.add(new Node(curR, curC + 1));
			}

			else {
				stack.add(new Node(--curR, curC));
			}
		}
	}
	static class Node {
		int r;
		int c;

		public Node(int x, int y) {
			super();
			this.r = x;
			this.c = y;
		}

	}
}

