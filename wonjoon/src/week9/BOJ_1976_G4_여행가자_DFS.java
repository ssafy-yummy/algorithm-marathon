package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자_DFS {

	static int N, M, idx;
	static int[][] board;
	static boolean[] visited;
	static int[] schedule;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		board = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		schedule = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			schedule[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		dfs(schedule[0]);
		System.out.println("NO");

	}

	private static void dfs(int start) {
		visited[start] = true;
		if (schedule[idx] == start) {
			visited = new boolean[N];
			idx++;
			if (idx == M) {
				System.out.println("YES");
				System.exit(0);
			}
		}

		for (int i = 0; i < N; i++) {
			if ((board[start][i] == 1 || start == i) && !visited[i]) {
				dfs(i);
			}
		}
	}
}
