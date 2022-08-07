package com.ssafy.algorithm.swea.S2056;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2056\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String ans;
			String data = br.readLine();

			String year = data.substring(0, 4);
			String month = data.substring(4, 6);
			String day = data.substring(6, 8);

			boolean flag = false;
			int month_int = Integer.parseInt(month);
			int day_int = Integer.parseInt(day);

			if (month_int >= 1 && month_int <= 12 && day_int > 0) {
				if (month_int == 2) {
					if (day_int <= 28) {
						flag = true;
					}
				} else if (month_int == 4 || month_int == 6 || month_int == 9 || month_int == 11) {
					if (day_int <= 30) {
						flag = true;
					}
				} else {
					if (day_int <= 31) {
						flag = true;
					}
				}
			}
			if (flag) {
				ans = year + "/" + month + "/" + day;
			} else {
				ans = "-1";
			}

			System.out.println("#" + tc + " " + ans);

		}

	}
}
