import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23291_P5_어항정리 {
	
	static int N;			// 어항의 수 (4의 배수)
	static int K;			// (가장 많은 물고기 - 가장 적은 물고기)가 K 이하가 되도록 만들기
	static int[][] bowl;	// 어항이 쌓여있는 모습을 이차원 배열로 표현하였다.
	static int[] dy = new int[] {1, 0};
	static int[] dx = new int[] {0, -1};
	
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bowl = new int[10][N];	// bowl은 최대 높이 10까지 쌓일 수 있다.
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			bowl[0][i] = Integer.parseInt(st.nextToken());
		
		
		
		// 2. 문제 풀이
		int cnt = 0;
		List<Integer> minIndexes = findMin();
		
		while (true) {
			// 1단계 : 물고기가 최소인 어항 모두에 한 마리씩 넣는다.
			for (int i : minIndexes)
				bowl[0][i]++;
			
			
			// 2단계 : 가장 왼쪽에 있는 어항을 위로 올린다.
			// 3단계 : 2개 이상 쌓여있는 어항을 모두 들어올린 다음, 시계 방향으로 90도 회전한다.
			// (들어올린 어항 중 가장 오른쪽에 있는 어항의 아래에 바닥에 있는 어항이 있을 때까지)
			int n = 1;	// 들어올릴 어항들의 가로 길이
			int m = 1;	// 들어올릴 어항들의 세로 길이
			int s = 0;	// 들어올릴 어항들의 처음 x좌표
			
			while (N - s - n >= m) {
				for (int y = 0; y < m; y++) {
					for (int x = 0; x < n; x++) {
						bowl[n - x][s + n + y] = bowl[y][s + x];
						bowl[y][s + x] = 0;
					}
				}
				s += n;
				int tmp = n;
				n = m;
				m = tmp + 1;
			}
			
			
			// 4단계 : 모든 인접한 두 어항에 대해서, d = (물고기 수 차이 / 5)가 0보다 크면 d마리를 적은 곳으로 이동시킨다.
			// 제일 오른쪽 아래 끝에는 항상 어항이 놓여있으므로, 여기를 시작점으로 잡는다.
			bfs(0, N - 1);
			
			
			// 5단계 : 어항을 바닥에 일렬로 놓는다.
			setLine();
			
			
			// 6단계 : 왼쪽 절반을 들어올려서 시계 방향으로 180도 회전시켜 쌓는다. (2번)
			for (int x = 0; x < N / 2; x++) {
				bowl[1][N - 1 - x] = bowl[0][x];
				bowl[0][x] = 0;
			}

			
			for (int x = N / 2; x < N * 3 / 4; x++) {
				bowl[3][N * 3 / 2 - x - 1] = bowl[0][x];
				bowl[2][N * 3 / 2 - x - 1] = bowl[1][x];
				bowl[1][x] = bowl[0][x] = 0;
			}

			
			// 7단계 : 4단계 수행
			bfs(0, N - 1);

			
			// 8단계 : 어항을 바닥에 일렬로 놓는다.
			setLine();

			
			// while문을 탈출할 것인가?
			cnt++;
			minIndexes = findMin();
			if (findMax() - bowl[0][minIndexes.get(0)] <= K) break;
		}
		
		
		
		// 3. 정답
		System.out.println(cnt);
	}

	
	// 겹겹이 쌓여있는 어항들을 바닥에 모두 내려놓는 메서드
	private static void setLine() {
		int idx = 0;
		for (int x = 0; x < N; x++) {
			if (bowl[0][x] == 0) continue;
			
			int y = 0;
			while (y < 10) {
				if (bowl[y][x] == 0) break;
				if (bowl[0][idx] != bowl[y][x]) {
					bowl[0][idx] = bowl[y][x];
					bowl[y][x] = 0;
				}
				idx++;
				y++;
			}
		}
		
	}
	
	
	// 인접한 모든 어항들 간에 물고기를 이동시키는 메서드
	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[10][N];
		
		q.offer(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		// 물고기 이동한 결과를 담을 nbowl을 복사하기
		int[][] nbowl = new int[10][N];
		for (int y = 0; y < 10; y++)
			nbowl[y] = Arrays.copyOf(bowl[y], N);
		
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 0; k < 2; k++) {
				// (y, x)의 인접 좌표인 (ny, nx)
				int ny = y + dy[k];	
				int nx = x + dx[k];
				
				if (isCoord(ny, nx) && bowl[ny][nx] != 0) {
					// d = (물고기 수 차이 / 5)가 0보다 크면 d마리를 적은 곳으로 이동시킨다.
					int d = Math.abs(bowl[ny][nx] - bowl[y][x]) / 5;
					if (d > 0) {
						if (bowl[ny][nx] > bowl[y][x]) {
							nbowl[ny][nx] -= d;
							nbowl[y][x] += d;
						}
						else {
							nbowl[ny][nx] += d;
							nbowl[y][x] -= d;
						}
					}
					
					// (ny, nx)가 한 번도 방문한 적 없으면 큐에 넣기
					if (!visited[ny][nx]) {
						q.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		// 물고기 이동한 결과를 원래 bowl에 담기
		bowl = nbowl;
	}
	
	
	// 물고기가 제일 적은 bowl의 인덱스들을 리스트에 담아서 반환하는 메서드
	private static List<Integer> findMin() {
		int min = Integer.MAX_VALUE;
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (bowl[0][i] < min) {
				min = bowl[0][i];
				ret.clear();
				ret.add(i);
			}
			else if (bowl[0][i] == min)
				ret.add(i);
		}
		return ret;
	}
	
	
	// bowl들 중 제일 많은 물고기 수를 반환하는 메서드
	private static int findMax() {
		int max = 0;
		for (int i = 0; i < N; i++)
			if (bowl[0][i] > max)
				max = bowl[0][i];
		
		return max;
	}
	
	
	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < 10 && 0 <= x && x < N;
	}
	
	
	private static void print() {
		for (int y = 3; y >= 0; y--) {
			for (int x = 0; x < N; x++) {
				if (bowl[y][x] == 0) System.out.print("." + "\t");
				else System.out.print(bowl[y][x] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
