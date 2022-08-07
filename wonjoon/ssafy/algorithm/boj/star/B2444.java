package com.ssafy.algorithm.boj.star;

import java.util.Scanner;

public class B2444 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 2*sc.nextInt()-1;

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.abs(i - n / 2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - 2 * (Math.abs(i - n / 2)); j++) {
				System.out.print("*");
			}
//			for (int j = n - 1 - i; j > 0; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < i + 1; j++) {
//				System.out.print("*");
//			}
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			for (int j = n - 1 - i; j > 0; j--) {
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < i + 1; j++) {
//				System.out.print(" ");
//			}
//			for (int j = n - 1 - i; j > 0; j--) {
//
//				System.out.print("*");
//			}
//			for (int j = n - 1 - i; j > 1; j--) {
//				System.out.print("*");
//			}
//			for (int j = 0; j <= i; j++) {
//				System.out.print(" ");
//			}
			System.out.println();
		}
	}
}
