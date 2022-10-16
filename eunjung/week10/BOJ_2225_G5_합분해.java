package week10;

import java.io.*;
import java.util.*;

public class BOJ_2225_G5_합분해 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			dp[1][i] = 1;
		} // K가 1일때, N이 되는 식은 1개 뿐
		for (int i = 0; i <= K; i++) {
			dp[i][0] = 1;
		} // N이 0일때, K로 나타낼 수 있는 식은 1개 뿐
		
		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % 1000000000;
			}
		} // 점화식을 이용한 계산
		
		System.out.println(dp[K][N]);
 	}

}