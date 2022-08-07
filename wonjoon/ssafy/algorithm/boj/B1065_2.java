package com.ssafy.algorithm.boj;

import java.util.Scanner;

public class B1065_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[1000 + 1];

		for (int i = 1; i < 100; i++) {
			nums[i] = i;
		}

		for (int i = 100; i < n + 1; i++) {
			if (isHansu(i)) {
				nums[i] = nums[i - 1] + 1;
			} else {
				nums[i] = nums[i - 1];
			}
		}

		System.out.println(nums[n]);
	}

	private static boolean isHansu(int n) {

		String s = String.valueOf(n); // "1234"
		char[] cs = s.toCharArray(); // '1', '2', '3', '4'
		int[] num = new int[cs.length];

		for (int i = 0; i < num.length; i++) {
			num[i] = cs[i] - '0';
		}

		// 1 2 3 4 등차
		int d = num[1] - num[0];
		for (int i = 1; i < num.length - 1; i++) {
			int d2 = num[i + 1] - num[i];
			if (d != d2) {
				return false;
			}
		}
		return true;
	}
}
