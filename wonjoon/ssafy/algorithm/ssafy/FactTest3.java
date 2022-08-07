package com.ssafy.algorithm.ssafy;

import java.util.Arrays;

public class FactTest3 {

	static int[] fact;

	public static void main(String[] args) {
		fact = new int[13];

		fact[0] = 1;
		fact[1] = 1;

		// bottom - up
		for (int i = 2; i < 13; i++) {
			fact[i] = i * fact[i - 1];
		}

		for (int i = 1; i < 13; i++) {
			System.out.println(i + " != " + fact[i]);
		}
	}
}
