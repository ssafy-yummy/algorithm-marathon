import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_D4_수영대회결승전 {
	
	static int N;
	static int ans;
	static int[][] map;
	static final int[] dy = new int[] {0, 1, -1, 0, 0};
	static final int[] dx = new int[] {0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			map[ey][ex] = 10;
			
			ans = -1;
			bfs(sy, sx);
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][N][3];
		
		q.offer(new int[] {sy, sx, 0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int t = cur[2];
			visited[y][x][t % 3] = true;
			
			if (map[y][x] == 10) {
				ans = t;
				break;
			}
			
			for (int k = 0; k < 5; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				int nt = t + 1;
				
				if (!isCoord(ny, nx) || map[ny][nx] == 1 || visited[ny][nx][nt % 3]) continue;
				if (k != 0 && map[ny][nx] == 2 && nt % 3 != 0) continue;
					
				q.offer(new int[] {ny, nx, nt});
			
			}
		}
	}

	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
