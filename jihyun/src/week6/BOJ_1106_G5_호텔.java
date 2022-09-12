package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1106_G5_호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] money = new int[m+1];
		int[] people = new int[m+1];
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1;i<m+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			money[i]=Integer.parseInt(st.nextToken());
			people[i]=Integer.parseInt(st.nextToken());
		}
		for(int j=1;j<n+1;j++) { //비교할때 필요한 값. 최대값으로 초기화해둔다.
			dp[0][j]=Integer.MAX_VALUE;
		}
		for(int i=1;i<m+1;i++) { //얼마에 몇명의 고객에 대한 정보를 통해
			for(int j=1;j<n+1;j++) { //1명~n명까지 필요한 최소 금액 구하기
				if(people[i]>=j)  //제시한 고객의 수가 현재 목표 고객수보다 크면
					dp[i][j]=Math.min(dp[i-1][j], money[i]); //이전까지의 최소 금액과 이번 고객의 금액을 비교한다.
				else {
					dp[i][j]=Math.min(dp[i-1][j], dp[i][j-people[i]]+money[i]);
				}
			}
		}
		System.out.println(dp[m][n]);

	}

}
