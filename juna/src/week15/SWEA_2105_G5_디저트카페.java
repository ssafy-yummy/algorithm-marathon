package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_G5_디저트카페 {
	
	static int N;
	static int ans;
	static int sy, sx;
	static boolean[] chk;
	static int[] dy = new int[] {1, 1, -1, -1};
	static int[] dx = new int[] {1, -1, -1, 1};
	
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			// 1. 입력 받기
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}

			
			// 2. 문제 풀이
			ans = -1;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++) {
					chk = new boolean[101];
					sy = y;
					sx = x;
					dfs(y, x, 0, 0);
				}

			
			// 3. 출력
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}
	
	
	private static void dfs(int y, int x, int k, int cnt) {
		
		if (k == 4) return ;
		
		if (y == sy && x == sx && cnt != 0) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		int ny = y + dy[k];
		int nx = x + dx[k];
		
		if (!isCoord(ny, nx)) return;
		if (chk[map[ny][nx]]) return;
		
		// map[ny][nx] 디저트를 먹었음을 표시
		chk[map[ny][nx]] = true;
		
		// 진행 방향 그대로 이동하기
		dfs(ny, nx, k, cnt + 1);
		
		// 방향 꺾기
		// 마지막 꺾기 때에는 처음 좌표와 꺾는 좌표가 같은 대각선에 있어야 됨 (백트래킹)
		if (k == 2 && ny + nx != sy + sx) {
			chk[map[ny][nx]] = false;
			return; 
		}
		
		dfs(ny, nx, k + 1, cnt + 1);
		
		// chk 배열 원상 복귀
		chk[map[ny][nx]] = false;
	}

	
	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
