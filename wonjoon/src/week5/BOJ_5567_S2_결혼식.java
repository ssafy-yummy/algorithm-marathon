package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트
public class BOJ_5567_S2_결혼식 {

	static int N, M, ans;
	static ArrayList<Integer>[] edges;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edges = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges[from].add(to);
			edges[to].add(from);
		}

//		bfs(1);

		dfs(1, 0);
		for (int i = 2; i < visited.length; i++)
			if (visited[i])
				ans++;

		System.out.println(ans);
	}

	private static void dfs(int start, int depth) {
		if (depth == 2) {
			return;
		}

		for (int i = 0; i < edges[start].size(); i++) {
			int next = edges[start].get(i);
			visited[next] = true;
			dfs(next, depth + 1);
		}

	}

	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		visited[start] = true;

		q.offer(new int[] { start, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int no = cur[0];
			int dis = cur[1];

			if (dis == 3) {
				return;
			}
			ans++;

			for (int i = 0; i < edges[no].size(); i++) {
				int next = edges[no].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[] { next, dis + 1 });
				}
			}
		}

	}

}
