package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트의로봇_2차원배열돌리기 {

	static int N, K, ans;
	static int[] robots;
	static int[][] belt;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		robots = new int[N];
		belt = new int[2][N];

		st = new StringTokenizer(br.readLine());
		// 윗줄 초기화
		for (int i = 0; i < N; i++) {
			belt[0][i] = Integer.parseInt(st.nextToken());
		}

		// 아랫줄 반대로 입력
		for (int i = N - 1; i >= 0; i--) {
			belt[1][i] = Integer.parseInt(st.nextToken());
		}

		solve();

		System.out.println(ans);

	}

	private static void solve() {

		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		while (K > 0) {
			ans++;

			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			for (int i = robots.length - 2; i >= 0; i--) {
				if (robots[i] == 1 && robots[i + 1] == 0) {
					robots[i] = 0;
					if (i + 1 != robots.length - 1) {
						robots[i + 1] = 1;
					}
				}
			}
			rotateBelt();

			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히
			// 있는다. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			for (int i = robots.length - 2; i >= 0; i--) {
				if (robots[i] == 1 && robots[i + 1] == 0 && belt[0][i + 1] >= 1) {
					robots[i] = 0;
					if (i + 1 != robots.length - 1) {
						robots[i + 1] = 1;
					}
					belt[0][i + 1]--;
					if (belt[0][i + 1] == 0) {
						K--;
						if (K == 0)
							break;
					}

				}
			}

			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[0][0] >= 1 && robots[0] == 0) {
				robots[0] = 1;
				belt[0][0]--;
				if (belt[0][0] == 0)
					K--;
			}
		}
	}

	private static void rotateBelt() {

		int start = belt[0][0];
		int r = 0;
		int c = 0;
		int turn = 0;

		while (true) {

			int nr = r + dr[turn];
			int nc = c + dc[turn];

			if (!checkNext(nr, nc)) {
				turn++;

				if (turn == 4)
					break;
				nr = r + dr[turn];
				nc = c + dc[turn];

			}
			belt[r][c] = belt[nr][nc];

			r = nr;
			c = nc;
		}
		belt[0][1] = start;
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < 2 && nc >= 0 && nc < N;
	}
}
