package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_G5_동전 {

	static int N, K;
	static int[] dp;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		dp[0] = 1;
		for(int i=0; i<N; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = coin; j < K+1; j++) {
				dp[j] = dp[j-coin]+dp[j];
			}
		}
		
		System.out.println(dp[K]);
	}
}
