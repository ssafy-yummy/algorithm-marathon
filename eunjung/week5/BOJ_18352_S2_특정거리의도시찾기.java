package boj;
import java.io.*;
import java.util.*;

public class BOJ_18352_S2_특정거리의도시찾기 {
	static int N, M, K, X;
	static ArrayList<Integer>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시번호

		arr = new ArrayList[N + 1];
		dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE; // 거리배열 최댓값으로 초기화
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e); // 해당 도시가 도달할 수 있는 도시 추가
		}

		dijkstra();

		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K)
				list.add(i); // 최단거리가 K일 경우, 리스트에 추가
		}
		
		if (list.size() == 0) {
			System.out.println(-1); 
		} // 최단거리가 K인 도시가 없을 경우 -1 출력
		
		else {
			for (int city : list) {
				System.out.println(city);
			}
		} // 있을 경우 출력 (오름차순)
	}

	private static void dijkstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		dist[X] = 0; // 출발 도시 X
		pq.offer(X);

		while (!pq.isEmpty()) {
			int n = pq.poll();
			// 해당 도시가 도달할 수 있는 도시 탐색
			for (int list : arr[n]) {
				if (dist[list] > dist[n] + 1) {
					dist[list] = dist[n] + 1; // 더 짧은 거리로 변경
					pq.offer(list); // pq에 추가
				}
			}
		}
	}

}