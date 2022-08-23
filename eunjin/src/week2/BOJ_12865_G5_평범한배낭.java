package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_G5_평범한배낭 {

	static int N, K;
	static int[] dp, W, V;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		W = new int[N+1];
		V = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		} // read

		for(int i=1; i<=N; i++) {
			for(int j=K; j-W[i]>=0; j--) {
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			}
		}
		
		System.out.println(dp[K]);
	}
}
