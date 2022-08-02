package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_S1_단지번호붙이기 {
	
	static int N;
	static List<Integer> ans;
	static int[][] board;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		ans = new ArrayList<>();
		q = new LinkedList<>();
		
		int j;
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
			j = 0;
			for (char c : br.readLine().toCharArray()) {
				board[i][j] = c - '0';
				j++;
			}
		}
		
		// 2. 문제 풀기
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (board[y][x] == 1 && !visited[y][x])
					ans.add(bfs(y, x));
		Collections.sort(ans);
		
		// 3. 출력
		System.out.println(ans.size());
		for (int i : ans)
			System.out.println(i);
	}

	private static int bfs(int sy, int sx) {
		
		int y, x, ny, nx, ret = 0;
		q.offer(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			y = cur[0];
			x = cur[1];
			ret++;
			
			for (int k = 0; k < 4; k++) {
				ny = y + dy[k];
				nx = x + dx[k];
				
				if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && board[ny][nx] == 1) {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		
		return ret;
	}
}