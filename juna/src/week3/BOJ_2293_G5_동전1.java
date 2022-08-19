import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2293_G5_동전1 {
	
	static int n, k;
	static int[] coin;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		// 2. 풀이
		solve();
		
		// 3. 출력
		System.out.println(dp[k]);
	}

	private static void solve() {
		
		//Arrays.sort(coin);
		
		for (int i = 0; i < n; i++) 
			for (int j = coin[i]; j <= k; j++)
				dp[j] += dp[j - coin[i]];
	}
}