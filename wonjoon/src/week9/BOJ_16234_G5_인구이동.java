package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {

	static int N, L, R, totH, avg, totalCnt, ans, se;
	static int[][] board, visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// 세대 초기화
			se = 1;
			visited = new int[N][N];
			totalCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						totH = 0;
						avg = 0;
						// 연합 체크
						bfs(i, j);
					}
				}
			}

			// 모두 막혀 있으면 탈출
			if (totalCnt == N * N)
				break;
			ans++;
		}
		System.out.println(ans);
	}

	private static void bfs(int r, int c) {
		visited[r][c] = se;
		int cnt = 1;

		Queue<Position> q = new LinkedList<>();
		Queue<Position> q2 = new LinkedList<>();

		q.offer(new Position(r, c));
		q2.offer(new Position(r, c));

		while (!q.isEmpty()) {
			Position p = q.poll();

			totH += board[p.r][p.c];

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (checkNext(nr, nc) && visited[nr][nc] == 0 && Math.abs(board[nr][nc] - board[p.r][p.c]) >= L
						&& Math.abs(board[nr][nc] - board[p.r][p.c]) <= R) {
					q.offer(new Position(nr, nc));
					q2.offer(new Position(nr, nc));
					visited[nr][nc] = se;
					cnt++;
				}

			}
		}
		avg = totH / cnt;

		while (!q2.isEmpty()) {
			Position p = q2.poll();
			board[p.r][p.c] = avg;
		}

		if (cnt == 1)
			totalCnt++;
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
