package com.ssafy.algorithm.boj;

import java.util.Scanner;

public class B1065 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int cnt = 0;
		if (n < 100) {
			System.out.println(n);
		} else {
			cnt = 99;
			for (int i = 100; i <= n; i++) {
				String arr = String.valueOf(i);
				int dis1 = arr.charAt(1) - arr.charAt(0);
				int dis2 = arr.charAt(2) - arr.charAt(1);

				if (dis1 == dis2) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}

	}
}
