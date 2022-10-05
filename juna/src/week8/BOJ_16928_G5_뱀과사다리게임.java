import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_G5_뱀과사다리게임 {
	
	static int N;	// 사다리 수
	static int M;	// 뱀의 수
	static int[] board;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[101];
		visited = new boolean[101];
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// board의 x칸에 0이 아닌 다른 숫자(y)가 쓰여있다면,
			// x칸에 도달하는 즉시 y칸으로 이동한다.
			board[x] = y;
		}
		
		System.out.println(bfs(1));
	}

	private static int bfs(int start) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];	// 현재 위치하고 있는 칸
			int cnt = tmp[1];	// 이 칸에 오기까지 주사위를 굴린 횟수
			
			for (int i = 1; i < 7; i++) {	// 주사위는 1부터 6까지 나올 수 있다.
				int next = now + i;
				
				if (next > 99)
					return cnt + 1;
				
				if (board[next] != 0)	// 이동한 칸에 사다리 또는 뱀이 놓여있다면
					next = board[next];	// 그 곳으로 즉시 이동한다.
				
				if (next > 99)
					return cnt + 1;
				
				if (!visited[next]) {
					q.offer(new int[] {next, cnt + 1});
					visited[next] = true;
				}
			}
		}
		
		return -1;
	}

}
