package com.ssafy.algorithm.swea.S2068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\cad\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2068\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= t; tc++) {
			int[] arr = new int[10];
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 10; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > ans) {
					ans = tmp;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}
	}

}
