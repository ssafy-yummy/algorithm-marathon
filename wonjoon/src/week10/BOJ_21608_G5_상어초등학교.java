package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_G5_상어초등학교 {

	static int N;
	static int[][] board, lover;
	static int[] students;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		lover = new int[(N * N) + 1][4];
		students = new int[N * N];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			students[i] = num;

			for (int j = 0; j < 4; j++)
				lover[num][j] = Integer.parseInt(st.nextToken());

		}

		board = new int[N][N];

		for (int k = 0; k < N * N; k++) {
			PriorityQueue<Position> pq = new PriorityQueue<>();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 0) {
						int loverCnt = 0;
						int emptyCnt = 0;
						for (int x = 0; x < 4; x++) {
							int nr = r + dr[x];
							int nc = c + dc[x];

							if (checkNext(nr, nc)) {
								// 주위에 좋아하는 학생 체크
								for (int i = 0; i < 4; i++)
									if (board[nr][nc] == lover[students[k]][i])
										loverCnt++;

								// 빈 칸 확인
								if (board[nr][nc] == 0)
									emptyCnt++;

							}
						}

						pq.offer(new Position(r, c, emptyCnt, loverCnt));
					}
				}
			}

			Position p = pq.poll();
			board[p.r][p.c] = students[k];
		}

		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (checkNext(nr, nc)) {
						for (int x = 0; x < 4; x++) {
							if (board[nr][nc] == lover[board[r][c]][x]) {
								cnt++;
							}
						}
					}
				}
				ans += (int) Math.pow(10, cnt - 1);

			}
		}

		System.out.println(ans);

	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static class Position implements Comparable<Position> {
		int r;
		int c;
		int emptyCnt;
		int loveCnt;

		public Position(int r, int c, int emptyCnt, int loveCnt) {
			this.r = r;
			this.c = c;
			this.emptyCnt = emptyCnt;
			this.loveCnt = loveCnt;
		}

		@Override
		public int compareTo(Position o) {
			int r1 = this.r;
			int r2 = o.r;
			int c1 = this.c;
			int c2 = o.c;
			int e1 = this.emptyCnt;
			int e2 = o.emptyCnt;
			int l1 = this.loveCnt;
			int l2 = o.loveCnt;

			if (l1 == l2)
				if (e1 == e2)
					if (r1 == r2)
						return c1 - c2;
					else
						return r1 - r2;
				else
					return e2 - e1;
			else
				return l2 - l1;
		}
	}
}
