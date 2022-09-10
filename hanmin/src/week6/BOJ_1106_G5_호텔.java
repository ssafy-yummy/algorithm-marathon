package hanmin.src.week6;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1106_G5_호텔 {
	static int[][] arr;
	static int[] dp;
	static int N;
	static int C;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][2];
		dp = new int[C + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// start
		// dp[i]=i명을 늘리기 위한 돈의 최솟값
		// i명마다 N번 돌며 최솟값 비교
		dp[0] = 0;
		for (int j = 1; j <= C; j += 1) {
			for (int i = 0; i < N; ++i) {
				if (j - arr[i][1] < 0) {
					dp[j] = Math.min(dp[j], arr[i][0]);

				} else {
					dp[j] = Math.min(dp[j], dp[j - arr[i][1]] + arr[i][0]);
				}
			}
		}

		// end

		// 출력
		System.out.println(dp[C]);
	}
}
