package com.ssafy.algorithm.swea.S1244;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution2 {

	static int[] arr;

	static int max = 0;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1244\\input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			max = 0;
			int num = sc.nextInt();
			int chance = sc.nextInt();
			arr = Integer.toString(num).chars().map(c -> c - '0').toArray();

			dfs(0, 0, chance);
			System.out.println("#" + tc + " " + max);

		}
	}

	// dfs 함수 (인덱스, 깊이, 변동 제한 수)
	public static void dfs(int k, int cnt, int chance) {
		// chance 만큼 돌았으면 값 확인
		if (chance == cnt) {
			StringBuffer sb = new StringBuffer();

			for (int i : arr) {
				sb.append(i);
			}

			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}

		// 돌려보기
		// 완전 탐색 이중 for문 으로 전 범위 탐색 진행
		for (int i = k; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] <= arr[j]) {

					// swap, 앞 뒤 바꿔본다.
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;

					// 한번 바꿨으니 횟수 카운팅(cnt+1)하고 dfs로 다시 탐색 진행
					dfs(i, cnt + 1, chance);

					// 다 돌고 나면 다음 자리에서 또 돌아야 하므로 제자리로 돌려준다.
					// 다시 swap 해서 자리 되돌림
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

	}
}
