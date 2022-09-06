package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {

	static int N, M, DIR, R, C, ans;
	static int[][] board;
	static boolean[][] visited;

	// 북동남서 회전
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		DIR = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(R, C, DIR);

		System.out.println(ans + 1);
	}

	private static void solve(int sr, int sc, int dir) {
		visited[sr][sc] = true;

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nr = sr + dr[dir];
			int nc = sc + dc[dir];

			if (check(nr, nc) && board[nr][nc] == 0 && !visited[nr][nc]) {
				ans++;
				solve(nr, nc, dir);

				return;
			}
		}

		// 후진
		int back = (dir + 2) % 4;
		int nr = sr + dr[back];
		int nc = sc + dc[back];

		// 방향은 그대로 dir
		if (check(nr, nc) && board[nr][nc] == 0) {
			solve(nr, nc, dir);
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 1 && nr < N - 1 && nc >= 1 && nc < M - 1;
	}
}
