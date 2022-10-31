import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_G5_주사위쌓기 {
	
	static int N;
	static int ans;
	static int[][] dice;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 주사위 개수
		dice = new int[N][7];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			dice[i][a] = f;	// 숫자 a의 반대쪽 면은 f
			dice[i][b] = d;
			dice[i][c] = e;
			dice[i][d] = b;
			dice[i][e] = c;
			dice[i][f] = a;
		}
		
		
		// 2. 문제 풀이
		for (int i = 1; i < 7; i++)
			solve(0, i, 0);
		
		
		// 3. 정답
		System.out.println(ans);
	}
	
	
	// 여태껏 쌓은 주사위의 한쪽 면 숫자 합은 tot이고, cnt번째 주사위의 아랫면 숫자를 down으로 하여 쌓는다.
	private static void solve(int cnt, int down, int tot) {
		
		// N개의 주사위를 모두 쌓았다면, 정답을 갱신
		if (cnt == N) {
			ans = Math.max(ans, tot);
			return ;
		}
		
		// 아랫면 숫자(down)과 윗면 숫자(dice[cnt][down])을 제외한 숫자들 중, 최댓값 찾기
		int max = 0;
		for (int i = 1; i < 7; i++) 
			if (i != down && i != dice[cnt][down])
				max = Math.max(max, i);
		
		// 재귀호출
		solve(cnt + 1, dice[cnt][down], tot + max);
	}

}
