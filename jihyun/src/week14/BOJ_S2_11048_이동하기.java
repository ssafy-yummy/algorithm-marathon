package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_11048_이동하기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];

		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<m+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				dp[i][j]=map[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		//어차피 오른쪽이나 아래로 갈 수 있으므로 대각선은 고려하지 않아도 된다. 
		//따라서 ij칸의 최대값은 윗칸과 왼쪽칸의 값을 비교하여 구한다.

		System.out.println(dp[n][m]);
	}
}
