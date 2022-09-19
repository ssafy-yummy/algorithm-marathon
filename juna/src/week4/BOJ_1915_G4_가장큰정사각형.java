import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_G4_가장큰정사각형 {
	
	static int[][] board;
	static int[][] dp;		// dp[y][x]의 의미 : 좌표 (y, x)에서 '왼쪽과 위쪽' 방향으로 만들 수 있는 가장 큰 정사각형의 변 길이
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		dp = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			int x = 0;
			for (char c : br.readLine().toCharArray()) {
				board[y][x] = c - '0';
				x++;
			}
		}
		
		
		// 2. 풀이
		int ans = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				
				if (y * x == 0)
					dp[y][x] = board[y][x];

				// 현재 좌표의 바로 '왼쪽', '위', '왼쪽 위' 좌표들 중에서 제일 작은 값에 +1 한 값을 저장한다.
				else if (board[y][x] == 1)		
					dp[y][x] = 1 + Math.min(dp[y - 1][x - 1], Math.min(dp[y - 1][x], dp[y][x - 1]));
					
				ans = Math.max(ans, dp[y][x]);
			}
		}
		
		
		// 3. 정답 출력
		System.out.println(ans * ans);
	}
}