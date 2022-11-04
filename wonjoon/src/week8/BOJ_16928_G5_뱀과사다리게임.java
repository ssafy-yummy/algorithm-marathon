package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_G5_뱀과사다리게임 {

	static int N, M, ans;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[101];
		visited = new boolean[101];
		for (int i = 1; i <= 100; i++) {
			nums[i] = i;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			nums[s] = e;
		}

		bfs();

		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Temp> q = new LinkedList<>();

		for (int i = 1; i <= 6; i++) {
			visited[nums[i + 1]] = true;
			q.offer(new Temp(nums[i + 1], 1));
		}

		while (!q.isEmpty()) {
			Temp t = q.poll();

			if (t.num == 100) {
				ans = t.cnt;
				return;
			}

			for (int i = 1; i <= 6; i++) {
				if (t.num + i <= 100 && !visited[nums[t.num + i]]) {
					visited[nums[t.num + i]] = true;
					q.offer(new Temp(nums[t.num + i], t.cnt + 1));
				}
			}
		}
	}

	static class Temp {
		int num;
		int cnt;

		public Temp(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
