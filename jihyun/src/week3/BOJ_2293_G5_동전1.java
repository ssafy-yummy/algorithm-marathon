package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_G5_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1];
		for(int i=1;i<n+1;i++) { //0,1,2,5
			coin[i]=Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n+1][k+1];
		for(int i=1;i<n+1;i++) { //n개의 동전 개수 초기화
			dp[i][0]=1;
		}
		for(int i=1;i<n+1;i++) { //동전 종류 n개에 대해
			for(int j=1;j<k+1;j++) { //1원부터 k원까지
				if(coin[i]>j) //현재 동전이 필요한 금액보다 크면 이전 동전에 사용된 개수를 똑같이 사용
					dp[i][j]=dp[i-1][j];
				else { //이전 동전에 사용된 개수에, 목표금액에서 현재 동전의 뺀 만큼이 가지는 동전이 사용된 개수를 더한다.
					dp[i][j]= dp[i-1][j] + dp[i][j-coin[i]];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
	/*
	 *         <dp표>
	 *   0 1 2 3 4 5 6 7 8 9 10
	 * 0 0 0 0 0 0 0 0 0 0 0 0 
	 * 1 1 1 1 1 1 1 1 1 1 1 1 
	 * 2 1 1 2 2 3 3 4 4 5 5 6
	 * 5 1 1 2 2 3 4 5 6 7 8 10
	 */
}
