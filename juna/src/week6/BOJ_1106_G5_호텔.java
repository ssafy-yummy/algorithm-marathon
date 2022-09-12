import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1106_G5_호텔 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());	// 목표 고객 수
		int N = Integer.parseInt(st.nextToken());	// 도시의 개수
		
		int[][] dp = new int[N][100001];	// dp[x][y] : x번째 도시까지 탐색했고, 그 때의 비용이 y일 때 최대 고객 수
		int[] weight = new int[N];			// 홍보 비용
		int[] value = new int[N];			// 얻을 수 있는 고객 수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 2. 문제 풀이		
		// dp[0] 배열 채워주기
		int k = 0;
		int w = weight[0];
		int v = value[0];
		while (w * k < 100001) {
			dp[0][w * k] = v * k;
			k++;
		}
		
		
		// dp[1] ~ dp[N - 1] 배열 채워주기
		for (int i = 1; i < N; i++) {	// i : 현재 탐색 중인 도시
			
			w = weight[i];	// 현재 탐색 중인 도시의 비용
			v = value[i];	// 현재 탐색 중인 도시의 고객 수

			for (int j = 0; j < 100001; j++) {	// j : 가능한 모든 비용
				
				k = 0;
				
				while (j + w * k < 100001) {	// 비용은 최대 100000을 넘길 수 없다.
					
					dp[i][j + w * k] = Math.max(dp[i][j + w * k], dp[i - 1][j] + v * k);
					// dp[i - 1][j]	: 현재 탐색 중인 도시를 포함하기 전, 비용 j로 얻을 수 있는 고객 수
					// v * k		: 현재 탐색 중인 도시에 홍보를 k번 할 경우 얻을 수 있는 고객 수
					// 위 두 값을 합치면 dp[i][j + w * k]이 된다.
					
					
					if (dp[i][j + w * k] >= C) break;
					// 고객 수가 목표치인 C를 넘어서면 더 이상 탐색을 할 필요가 없다.
					
					k++;
				}
			}
		}
		
		
		// 3. 정답 출력
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 100001; j++)
				if (dp[i][j] >= C) {
					ans = Math.min(ans, j);
					break;
				}
		System.out.println(ans);
	}
}