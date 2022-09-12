package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_S2_특정거리의도시찾기 {

	static int N, M, K, X;
	static int[] distance;
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		adjList = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
		}

		bfs(X);

		for (int i = 2; i < N + 1; i++)
			if (distance[i] == K)
				sb.append(i).append("\n");

		if (sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}

	private static void bfs(int start) {
		distance[start] = 0;
		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(start, 0));

		while (!q.isEmpty()) {
			Edge cur = q.poll();

			for (int i = 0; i < adjList[cur.no].size(); i++) {
				int next = adjList[cur.no].get(i);
				int cost = distance[cur.no] + 1;

				if (cost < distance[next]) {
					distance[next] = cur.weight + 1;
					q.offer(new Edge(next, cur.weight + 1));
				}
			}
		}
	}

	static class Edge {
		int no;
		int weight;

		public Edge(int x, int dis) {
			this.no = x;
			this.weight = dis;
		}
	}
}
