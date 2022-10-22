package hanmin.src.week9;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2252_G3_줄세우기 {
	static List<List<Integer>> list;
	static int[] visit;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] d = new int[N];
		visit = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i < N; ++i)
			list.add(new ArrayList<>());
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			//d배열에 선행의 수 추가
			d[b]++;
			list.get(a).add(b);

		}
		StringBuilder sb = new StringBuilder();

		// start
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			//선행이 없다면 큐에 추가
			if (d[i] == 0) {
				q.offer(i);
				visit[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append((now + 1) + " ");
			for (int i = 0; i < list.get(now).size(); ++i) {
				int next = list.get(now).get(i);
				//선행이 있다면 컨티뉴
				if (--d[next] > 0)
					continue;
				//방문했다면 컨티뉴
				if (visit[next] != 0)
					continue;
				q.offer(next);
				visit[next] = 1;
			}

		}
		// end

		// 출력
		System.out.println(sb.toString());
	}
}
