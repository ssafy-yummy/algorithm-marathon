package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {
	static final int INF = Integer.MAX_VALUE;

	// 노드, 간선, 시작 번호
	static int V, E, start;

	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	// 최단 거리 테이블 만들기
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		d = new int[V + 1];

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
		}

		Arrays.fill(d, INF);

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);
//		System.out.println(Arrays.toString(d));
		System.out.println(d[end]);
	}

	private static void dijkstra(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0; // 시작점은 0

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			int dist = now.dis;
			int no = now.index;

			if (d[no] < dist)
				continue;

			for (int i = 0; i < graph.get(no).size(); i++) {

				int cost = d[no] + graph.get(no).get(i).dis;

				int vertex = graph.get(no).get(i).index;
				if (cost < d[vertex]) {
					d[vertex] = cost;
					pq.offer(new Node(vertex, cost));
				}

			}
		}

	}

	static class Node implements Comparable<Node> {
		int index;
		int dis;

		public Node(int index, int dis) {
			this.index = index;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
}