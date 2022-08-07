package com.ssafy.algorithm.swea.ant_quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ant(2);
	}

	static int ant(int stage) {

		String s = "11";
		for (int i = 0; i < stage; i++) {
			System.out.println(s);
			s = ans(s);
		}
		return 0;
	}

	static String ans(String s) {
		String t = "";
		char c = s.charAt(0);
		int cnt = 1;
		for (int i = 0; i < s.length(); i++) {
			if (c == s.charAt(i)) {
				cnt++;
			} else {
				t = t + c + cnt;

				c = s.charAt(i);
				cnt = 1;
			}
		}

		System.out.println("t:" + t);
		return t;
	}
}
