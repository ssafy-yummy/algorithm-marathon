package com.ssafy.algorithm.ssafy;

public class Fibo {
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.printf("f(%d) = %d\n", i, fibo(i));
		}
	}

	private static int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibo(n - 1) + fibo(n - 2);
	}
}
