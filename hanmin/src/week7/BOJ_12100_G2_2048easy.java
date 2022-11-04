package hanmin.src.week7;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12100_G2_2048easy {
	// 상하좌우 5번 dep 이동
	// 모든 블록은 최대로 이동
	// 이동시킨 문자가 같다면 합침
	// 이미 합쳐진 블록은 중복 불가
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		func(0, map);
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int n, int[][] map) {
		if (n == 5) {
			// 최대 갯수 카운트
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] > answer)
						answer = map[i][j];
				}
			}
			return;
		}
		for (int dir = 0; dir < 4; ++dir) {
			// system.arraycopy로 복사 후 회전
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; ++i)
				System.arraycopy(map[i], 0, tmp[i], 0, N);
			moveBlock(tmp, dir);
			func(n + 1, tmp);
		}
	}

	private static void moveBlock(int[][] map, int dir) {
		Queue<Integer> q = new LinkedList<>();
		switch (dir) {
		case 0:
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[j][i] != 0)
						q.offer(map[j][i]);
					map[j][i] = 0;
				}
				int idx = 0;

				while (!q.isEmpty()) {
					int now = q.poll();
					if (map[idx][i] == 0)
						map[idx][i] = now;
					else if (map[idx][i] == now) {
						map[idx][i] *= 2;
						idx++;
					} else
						map[++idx][i] = now;
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; ++i) {
				for (int j = N - 1; j >= 0; --j) {
					if (map[i][j] != 0)
						q.offer(map[i][j]);
					map[i][j] = 0;
				}
				int idx = N - 1;

				while (!q.isEmpty()) {
					int now = q.poll();
					if (map[i][idx] == 0)
						map[i][idx] = now;
					else if (map[i][idx] == now) {
						map[i][idx] *= 2;
						idx--;
					} else
						map[i][--idx] = now;

				}
			}
			break;
		case 2:
			for (int i = 0; i < N; ++i) {
				for (int j = N - 1; j >= 0; --j) {
					if (map[j][i] != 0)
						q.offer(map[j][i]);
					map[j][i] = 0;
				}
				int idx = N - 1;

				while (!q.isEmpty()) {
					int now = q.poll();
					if (map[idx][i] == 0)
						map[idx][i] = now;
					else if (map[idx][i] == now) {
						map[idx][i] *= 2;
						idx--;
					} else
						map[--idx][i] = now;
				}
			}
			break;
		case 3:
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] != 0)
						q.offer(map[i][j]);
					map[i][j] = 0;
				}
				int idx = 0;

				while (!q.isEmpty()) {
					int now = q.poll();
					if (map[i][idx] == 0)
						map[i][idx] = now;
					else if (map[i][idx] == now) {
						map[i][idx] *= 2;
						idx++;
					} else
						map[i][++idx] = now;
				}
			}
			break;
		}
	}
}
