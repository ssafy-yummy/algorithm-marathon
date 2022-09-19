package hanmin.src.week5;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18352_S2_특정거리의도시찾기 {
	// 268120 1204
	static List<List<Integer>> list;
	static int[][] map;
	static int[] dist;
	static int X;
	static int K;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		dist = new int[N + 1];
		for (int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}
		
		// start
		for (int i = 0; i < N + 1; ++i) {
			dist[i] = Integer.MAX_VALUE;
		}
		Dijkstra(X);
		// end
		
		// 출력
		int cnt = 0;
		for (int i = 1; i < N + 1; ++i) {
			//K거리의 도시 출력
			if (dist[i] == K) {
				System.out.println(i);
				cnt++;
			}
		}
		if (cnt == 0)
			System.out.println(-1);
	}

	private static void Dijkstra(int n) {
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.y, b.y));
		pq.offer(new Point(n, 0));
		dist[n] = 0;

		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (dist[now.x] < now.y)
				continue;
			int sz = list.get(now.x).size();
			for (int i = 0; i < sz; ++i) {
				int next = list.get(now.x).get(i);
				if (dist[next] <= now.y + 1)
					continue;
				dist[next] = now.y + 1;
				pq.offer(new Point(next, now.y + 1));

			}
		}
	}
}
