package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

/**
 * 5P3 1 2 3 1 2 4 1 2 5 1 3 2 1 3 4 1 3 5 1 4 2 1 4 3 1 4 5
 * 
 * @author SSAFY
 *
 */
public class NextPermutation {
	static int[] p = { 1, 2, 3, 4, 5 };
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
		while (i > 0 && p[i - 1] > p[i])
			i--;

		if (i == 0)
			return false;

		int j = size;
		while (p[i - 1] > p[j])
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
