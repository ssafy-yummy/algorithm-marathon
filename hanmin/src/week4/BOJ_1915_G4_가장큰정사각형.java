package hanmin.src.week4;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1915_G4_가장큰정사각형 {
	static char[][] map;
	static int[][] dp;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; ++j) {
				dp[i][j] = map[i][j] - '0';
				if (dp[i][j] == 1)
					answer = 1;
			}
		}
		// start
		// i-1,j i,j-1 i-1,j-1 을 비교하며 최솟값 계산
		for (int i = 1; i < N; ++i) {
			for (int j = 1; j < M; ++j) {
				dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				if (map[i][j] == '0')
					dp[i][j] = 0;
				answer = Math.max(answer, dp[i][j] * dp[i][j]);
			}
		}

		// end

		// 출력
		System.out.println(answer);

	}
}
