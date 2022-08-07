package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int N = p.length;
	static int R; // nPr
	static int count; // 전체 개수

	static boolean[] visited; // 선택된 적 있는지 체크
	static int[] nums; // 선택된 R 개 나열

	// 5P3
	public static void main(String[] args) {
		R = 3;

		nums = new int[R];
		visited = new boolean[N];
		npr(0);
		System.out.println(count);
	}

	private static void npr(int cnt) {
		// R 만큼 들어갔으면 출력!!
		if (cnt == R) {
			count++;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					System.out.print(p[i] + " ");
				}

			}
			System.out.println();
//			System.out.println(Arrays.toString(nums));
			return;
		}

		for (int i = 0; i < N; i++) {
			// 방문했으면 넘어감
			if (visited[i])
				continue;

			visited[i] = true;
			nums[cnt] = p[i];
			npr(cnt + 1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}
}
