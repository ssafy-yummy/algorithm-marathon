import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_S1_쿼드트리 {
	
	static int[][] board;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (char c : br.readLine().toCharArray()) {
				board[i][j] = c - '0';
				j++;
			}
		}
		
		// 2. 풀이
		solve(0, 0, N);
		
		// 3. 출력
		System.out.println(sb);
	}

	private static void solve(int sy, int sx, int d) {
		if (d == 1) {
			sb.append(board[sy][sx]);
			return;
		}
		
		boolean index = true;
		for (int y = sy; y < sy + d; y++) {
			for (int x = sx; x < sx + d; x++)
				if (board[y][x] != board[sy][sx]) { 
					index = false;
					break;
				}
			if (!index) break;
		}
		
		if (index)
			sb.append(board[sy][sx]);
		else {
			sb.append("(");
			d /= 2;
			solve(sy, sx, d);
			solve(sy, sx + d, d);
			solve(sy + d, sx, d);
			solve(sy + d, sx + d, d);
			sb.append(")");
		}
	}
}
