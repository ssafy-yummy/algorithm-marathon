package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_G5_토마토 {

	static int M, N, ans;
	static int[][] board, visited;
	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				board[i][j] = tmp;

				// 토마토가 동시에 익기 때문에 처음부터 모든 토마토를 큐에 넣어준다.
				if (tmp == 1) {
					q.offer(new Point(i, j, 1));
					visited[i][j] = 1;
				}
			}
		}

		bfs();

		// 이차원 배열을 돌면서 0을 발견하면 -1 출력 아니면 최대 일수 출력
		if (findZero())
			System.out.println(-1);
		else
			System.out.println(ans - 1);
	}

	// bfs 기본 구조
	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();

			ans = Math.max(ans, p.day);

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				// 다음 칸이 유효한지, 토마토가 익지 않았는지(0), 방문했는지(0)
				if (checkNext(nr, nc) && board[nr][nc] == 0 && visited[nr][nc] == 0) {
					visited[nr][nc] = 1;
//					board[nr][nc] = 1;
					board[nr][nc] = p.day + 1; // board 일수를 저장한다. 꼭 일수를 저장하지 않아도 된다. 0만 아니면 됨
					q.offer(new Point(nr, nc, p.day + 1));
				}
			}
		}
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	private static boolean findZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	static class Point {
		int r;
		int c;
		int day;

		public Point(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
}
