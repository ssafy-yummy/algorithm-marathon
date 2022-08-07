package com.ssafy.algorithm.swea.S1206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1206\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;
			for (int i = 2; i < arr.length - 2; i++) {
				int view = arr[i];
				int ls = 0;
				int rs = 0;

				ls = view - (Math.max(arr[i - 1], arr[i - 2]));
				rs = view - (Math.max(arr[i + 1], arr[i + 2]));

				if (ls > 0 && rs > 0) {
					ans += Math.min(ls, rs);
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
