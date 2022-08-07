package com.ssafy.algorithm.swea.S2072;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class S2072 {
	static int ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2072\\input.txt"));

		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();

//		for (int tc = 1; tc <= t; tc++) {
//			ans = 0;
//			String[] strArr = sc.next().split(" ");
//			
//			for (String s : strArr) {
//				int tmp = Integer.parseInt(s);
//				
//				if (tmp % 2 == 1) {
//					ans +=tmp;
//				}
//			}
//			
//			System.out.println("#" + tc + " " + ans);
//		}
		
		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			for (int i = 0; i < 10; i++) {
				int tmp = sc.nextInt();
				if (tmp % 2 == 1) {
					ans +=tmp;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		

		sc.close();
	}

}
