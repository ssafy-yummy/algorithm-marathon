package com.ssafy.algorithm.swea.S2071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2071 {
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 10; i++) {
				ans += Integer.parseInt(st.nextToken());
			}

			System.out.printf("#%d %.0f\n", tc, (1.0) * ans / 10);
		}

	}

}
