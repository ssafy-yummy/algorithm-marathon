package com.ssafy.algorithm.ssafy;

public class SubsetTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int count; // 전체 개수

	static boolean[] visited; // 선택된 적 있는지 체크

	// 5P3
	public static void main(String[] args) {
		visited = new boolean[N];
		subset(0); // poswerset
		System.out.println(count);
		System.out.println(1 << N);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			count++;
			// 선택된 것 출력
			for (int i = 0; i < N; i++) {
				if (visited[i])
					System.out.print(p[i] + " ");
			}
			System.out.println();
			return;
		}

		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
}
