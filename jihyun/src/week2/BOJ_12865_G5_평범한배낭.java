package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_G5_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				if(W[i]>j) //넣을 물건이 배낭의 무게 보다 작다면, 전에 구해놓은 최대가치를 사용
					dp[i][j] = dp[i-1][j];
				else //i번째 가방을 넣었을 경우의 가치와, 그 전까지 구한 최대가치를 비교한다.
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
			}
		}
		
//		for(int i=0;i<N+1;i++)
//			System.out.println(Arrays.toString(dp[i]));
		
		System.out.println(dp[N][K]); //N개의 가방을 K무게를 넘지 않도록 탐색했을때 나오는 최대가치 

	}

}
