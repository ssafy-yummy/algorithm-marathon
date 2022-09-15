package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_S1_양 {

	static int R, C, a, b;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && board[i][j] != '#') {

					// dfs
					int[] arr = dfs(i, j, new int[] { 0, 0 });
					if (arr[0] != 0 || arr[1] != 0) {
						if (arr[0] > arr[1])
							a += arr[0];
						else
							b += arr[1];
					}

					// bfs
					// bfs(i, j);
				}
			}
		}
		System.out.println(a + " " + b);
	}

	// dfs를 활용한 풀이
	private static int[] dfs(int r, int c, int[] cnts) {
		if (board[r][c] == 'o')
			cnts[0]++;
		if (board[r][c] == 'v')
			cnts[1]++;

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (checkNext(nr, nc) && board[nr][nc] != '#' && !visited[nr][nc]) {
				cnts = dfs(nr, nc, cnts);
			}
		}
		return cnts;
	}

	// bfs를 활용한 풀이
	private static void bfs(int r, int c) {

		int oc = 0;
		int vc = 0;
		visited[r][c] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (board[p.r][p.c] == 'o')
				oc++;
			if (board[p.r][p.c] == 'v')
				vc++;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (checkNext(nr, nc) && board[nr][nc] != '#' && !visited[nr][nc]) {
					visited[nr][nc] = true;

					q.offer(new Point(nr, nc));
				}
			}
		}

		if (oc != 0 || vc != 0) {
			if (oc > vc)
				a += oc;
			else
				b += vc;
		}
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
