import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_G5_토마토 {
	
	static int N, M, cnt;
	static int[][] board;
	static Queue<int[]> q;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행 수
		M = Integer.parseInt(st.nextToken());	// 열 수
		
		board = new int[M][N];
		q = new LinkedList<>();					// bfs에 쓰일 큐
		
		for (int y = 0; y < M; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
				if (board[y][x] == 1)
					q.offer(new int[] {y, x});	// ★ 처음부터 익어있던 토마토는 큐에 미리 모두 담아놓는다.
				else if (board[y][x] == 0)
					cnt++;						// 익지 않은 토마토의 개수를 세아려둔다.
			}
		}
		
		// 2. 풀이
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (0 <= ny && ny < M && 0 <= nx && nx < N && board[ny][nx] == 0) {	// (한 번도 방문한 적 없는) 익지 않은 토마토라면
					q.offer(new int[] {ny, nx});
					board[ny][nx] = board[y][x] + 1;	// 앞선 토마토가 익을 때까지 걸린 시간(board[y][x])에서 1을 더한 값을 저장한다.
					cnt--;
				}
			}
		}
		
		
		// 3. 정답 출력
		if (cnt > 0)
			System.out.println(-1);						// 익지 않은 토마토가 남아있다면 -1을 출력한다.
		else {
			int ans = 0;
			for (int i = 0; i < M; i++)
				for (int j = 0; j < N; j++)
					ans = Math.max(ans, board[i][j]);	// board에 저장된 값(각 토마토가 익을 때까지 걸린 시간)들 중 최댓값이 정답이다.
			System.out.println(ans - 1);
		}
	}
}