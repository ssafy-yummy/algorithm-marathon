package com.ssafy.algorithm.swea.S2070;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\cad\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2070\\input.txt"));

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {

			String[] tmp = br.readLine().split(" ");

			String ans;
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);

			if (a > b) {
				ans = ">";
			} else if (b > a) {
				ans = "<";
			} else {
				ans = "=";
			}

			System.out.println("#" + i + " " + ans);

		}
	}

}
