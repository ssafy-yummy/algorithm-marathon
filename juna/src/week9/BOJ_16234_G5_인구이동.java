import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;	// N * N 크기의 땅
	static int L;	// 인구 차이가 L명 이상
	static int R;	// 인구 차이가 R명 이하
	static int[][] A;	// A[r][c] : r행 c열 국가의 인구 수
	static boolean[][] visited;
	
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[] dx = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++)
				A[y][x] = Integer.parseInt(st.nextToken());
		}
		
		
		// 2. 문제 풀이
		int day = 0;
		while (true) {
			
			// 인구 이동 발생 유무
			boolean idx = false;	
			visited = new boolean[N][N];
			
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					if (!visited[y][x] && bfs(y, x))
						// 인구 이동 발생!
						idx = true;	
			
			// 인구 이동이 단 한번도 발생하지 않았다면
			if (!idx) break;
			
			day++;
		}
		
		
		// 3. 정답 출력
		System.out.println(day);
	}

	private static boolean bfs(int sy, int sx) {
		
		Queue<int[]> q = new LinkedList<>();
		List<int[]> union = new LinkedList<>();	// 연합국들의 좌표를 저장
		int total = 0;	// 연합국들의 총 인구 수
		
		q.offer(new int[] {sy, sx});
		union.add(new int[] {sy, sx});
		visited[sy][sx] = true;
		total = A[sy][sx];
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (isCoord(ny, nx) && !visited[ny][nx]) {
					
					// 인접 국가간의 인구 수 차이
					int diff = Math.abs(A[ny][nx] - A[y][x]);
					
					if (L <= diff && diff <= R) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny, nx});
						union.add(new int[] {ny, nx});
						total += A[ny][nx];
					}
				}
			}
		}
		
		// 인구 이동이 완료된 후, 한 국가가 갖게 될 인구 수
		int population = total / union.size();
		
		// 인구 이동 전과 후의 인구 수 차이가 없다면
		if (population == A[sy][sx]) {
			
			// 여태까지 방문했던 국가들의 방문 체크를 false로 되돌려주기
			for (int[] i : union) {
				int y = i[0];
				int x = i[1];
				visited[y][x] = false;
			}
			
			// 실질적인 인구 이동이 발생하지 않았다는 의미에서 false를 리턴
			return false;
		}
		
		// 새로운 인구 수를 연합국들에게 적용시켜주기
		for (int[] i : union) {
			int y = i[0];
			int x = i[1];
			A[y][x] = population;
		}
		
		// 실질적인 인구 이동이 발생했다는 의미에서 true를 리턴
		return true;
	}

	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}