package hanmin.src.week5;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5567_S2_결혼식 {
	// 18844 204
	static List<List<Integer>> list;
	static int[][] map;
	static int[] visit;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new int[N + 1];
		for (int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		// start
		bfs(1, 0);
		// end

		// 출력
		System.out.println(answer);
	}

	private static void bfs(int n, int dep) {
		visit[1] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		// 친구의 친구까지만 가능하므로 탐색범위 2까지 제한
		while (!q.isEmpty() && dep < 2) {
			dep++;
			int size = q.size();
			for (int sz = 0; sz < size; ++sz) {
				int now = q.poll();
				for (int next : list.get(now)) {
					if (visit[next] != 0)
						continue;
					visit[next] = 1;
					q.offer(next);
					answer++;
				}
			}
		}
	}
}
