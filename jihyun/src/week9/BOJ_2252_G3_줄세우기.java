package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_G3_줄세우기 {

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}

	}

	static int V, E;
	static Node[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1]; // 정점의 인접리스트
		inDegree = new int[V + 1]; // 정점의 진입차수

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]); //유향리스트 연결
			inDegree[to]++;
		}

		ArrayList<Integer> list = topologySort();
		for (Integer i : list) { //list.size() == V
			System.out.print(i + " ");
		}
	}

	private static ArrayList<Integer> topologySort() {

		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i < V + 1; i++) {
			if (inDegree[i] == 0) //진입차수가 0일때
				queue.offer(i); //큐에 넣는다
		}

		while (!queue.isEmpty()) { //큐가 빌때 모든 정점들을 방문 했다면 위상정렬 성공
			int cur = queue.poll(); //진입차수가 0인 정점들에 대해서
			list.add(cur); //리스트에 추가

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) { //현재 정점과 연결된 간선들에서
				if (--inDegree[temp.vertex] == 0) //간선을 제거하고 진입차수가 0이 된다면
					queue.offer(temp.vertex); //큐에 넣는다
			}
		}

		return list; //정렬된 리스트 반환
	}

}
