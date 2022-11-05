package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_D4_수영대회결승전 {

	static int N, ans;
	static int[][] board;
	static boolean[][] visited;
	static Point start, end;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = -1;
			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			start = new Point(sr, sc, 0);

			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			end = new Point(er, ec, 0);

			bfs(sr, sc, 0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int sr, int sc, int time) {
		visited = new boolean[N][N];

		visited[sr][sc] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc, time));
		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == end.r && p.c == end.c) {
				ans = p.time;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int nt = p.time + 1;

				if (checkNext(nr, nc) && !visited[nr][nc]) {
					// 다음이 소용돌이라면
					if (board[nr][nc] == 2) {
						// 다음번에 갈 수 있는 시간이라면
						if (nt % 3 == 0) {
							visited[nr][nc] = true;
							q.offer(new Point(nr, nc, nt));
						} else { // 안되면 정지 / 방문 체크안함
							q.offer(new Point(p.r, p.c, nt));
						}
					} else if (board[nr][nc] == 0) { // 일반 바다라면
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, nt));
					}
				}
			}
		}
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static class Point {
		int r;
		int c;
		int time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
