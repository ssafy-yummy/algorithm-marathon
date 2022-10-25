package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904_G5_A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		int ans = 0;

		while (T.length() > S.length()) {

			if (T.charAt(T.length() - 1) == 'A')
				T = T.substring(0, T.length() - 1);
			else
				T = reverse(T.substring(0, T.length() - 1));

			if (S.equals(T)) {
				ans = 1;
				break;
			}
		}

		System.out.println(ans);
	}

	private static String reverse(String str) {
		StringBuilder tmp = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
			tmp.append(str.charAt(i));
		return tmp.toString();
	}
}
