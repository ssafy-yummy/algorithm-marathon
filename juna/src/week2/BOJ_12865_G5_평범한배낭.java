import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_G5_평범한배낭 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] stuff = new int[N + 1][2];
		int[][] dp = new int[N + 1][K + 1];	
		/*
		 * dp[i][j] = k 의미
		 * i번째 물건까지 가방에 담기를 끝냈을 때 (i번째 물건을 반드시 담는다는 뜻이 아님)
		 * 가방의 무게가 j라면
		 * 그 때의 가방의 가치 합의 최댓값은 k이다.
		 * */
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			int w = stuff[i][0];
			int v = stuff[i][1];
			
			for (int j = 0; j <= K; j++) {
				// i번째 물건을 담았을 때
				if (j + w <= K) dp[i][j + w] = dp[i - 1][j] + v;
				// i번째 물건을 담지 않았을 때
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}
		
		int ans = 0;
		for (int i = 0; i <= K; i++)
			ans = Math.max(ans, dp[N][i]);
		
		System.out.println(ans);
	}
}
