package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class Fibo3 {
	static int[] fibo;

	public static void main(String[] args) {
		fibo = new int[1000];
		Arrays.fill(fibo, -1);
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 1;
		for (int i = 0; i < 47; i++) {
			System.out.printf("f(%d) = %d\n", i, fiboDef(i));
		}
	}

	private static int fiboDef(int n) {
		if (fibo[n] != -1) {
			return fibo[n];
		} else {
			fibo[n] = fiboDef(n - 1) + fiboDef(n - 2);
			return fibo[n];
		}
	}

}
