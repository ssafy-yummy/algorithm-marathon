package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class Fibo2 {
	static int[] fibo;

	public static void main(String[] args) {
		fibo = new int[1000];
		Arrays.fill(fibo, -1);
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < 47; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		for (int i = 1; i < 47; i++) {
			System.out.printf("f(%d) = %d\n", i, fibo[i]);
		}
	}
}
