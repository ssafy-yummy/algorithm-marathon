package hanmin.src.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12865_G5_평범한배낭 {
	static int[] dp;
	static int[] W;
	static int[] V;
	static int N;
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		// n 100
		// k,w 100000
		// v 1000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N];
		V = new int[N];
		dp = new int[K + 1];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		// dp 최대의 값
		// 중복되지 않아야함
		// dp[i] = 무게 i일 때 가능한 최댓값
		// dp[i] = dp[i], dp[i-w]+v 
		for (int i = 0; i < N; ++i) {
			for (int j = K; j > 0; --j) {
				if (j - W[i] >= 0)
					dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
			}
		}
		System.out.println(dp[K]);

	}
}
