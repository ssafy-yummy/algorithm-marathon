package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_G2_2048_Easy {

	static int N, map[][], result;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of reading

		dfs(0, map);
		System.out.println(result);
	}

	private static void dfs(int cnt, int[][] map) {
		if (cnt == 5) {
			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > max) {
						max = map[i][j];
					}
				}
			}
			result = Math.max(result, max);
			return;
		}

		for (int i = 0; i < dc.length; i++) {
			int[][] temp = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					temp[j][j2] = map[j][j2];
				}
			}
			dfs(cnt + 1, move(i, temp));
		}
	}

	private static int[][] move(int direct, int[][] map) {
		if (direct == 0) {
			return up(direct, map);
		} else if (direct == 1) {
			return right(direct, map);
		} else if (direct == 2) {
			return down(direct, map);
		} else {
			return left(direct, map);
		}
	}

	private static int[][] left(int direct, int[][] map) {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] != 0) {
					int temp = map[j][i];
					int nr = j + dr[direct];
					int nc = i + dc[direct];
					while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] != 0) {
							if (map[nr][nc] == temp && !visited[nr][nc]) {
								map[nr][nc] += temp;
								map[nr - dr[direct]][nc - dc[direct]] = 0;
								visited[nr][nc] = true;
							}
							break;
						}
						map[nr][nc] = temp;
						map[nr - dr[direct]][nc - dc[direct]] = 0;
						nr += dr[direct];
						nc += dc[direct];
					}
				}
			}
		}
		return map;
	}

	private static int[][] down(int direct, int[][] map) {
		visited = new boolean[N][N];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int temp = map[i][j];
					int nr = i + dr[direct];
					int nc = j + dc[direct];
					while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] != 0) {
							if (map[nr][nc] == temp && !visited[nr][nc]) {
								map[nr][nc] += temp;
								map[nr - dr[direct]][nc - dc[direct]] = 0;
								visited[nr][nc] = true;
							}
							break;
						}
						map[nr][nc] = temp;
						map[nr - dr[direct]][nc - dc[direct]] = 0;
						nr += dr[direct];
						nc += dc[direct];
					}
				}
			}
		}
		return map;
	}

	private static int[][] right(int direct, int[][] map) {
		visited = new boolean[N][N];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] != 0) {
					int temp = map[j][i];
					int nr = j + dr[direct];
					int nc = i + dc[direct];
					while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] != 0) {
							if (map[nr][nc] == temp && !visited[nr][nc]) {
								map[nr][nc] += temp;
								map[nr - dr[direct]][nc - dc[direct]] = 0;
								visited[nr][nc] = true;
							}
							break;
						}
						map[nr][nc] = temp;
						map[nr - dr[direct]][nc - dc[direct]] = 0;
						nr += dr[direct];
						nc += dc[direct];
					}
				}
			}
		}
		return map;
	}

	private static int[][] up(int direct, int[][] map) {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int temp = map[i][j];
					int nr = i + dr[direct];
					int nc = j + dc[direct];
					while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] != 0) {
							if (map[nr][nc] == temp && !visited[nr][nc]) {
								map[nr][nc] += temp;
								map[nr - dr[direct]][nc - dc[direct]] = 0;
								visited[nr][nc] = true;
							}
							break;
						}
						map[nr][nc] = temp;
						map[nr - dr[direct]][nc - dc[direct]] = 0;
						nr += dr[direct];
						nc += dc[direct];
					}
				}
			}
		}
		return map;
	}

}
