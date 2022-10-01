package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_G3_줄세우기 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static ArrayList<Integer> ans = new ArrayList<>();
	static int[] indegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];

		for (int i = 0; i < N + 1; i++)
			arr.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr.get(s).add(e);
			indegree[e]++;
		}

		topologicalSort();

		for (Integer i : ans)
			System.out.print(i + " ");
	}

	private static void topologicalSort() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			ans.add(now);

			for (Integer i : arr.get(now)) {
				indegree[i]--;

				if (indegree[i] == 0)
					q.offer(i);
			}
		}
	}
}
