package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// 단지 발견 시 bfs로 돌기만 하면 풀리는 문제! 
public class BOJ_2667_S1_단지번호붙이기 {

	static int n;
	static int[][] board;
	static int[][] visited;
	static int count = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			count = 0;
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1 && visited[i][j] == 0) {
					// 단지를 발견하고 방문한 적이 없다면 bfs 진행합니다!!
					bfs(i, j);
				}
			}
		}

		System.out.println(count);
		Collections.sort(arr);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	// bfs로 탐색하는 함수 
	static void bfs(int r, int c) {
		visited[r][c] = 1;
		count++;
		int cnt = 1;
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(r, c));

		while (!q.isEmpty()) {

			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if ((nr >= 0 & nr < n) && (nc >= 0 & nc < n) && visited[nr][nc] == 0 && board[nr][nc] == 1) {
					visited[nr][nc] = 1;
					cnt++;
					q.offer(new Node(nr, nc));
				}
			}
		}
		arr.add(cnt);
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
