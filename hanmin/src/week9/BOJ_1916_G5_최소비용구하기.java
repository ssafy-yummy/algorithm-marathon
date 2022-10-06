package hanmin.src.week9;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1916_G5_최소비용구하기 {
	static List<List<Point>> list;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.get(u).add(new Point(v, d));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// start
		answer = func(u, v);
		// end

		// 출력
		System.out.println(answer);
	}

	private static int func(int s, int e) {
		//우선순위 큐를 사용한 최솟값 pop
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.x == o2.x)
				return Integer.compare(o1.y, o2.y);
			return Integer.compare(o1.x, o2.x);
		});
		pq.add(new Point(0, s));

		int[] dist = new int[N + 1];
		for (int i = 0; i < N + 1; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Point now = pq.poll();

			//최소거리보다 클시 컨티뉴
			if (dist[now.y] < now.x)
				continue;
			for (int i = 0; i < list.get(now.y).size(); ++i) {
				Point next = list.get(now.y).get(i);
				int next_idx = next.x;
				int next_dir = next.y;
				//최소거리라면 큐에 추가
				if (dist[next_idx] > next_dir + now.x) {
					dist[next_idx] = next_dir + now.x;
					pq.offer(new Point(next_dir + now.x, next_idx));
				}
			}
		}
		return dist[e];
	}
}
