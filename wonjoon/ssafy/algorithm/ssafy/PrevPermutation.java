package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class PrevPermutation {
	static int[] p = { 5, 4, 3, 2, 1 };
	static int count;
	static int N = p.length;

	public static void main(String[] args) {
		do {

			count++;
			System.out.println(Arrays.toString(p));
		} while (np(N - 1));

		System.out.println(count);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] < p[i])
			i--;

		if (i == 0)
			return false;

		int j = size;
		while (p[i - 1] < p[j])
			j--;

		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		int k = size;
		while (i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
