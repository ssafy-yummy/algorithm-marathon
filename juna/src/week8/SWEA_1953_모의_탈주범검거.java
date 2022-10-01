import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_모의_탈주범검거 {

	static int N;	// 지도의 세로 크기
	static int M;	// 지도의 가로 크기
	static int R;	// 맨홀의 y좌표
	static int C;	// 맨홀의 x좌표
	static int L;	// 탈출 후 소요된 시간
	static int ans;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static HashMap<Integer, HashSet<Integer>> target;
	
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 상(0), 하(1), 좌(2), 우(3)로 움직일 수 있으려면
		// 이동하는 곳의 구조물 타입은 각각 다음과 같아야한다.
		// 나중에 bfs 메서드에서 다음 위치로 이동 가능한지 따질 때 사용됨.
		target = new HashMap<>();
		target.put(0, new HashSet<>(Arrays.asList(1, 2, 5, 6)));
		target.put(1, new HashSet<>(Arrays.asList(1, 2, 4, 7)));
		target.put(2, new HashSet<>(Arrays.asList(1, 3, 4, 5)));
		target.put(3, new HashSet<>(Arrays.asList(1, 3, 6, 7)));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			// 1. 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			
			// 2. 문제 풀이
			bfs(R, C);
			
			
			// 3. 정답 출력
			bw.append("#" + tc + " " + ans + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void bfs(int sy, int sx) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.offer(new int[] {sy, sx, 1});
		visited[sy][sx] = true;
		ans = 1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];	// 현재 y좌표
			int x = cur[1];	// 현재 x좌표
			int t = cur[2];	// 여태까지 걸린 시간
			
			// 현재 위치에서 이동가능한 방향(0 ~ 3)을 담는 배열
			int[] K = new int[] {-1};	
			
			switch (map[y][x]) {
			case 1:		// 상하좌우
				K = new int[] {0, 1, 2, 3};
				break;
			case 2:		// 상하
				K = new int[] {0, 1};
				break;
			case 3:		// 좌우
				K = new int[] {2, 3};
				break;
			case 4:		// 상우
				K = new int[] {0, 3};
				break;
			case 5:		// 하우
				K = new int[] {1, 3};
				break;
			case 6:		// 하좌
				K = new int[] {1, 2};
				break;
			case 7:		// 상좌
				K = new int[] {0, 2};
				break;
			}
			
			for (int k : K) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				int nt = t + 1;
				
				if (chk(ny, nx) && !visited[ny][nx] && target.get(k).contains(map[ny][nx]) && nt <= L) {
					ans++;
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx, nt});
				}
			}
		}
	}

	private static boolean chk(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}

}
