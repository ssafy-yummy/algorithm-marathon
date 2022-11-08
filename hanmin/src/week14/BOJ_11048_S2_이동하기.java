package hanmin.src.week14;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11048_S2_이동하기 {
	static int[] dx = { -1, 0, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, -1, 1, -1, 1, -1, 1, -1 };
	static int[][] map;
	static int[][] dp;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		dp[0][0] = map[0][0];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				//아래로 이동하는 경우, 오른쪽으로 이동하는 경우
				//대각선의 경우 map의 값이 음수가 아닌이상 최선의 경우가 될 수 없음
				for (int dir = 0; dir < 2; ++dir) {
					int px = j + dx[dir];
					int py = i + dy[dir];
					if (px < 0 || py < 0)
						continue;
					dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[py][px]);
				}

			}
		}

		// end

		// 출력
		System.out.println(dp[N - 1][M - 1]);
	}
}
