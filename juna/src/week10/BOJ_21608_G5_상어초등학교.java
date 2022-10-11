import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21608_G5_상어초등학교 {
	
	static int N;
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[] dx = new int[] {0, 0, 1, -1};
	
	static class Position implements Comparable<Position> {
		int y;
		int x;
		int blank;
		int friend;
		
		public Position(int y, int x, int blank, int friend) {
			this.y = y;
			this.x = x;
			this.blank = blank;
			this.friend = friend;
		}

		@Override
		public int compareTo(Position o) {
			
			// 1. 친구랑 가장 많이 인접해 있는 칸
			if (this.friend != o.friend)
				return Integer.compare(o.friend, this.friend);
			
			// 2. 1번이 여러 개라면 비어있는 인접 칸이 많은 칸
			else if (this.blank != o.blank)
				return Integer.compare(o.blank, this.blank);
			
			// 3. 2번도 여러 개라면 y값, x값이 가장 작은 칸
			else if (this.y != o.y)
				return Integer.compare(this.y, o.y);
			
			return Integer.compare(this.x, o.x);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());				// 학생 수
		int[][] map = new int[N][N];						// 자리 배치도
		int[][] friend = new int[N * N + 1][4];				// friend[x] : x의 친구 4명 배열
		Queue<Integer> order = new LinkedList<>();			// 자리 배치할 학생들의 순서
		PriorityQueue<Position> pq = new PriorityQueue<>();	// 나중에 자리 배치할 때 쓰일 우선순위 큐
		
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++)
				friend[me][j] = Integer.parseInt(st.nextToken());
			
			order.offer(me);
		}
		
		
		// 2. 문제 풀이
		for (int me : order) {	// me를 배치할 것이다.
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					// (y, x) 좌표에 me가 배치될 수 있을까?
					
					if (map[y][x] != 0) continue;	// 빈 칸인 경우만 탐색하기
					
					int cntOfFriend = 0;	// 인접 칸에 친구가 몇 명인지
					int cntOfBlank = 0;		// 인접 칸에 빈 칸이 몇 개인지
					
					for (int k = 0; k < 4; k++) {
						// (y, x)의 인접 칸인 (ny, nx)
						int ny = y + dy[k];
						int nx = x + dx[k];
						
						if (!chk(ny, nx)) continue;
						
						// 인접 칸이 빈 칸인가?
						if (map[ny][nx] == 0) {
							cntOfBlank++;
							continue;
						}
						
						// 인접 칸에 me의 친구가 있는가?
						for (int f : friend[me]) {
							if (map[ny][nx] == f) {
								cntOfFriend++;
								break;
							}
						}
					}
					
					pq.add(new Position(y, x, cntOfBlank, cntOfFriend));
					
				}
			}
			
			Position pos = pq.poll();	// 우선순위 큐에서 me가 들어갈 좌표를 정렬하여 찾아줌  
			map[pos.y][pos.x] = me;
			pq.clear();
		}
		
		
		// 3. 정답 출력하기
		int ans = 0;
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				
				int cnt = 0;	// 인접한 친구의 수
				int me = map[y][x];
				
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if (!chk(ny, nx)) continue;
					
					for (int f : friend[me]) {
						if (map[ny][nx] == f) {
							cnt++;
							break;
						}
					}
				}
				
				switch (cnt) {
				case 2:
					cnt = 10;
					break;
				case 3:
					cnt = 100;
					break;
				case 4:
					cnt = 1000;
					break;
				}
				
				ans += cnt;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean chk(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
