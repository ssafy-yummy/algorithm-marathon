package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_S2_이동하기 {
	
	static int N;	// 행 수
	static int M;	// 열 수
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) 
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		
		// 2. 문제 풀이
		for (int y = 0; y < N; y++)
			for (int x = 0; x < M; x++)
				// dp[y][x] = map[y][x] + Math.max(dp[y - 1][x], dp[y][x - 1]);	 에서 y와 x가 각각 0일 경우를 고려하기
				dp[y][x] = map[y][x] + Math.max(y == 0 ? 0 : dp[y - 1][x], x == 0 ? 0 : dp[y][x - 1]);
		
		
		// 3. 정답
		System.out.println(dp[N - 1][M - 1]);
	}

}
