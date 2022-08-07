package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class FactTest2 {

	static int[] fact;

	public static void main(String[] args) {
		fact = new int[13];
		Arrays.fill(fact, -1);

		factDef(13);

		for (int i = 0; i < 13; i++) {
			System.out.println(i + " " + fact[i]);
		}
	}

	private static int factDef(int n) {
		if (fact[n] != -1) {
			return fact[n];
		}else {
			fact[n] = n * factDef(n - 1);
			return fact[n];	
		}

		
	}
}
