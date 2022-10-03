import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {
	
	static int N;	// N * N 크기의 땅
	static int L;	// 인구 차이가 L명 이상
	static int R;	// 인구 차이가 R명 이하
	static int[][] A;	// A[r][c] : r행 c열 국가의 인구 수
	static boolean[][] visited;
	
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[] dx = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {

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
		
		int day = 0;
		while (true) {
			
			boolean idx = false;	// 인구 이동 발생 유무
			visited = new boolean[N][N];
			
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					if (!visited[y][x] && bfs(y, x))
						idx = true;
			
			// 인구 이동이 단 한번도 발생하지 않았다면
			if (!idx) break;
			
			day++;

		}
		System.out.println(day);
	}

	private static void print() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) 
				System.out.print(A[y][x] + " ");
			System.out.println();
		}
		System.out.println();
	}
	private static void print2() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) 
				System.out.print(visited[y][x] + " ");
			System.out.println();
		}
		System.out.println();
	}

	private static boolean bfs(int sy, int sx) {
		
		Queue<int[]> q = new LinkedList<>();
		List<int[]> union = new LinkedList<>();
		int total = 0;
		
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
		
		int population = total / union.size();
		if (population == A[sy][sx]) {
			for (int[] i : union) {
				int y = i[0];
				int x = i[1];
				if (y == 0 && x == 1) System.out.println("!!");
				visited[y][x] = false;
			}
			return false;
		}
		
		for (int[] i : union) {
			int y = i[0];
			int x = i[1];
			A[y][x] = population;
		}
		
		return true;
	}

	private static boolean isCoord(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
