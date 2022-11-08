import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_G4_빙산 {
	
	static int N;	// 행 수
	static int M;	// 열 수
	static int[][] map, nmap;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		
		// 2. 문제 풀이
		int time = 0;
		while (true) {
			time++;
			
			// 1단계 - 얼음 녹이기
			int sy = -1;
			int sx = -1;
			
			// 얼음을 녹이는 bfs 문을 돌기 위해 시작 좌표(sy, sx) 찾기
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (map[y][x] != 0) {
						sy = y;
						sx = x;
						break;
					}
			
			// 덩어리가 2개 이상이 되기 전에 모든 얼음이 다 녹았다면 정답은 0
			if (sy == -1) {
				time = 0;
				break;
			}
			
			// 얼음 녹이기
			bfs1(sy, sx);
			
			
			
			
			// 2단계 - 덩어리가 2개 이상인지 체크하기
			int cnt = 0;
			boolean[][] visited = new boolean[N][M];
			
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (!visited[y][x] && map[y][x] > 0) {
						cnt++;
						bfs2(y, x, visited);
					}
			
			
			if (cnt > 1) break;
		}
		
		System.out.println(time);
	}


	// 빙산 덩어리 개수를 구하기 위한 메서드
	private static void bfs2(int sy, int sx, boolean[][] visited) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (!isCoord(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
				
				q.offer(new int[] {ny, nx});
				visited[ny][nx] = true;
			}
		}
	}
	
	// 얼음 녹이는 메서드
	private static void bfs1(int sy, int sx) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		nmap = new int[N][M];
		for (int y = 0; y < N; y++)
			nmap[y] = Arrays.copyOf(map[y], M);
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (!isCoord(ny, nx) || visited[ny][nx]) continue;
				
				// 상하좌우에 0이 있으면 현재의 얼음(y, x) 녹이기
				if (map[ny][nx] == 0) {
					if (nmap[y][x] > 0)
						nmap[y][x]--;
				}
				// 0이 아니라면, 해당 좌표를 bfs 탐색이 될 수 있도록 큐에 넣어주기
				else {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		
		for (int y = 0; y < N; y++)
			map[y] = Arrays.copyOf(nmap[y], M);
	}

	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}

}
