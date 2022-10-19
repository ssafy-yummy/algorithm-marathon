package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_S1_경비원 {
	static int C, R, N;
	static int[][] board;
	static Position[] stores;
	static Position donguen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		board = new int[R + 1][C + 1];
		stores = new Position[N];
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			int d = dir;
			switch (dir) {
			case 1:
				dir = 0;
				break;
			case 2:
				dir = R;
				break;
			case 3:
				dir = dis;
				dis = 0;
				break;
			case 4:
				dir = dis;
				dis = C;
				break;
			}
			board[dir][dis] = 1;
			
			if (i == N) {
				donguen = new Position(d, dir, dis);
				break;
			}
			stores[i] = new Position(d, dir, dis);

		}

		int tot = 0;
		// 동근이와 가게 최소값 계산
		for (int i = 0; i < N; i++) {

			Position p = stores[i];
			Position dp = donguen;

			switch (p.dir) {
			case 1: // 1:북 / 2:남 / 3:서 / 4:동
				switch (dp.dir) {
				case 1: // 북
					tot += Math.abs(p.c - dp.c);
					break;
				case 2:
					tot += (R + Math.min(p.c + dp.c, C - p.c + C - dp.c));
					break;
				case 3:
					tot += (p.c + dp.r);
					break;
				case 4:
					tot += (C - p.c + dp.r);
					break;
				}
				break;
			case 2: // 남
				switch (dp.dir) {
				case 1: // 북
					tot +=  (R + Math.min(p.c + dp.c, C - p.c + C - dp.c));
					break;
				case 2:
					tot += Math.abs(p.c - dp.c);
					break;
				case 3:
					tot += (p.c + R-dp.r);
					break;
				case 4: // 동
					tot += (C-p.c + R-dp.r);
					break;
				}
				break;
			case 3: // 서
				switch (dp.dir) {
				case 1:
					tot += (p.r + dp.c);
					break;
				case 2:
					tot += (R-p.r + dp.c);
					break;
				case 3:
					tot += Math.abs(p.r - dp.r);
					break;
				case 4:
					tot += (C + Math.min(p.r + dp.r, R - p.r + R - dp.r));
					break;
				}
				break;
			case 4: // 동
				switch (dp.dir) {
				case 1:
					tot += (C-dp.c + p.r);
					break;
				case 2:
					tot += (C-dp.c + R-p.r);
					break;
				case 3:
					tot += (C + Math.min(p.r + dp.r, R - p.r + R - dp.r));
					break;
				case 4:
					tot += Math.abs(p.r - dp.r);
					break;
				}
				break;
			}
		}

        System.out.println(tot);
	}

	static class Position {
		int dir;
		int r;
		int c;

		public Position(int dir, int r, int c) {
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
	}
}
