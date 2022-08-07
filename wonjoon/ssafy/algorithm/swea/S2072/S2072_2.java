package com.ssafy.algorithm.swea.S2072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S2072_2 {
	static int ans;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 10; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp % 2 == 1) {
					ans +=tmp;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
