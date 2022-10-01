import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_G2_2048Easy {
	
	static int N, ans;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		// 가능한 경우의 수 4 ^ 5 = 1024 가지
		solve(0, map);
		System.out.println(ans);
	}

	private static void solve(int cnt, int[][] map) {
		
		// 5번 모두 밀어봤으면 최댓값(정답) 갱신하기
		if (cnt == 5) {
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					ans = Math.max(ans, map[y][x]);
		}
		
		else {
			// map을 90도씩 회전시켜서 왼쪽 방향으로만 밀어주기 (총 4회)
			
			// map을 회전시키기 전에 밀기 (1회)
			solve(cnt + 1, moveLeft(map));
			
			// map을 회전시키고 나서 밀기 (3회)
			for (int i = 0; i < 3; i++) {
				map = rotate(map);
				solve(cnt + 1, moveLeft(map));
			}
		}
		
	}
	
	
	// 90도 회전시키기
	private static int[][] rotate(int[][] map) {
		int[][] ret = new int[N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) 
				ret[i][j] = map[j][N - 1 - i];
			
		return ret;
	}

	
	// 왼쪽 방향으로 밀기
	private static int[][] moveLeft(int[][] map) {
		
		// map 전체를 왼쪽 방향으로 민 결과를 담을 새로운 2차원 배열
		int[][] ret = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			
			int[] row = new int[N];	// y번째 행을 왼쪽으로 민 결과를 담을 1차원 배열 
			boolean idx = false;	// 이전 숫자와 합쳐질 수 있는가?
			int i = 0;				// 현재 숫자는 어느 위치에 이동하게 되는가?
			
			for (int x : map[y]) {
				if (x == 0) continue;
				
				if (idx && row[i - 1] == x) {	// 이전의 숫자(row[i - 1])와 합치기
					
					row[i - 1] += x;
					idx = false;	
				}
				else {							// 새로운 위치(row[i])에 숫자 놓기
					row[i++] = x;
					idx = true;
				}
			}
			
			// y번째 행을 왼쪽으로 미는 것이 끝났으면, 그 결과(row)를 ret의 y번째 행에 저장한다.
			ret[y] = row;
		}
		
		return ret;
	}
}