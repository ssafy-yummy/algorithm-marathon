import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_S2_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		
		// 2. 문제 풀이
		int ans = 0;
		// dp[x] : x번째까지 탐색했을 때, x번째 숫자를 반드시 포함하면서 가장 긴 증가하는 부분 수열의 길이
		int[] dp = new int[N];
		// 각각의 요소들에 관하여, 부분 수열의 길이는 반드시 1이상이다(자기자신). 따라서 1로 초기화시켜주고 시작
		Arrays.fill(dp, 1);
		
		// 현재 보고 있는 숫자는 i번째 숫자
		for (int i = 0; i < N; i++) {
			// i보다 이전에 있는 j번째 숫자에 관하여
			for (int j = 0; j < i; j++) {
				// 증가하는 부분 수열을 만족한다면 
				if (a[j] < a[i])
					// 가장 긴 증가하는 부분 수열 길이를 갱신
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		
		// 3. 출력
		System.out.println(ans);
	}
}
