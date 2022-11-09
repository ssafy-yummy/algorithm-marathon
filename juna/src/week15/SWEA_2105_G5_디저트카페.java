package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_2105_G5_디저트카페 {
	
	static int N;
	static int ans;
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
				for (int x = 0; x < N; x++)
					bfs(y, x);

			
			// 3. 출력
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}
	

	
	private static void bfs(int sy, int sx) {		
		Queue<int[]> q = new LinkedList<>();
		Queue<Set<Integer>> q2 = new LinkedList<>();
		
		q.offer(new int[] {sy, sx, 0});	
		q2.offer(new HashSet<>());		// set 전달용 큐
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int k = cur[2];		// 현재 이동 방향
			Set<Integer> set = q2.poll();	// 여태까지 먹은 디저트
			
			// 한 바퀴 돌아서 처음 위치에 도착
			if (y == sy && x == sx && k != 0) {
				ans = Math.max(ans, set.size());
				continue;
			}
			
			if (k == 4) continue;
			
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if (!isCoord(ny, nx)) continue;	// 맵을 벗어나면 안 됨
			if (set.contains(map[ny][nx])) continue;	// 이미 먹은 디저트면 안 됨
			
			Set<Integer> nset = new HashSet<>();
			nset.addAll(set);
			nset.add(map[ny][nx]);
			
			// 진행하던 방향으로 그대로 진행하기
			q.offer(new int[] {ny, nx, k});
			q2.offer(nset);
			
			// 방향 꺾기
			if (k == 2 && ny + nx != sy + sx) continue;	// 마지막으로 방향을 꺾을 때는 백트래킹 적용
			q.offer(new int[] {ny, nx, k + 1});
			q2.offer(nset);
		}
	}

	
	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
