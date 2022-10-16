import java.util.Scanner;

public class BOJ_2225_G5_합분해 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 1000000000;
		int N = sc.nextInt();	// 다 더했을 때 N
		int K = sc.nextInt();	// K개의 칸
		
		// dp[x][y] : x번째 칸까지 숫자를 두었고, 여태까지 사용한 숫자가 y일 때 경우의 수
		long[][] dp = new long[K][N + 1];

		// 첫 번째 칸(dp[0]) 초기화하기
		for (int i = 0; i < N + 1; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i < K; i++)				// i번째 칸에 어떤 숫자를 넣을건데,
			for (int j = 0; j < N + 1; j++)		// 여태까지 사용한 숫자가 j가 되게끔 하고 싶음
				for (int k = 0; k <= j; k++)	// 직전 칸에서 사용한 숫자가 j보다 작거나 같은 경우들을 모두 더하면 됨
					dp[i][j] += dp[i - 1][k] % n;
		
		System.out.println(dp[K - 1][N] % n);
	}
}
