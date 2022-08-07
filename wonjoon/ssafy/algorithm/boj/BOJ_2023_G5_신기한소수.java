package com.ssafy.algorithm.boj;

import java.util.Scanner;

public class BOJ_2023_G5_신기한소수 {

	static int[] nums;
	static int N;
	static int[] q = { 2, 3, 5, 7 };
	static int[] p = { 1, 3, 5, 7, 9 };
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();

		for (int i = 0; i < 4; i++) {
			nums = new int[N];
			nums[0] = p[i];
			npir(0);
		}

	}

	private static boolean isP(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i <= (int) (Math.sqrt(n)); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static void npir(int cnt) {
		int nn = toI(nums, cnt + 1);

		if (!isP(nn))
			return;

		if (cnt == N - 1) {
			System.out.println(nn);
			return;
		}

		for (int i = 0; i < 9; i++) {
			nums[cnt + 1] = i + 1;

			npir(cnt + 1);

		}
	}

	private static int toI(int[] nums2, int nn) {
		// TODO Auto-generated method stub
		return 0;
	}
}
