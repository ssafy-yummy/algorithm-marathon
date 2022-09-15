import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_S1_양 {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int y = 0; y < R; y++) {
			int x = 0;
			for (char c : br.readLine().toCharArray()) {
				map[y][x] = c;
				x++;
			}
		}
		
		
		// 2. 문제 풀이
		int sheep = 0;
		int wolf = 0;
		
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (!visited[y][x] && map[y][x] != '#') {
					int[] ret = bfs(y, x);	// bfs는 {양의 수, 늑대의 수}를 반환한다.
					
					if (ret[0] > ret[1]) 	// 양이 늑대보다 많다면
						sheep += ret[0];	// 양만 살아남는다.
					else 					// 늑대가 양보다 같거나 많다면
						wolf += ret[1];		// 늑대만 살아남는다.
				}
			}
		}
		
		
		// 3. 출력
		bw.write(sheep + " " + wolf);
		bw.flush();
		br.close();
		bw.close();
	}

	private static int[] bfs(int sy, int sx) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sy, sx});
		visited[sy][sx] = true;
		int sheep = 0;
		int wolf = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			if (map[y][x] == 'o') sheep++;
			if (map[y][x] == 'v') wolf++;
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
	
				if (isCoord(ny, nx) && !visited[ny][nx] && map[ny][nx] != '#') {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		
		return new int[] {sheep, wolf};
	}

	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < R && 0 <= x && x < C;
	}

}
