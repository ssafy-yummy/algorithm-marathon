package com.ssafy.algorithm.swea.S1859;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n;

	public static void main(String[] args) throws Exception, IOException {

		System.setIn(new FileInputStream("D:\\ssafy\\java0719\\java0719_2\\src\\com\\ssafy\\swea\\S1859\\input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			
			int n = Integer.parseInt(br.readLine());

			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp);

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int h = arr[arr.length - 1];
			for (int i = 1; i < n; i++) {
				int tmp2 = arr[n - 1 - i];
				if (h > tmp2) {
					ans += h - tmp2;
				} else {
					h = tmp2;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}
