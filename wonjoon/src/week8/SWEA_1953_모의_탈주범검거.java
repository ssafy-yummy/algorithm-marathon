package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_모의_탈주범검거 {

	static int N, M, R, C, L, ans = 1;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] tmp = { { 3, 4, 7 }, { 2, 4, 5 }, { 3, 5, 6 }, { 2, 6, 7 } };
	static int[][] type = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			ans = 1;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			board = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, board[r][c], 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.dis == L - 1) {
				return;
			}

			int cr = p.r;
			int cc = p.c;

			for (int i : type[p.type]) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (checkNext(nr, nc) && compareNext(i, nr, nc) && board[nr][nc] != 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, board[nr][nc], p.dis + 1));
					ans++;
				}
			}
		}
	}

	private static boolean compareNext(int dir, int nr, int nc) {
		for (int i : tmp[dir])
			if (board[nr][nc] == i)
				return false;

		return true;
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static class Point {
		int r;
		int c;
		int type;
		int dis;

		public Point(int r, int c, int type, int dis) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.dis = dis;
		}
	}
}
