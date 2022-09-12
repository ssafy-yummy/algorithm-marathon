package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class BOJ_12865_G5_평범한배낭 {
 
	static int[][] dp;
	static int[] W; // weight
	static int[] V; // value
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		W = new int[N];
		V = new int[N];
 
		dp = new int[N][K + 1];
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(N - 1, K));
 
	}
 
	static int knapsack(int i, int k) {
		// Base condition
		if (i < 0)
			return 0;
		
		// 탐색 안 했을 때.
		if (dp[i][k] == 0) {
			
			// 추가 불가능
			if(W[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			// 추가 가능
			else {
				// 값 비교
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}
}