package com.ssafy.algorithm.swea.S1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream(
				"D:\\ssafy\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1204\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int[] arr = new int[101];
			int ans = 0;
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] += 1;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= arr[ans])
					ans = i;
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
