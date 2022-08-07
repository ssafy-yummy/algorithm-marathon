package com.ssafy.algorithm.ssafy;

public class FactTest {

	public static void main(String[] args) {
		for (int i = 0; i < 13; i++) {
			System.out.println(i + " " + fact(i));
		}
	}

	private static int fact(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * fact(n - 1);
	}
}
