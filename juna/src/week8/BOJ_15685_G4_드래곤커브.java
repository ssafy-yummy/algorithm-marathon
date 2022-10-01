import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_G4_드래곤커브 {
	
	static boolean[][] map = new boolean[101][101];
	static List<int[]> list;
	static int g;

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// 시작 점의 x좌표
			int y = Integer.parseInt(st.nextToken());	// 시작 점의 y좌표
			int d = Integer.parseInt(st.nextToken());	// 시작 방향
			g = Integer.parseInt(st.nextToken());		// 세대
			
			list = new ArrayList<>();					// 여태까지 등장한 드래곤 커브 좌표들 모음
			
			
			// 2. 문제 풀이
			map[y][x] = true;			// (y, x)에 드래곤 커브가 존재함
			list.add(new int[] {y, x});	// 시작 좌표를 list에 추가
			
			switch (d) {
			case 0:
				x++;
				break;
			case 1:
				y--;
				break;
			case 2:
				x--;
				break;
			case 3:
				y++;
				break;
			}
			
			map[y][x] = true;
			list.add(new int[] {y, x});	// 0세대의 끝 좌표를 list에 추가
			
			solve(y, x, 0);
		}
		
		
		// 3. 정답 출력
		int ans = 0;
		for (int y = 0; y < 100; y++)
			for (int x = 0; x < 100; x++)
				// 네 꼭짓점이 모두 true여야 정답 조건 충족
				if (map[y][x] && map[y + 1][x] && map[y][x + 1] && map[y + 1][x + 1])
					ans++;
		
		System.out.println(ans);
	}

	
	private static void solve(int sy, int sx, int cnt) {
		// 1. 끝 점(sy, sx)를 기준으로 list에 담겨 있는 좌표들을 시계 방향으로 90도 회전시키기
		// 2. 끝 점 갱신하기 (ny, nx)
		// 3. 갱신된 끝 점으로 재귀호출하기
		
		// g세대에 도달했다면 재귀호출을 종료한다.
		if (cnt == g) return;
		
		int ny = sy;
		int nx = sx;
		
		int size = list.size();
		
		for (int i = 0; i < size; i++) {
			int dy = sy - list.get(i)[0];
			int dx = sx - list.get(i)[1];
						
			int y = sy - dx;
			int x = sx + dy;
						
			list.add(new int[] {y, x});
			map[y][x] = true;
			
			// list의 0번째 요소에는 '시작 좌표'가 들어있다.
			// '시작 좌표'를 90도 회전한 좌표는 항상 다음 번 '끝 점'이 된다.
			if (i == 0) {	
				ny = y;
				nx = x;
			}
		}
		
		solve(ny, nx, cnt + 1);
	}
	
}
