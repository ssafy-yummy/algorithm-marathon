package com.ssafy.algorithm.swea.S2071;

import java.io.IOException;
import java.util.Scanner;

public class S2071_2 {
	static int ans;
	static Scanner sc;
	public static void main(String[] args) throws IOException {
		int t;
		sc = new Scanner(System.in);
		t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			sums();
			System.out.printf("#%d %.0f\n", tc, (1.0) * ans / 10);
		}
		sc.close();
	}
	
	static int sums() {
		for (int i = 0; i < 10; i++) {
			ans += sc.nextInt();
		}
		return 0;
	}
	

}
