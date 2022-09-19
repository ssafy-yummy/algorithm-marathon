import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {
	
	static int N, M, r, c, d, ans;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행 수
		M = Integer.parseInt(st.nextToken());	// 열 수
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());	// 현재 위치 행
		c = Integer.parseInt(st.nextToken());	// 현재 위치 열
		d = Integer.parseInt(st.nextToken());	// 현재 바라보는 방향 (북, 동, 남, 서)
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		
		// 문제 풀이
		clean(r, c, d, 0);
		
		// 출력
		System.out.println(ans);
	}

	private static void clean(int y, int x, int d, int cnt) {
		
		ans++;
		visited[y][x] = true;
		
		while (true) {
			
			int left = d > 0 ? (d - 1) % 4 : 3;	// 현재 방향에서 왼쪽 방향
			int back = (d + 2) % 4;				// 현재 방향에서 뒤쪽 방향
			
			int ly = y + dy[left];	// 왼쪽 y좌표
			int lx = x + dx[left];	// 왼쪽 x좌표
			
			int by = y + dy[back];	// 뒤쪽 y좌표
			int bx = x + dx[back];	// 뒤쪽 x좌표
			
			// 2-1. 왼쪽 방향에 청소하지 않은 공간이 존재한다면
			if (map[ly][lx] == 0 && !visited[ly][lx]) {
				
				y = ly;		// 왼쪽으로 이동
				x = lx;
				d = left;	// 왼쪽으로 방향 전환
				cnt = 0;
				
				// 1. 현재 위치를 청소한다.
				ans++;
				visited[y][x] = true;
			}
			// 2-2. 왼쪽 방향에 청소할 공간이 없다면
			else if (cnt < 4 && (map[ly][lx] == 1 || visited[ly][lx])) {
				
				d = left;	// 왼쪽으로 방향 전환
				cnt += 1;	// 이동할 수 없는 방향 갯수 +1
			}
			// 2-3. 네 방향 모두 청소가 되어있거나 벽이면서 후진이 가능할 경우
			else if (cnt == 4 && map[by][bx] == 0) {
				
				y = by;		// 뒤로 이동
				x = bx;
				cnt = 0;
			}
			else {
				
				break;
			}
		}
	}
}
