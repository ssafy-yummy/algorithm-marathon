package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_G2_2048Easy {

	static int N, ans;
	static int[] selected;
	static int[][] board, clone;
	static boolean[][] isMerge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		clone = new int[N][N];
		selected = new int[5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				board[i][j] = tmp;
				clone[i][j] = tmp;
			}
		}

		if (N == 1) {
			System.out.println(board[0][0]);
			return;
		}

		perm(0);

		System.out.println(ans);
	}

	// 상 : 1 / 우 : 2 / 하 : 3 / 좌 : 4
	private static void move(int dir) {
		isMerge = new boolean[N][N];
		switch (dir) {
		case 1:
			// 상
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (board[j][i] != 0) {
						int value = board[j][i];
						board[j][i] = 0;
						int idx = j;
						while (true) {

							if (idx == 0) {
								board[idx][i] = value;
								break;
							}

							if (board[idx - 1][i] != 0) {
								if (!isMerge[idx - 1][i] && board[idx - 1][i] == value) {
									isMerge[idx - 1][i] = true;
									board[idx - 1][i] += value;
								} else {
									board[idx][i] = value;
								}
								break;
							}

							idx--;
						}
					}
				}
			}
			break;

		case 2:
			// 우
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						int value = board[i][j];
						board[i][j] = 0;
						int idx = j;
						while (true) {
							if (idx == N - 1) {
								board[i][idx] = value;
								break;
							}

							if (board[i][idx + 1] != 0) {
								if (!isMerge[i][idx + 1] && board[i][idx + 1] == value) {
									isMerge[i][idx + 1] = true;
									board[i][idx + 1] += value;
								} else {
									board[i][idx] = value;
								}
								break;
							}

							idx++;
						}
					}
				}
			}

			break;
		case 3:
			// 하
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 2; j >= 0; j--) {
					if (board[j][i] != 0) {
						int value = board[j][i];
						board[j][i] = 0;
						int idx = j;
						while (true) {

							if (idx == N - 1) {
								board[idx][i] = value;
								break;
							}

							if (board[idx + 1][i] != 0) {
								if (!isMerge[idx + 1][i] && board[idx + 1][i] == value) {
									isMerge[idx + 1][i] = true;
									board[idx + 1][i] += value;
								} else {
									board[idx][i] = value;
								}
								break;
							}

							idx++;
						}
					}
				}
			}
			break;
		case 4:
			// 좌
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (board[i][j] != 0) {
						int value = board[i][j];
						board[i][j] = 0;
						int idx = j;
						while (true) {
							if (idx == 0) {
								board[i][idx] = value;
								break;
							}

							if (board[i][idx - 1] != 0) {
								if (!isMerge[i][idx - 1] && board[i][idx - 1] == value) {
									isMerge[i][idx - 1] = true;
									board[i][idx - 1] += value;
								} else {
									board[i][idx] = value;
								}
								break;
							}

							idx--;
						}
					}
				}
			}
			break;
		}
	}

	private static void perm(int cnt) {
		if (cnt == 5) {
			// 맵 셋팅
			initBoard();

			for (int x : selected) {
				move(x);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, board[i][j]);
				}
			}

			return;
		}

		for (int i = 0; i < 5; i++) {
			selected[cnt] = i + 1;
			perm(cnt + 1);
		}
	}

	private static void initBoard() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(clone[i], 0, board[i], 0, N);
		}

	}
}
