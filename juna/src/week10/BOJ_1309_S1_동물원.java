import java.util.Scanner;

public class BOJ_1309_S1_동물원 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] dp = new int[N][3];
		// dp[x][0] : x번째 칸에 사자를 두지 않을 때, 가능한 경우의 수
		// dp[x][1] : x번째 칸에 사자를 윗 칸에 둘 때, 가능한 경우의 수
		// dp[x][2] : x번째 칸에 사자를 아랫 칸에 둘 때, 가능한 경우의 수
		
		dp[0][0] = dp[0][1] = dp[0][2] = 1;
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
		
		int ans = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901;
		System.out.println(ans);
	}

}