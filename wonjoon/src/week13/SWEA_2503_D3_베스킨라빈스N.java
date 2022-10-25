package com.ssafy.algorithm.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2503_D3_베스킨라빈스N {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int ans = 0;
			if ((N - 1) % 4 == 0)
				ans = 1;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
