package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_S1_동물원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		dp[0][0]=1;
		for(int i=1;i<n+1;i++) { //0:둘다 비었음 1:왼쪽 채움 2:오른쪽 채움
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901; //이번칸에 둘다 비울꺼면 윗칸에서 0,1,2 가능
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901; //이번칸에 왼쪽을 채울꺼면 윗칸에서 0,2 가능
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901; //이번칸에 오른쪽을 채울거면 윗칸에서 0,1 가능
		}
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%9901);

	}

}
