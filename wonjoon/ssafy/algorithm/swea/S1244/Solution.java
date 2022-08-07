package com.ssafy.algorithm.swea.S1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오답..
public class Solution {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-java-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S1244\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] nums = st.nextToken().split("");
			String[] numsC = nums.clone();
			int cnt = Integer.parseInt(st.nextToken());

			for (int x = 0; x < cnt; x++) {
				for (int i = 0; i < numsC.length; i++) {
					for (int j = 0; j < numsC.length; j++) {
						if (i == j || numsC[i] == numsC[j])
							continue;
						String t1 = numsC[i];
						numsC[i] = numsC[j];
						numsC[j] = t1;

						String tmp = "";
						for (String string : nums) {
							tmp += string;
						}

						ans = Math.max(ans, Integer.parseInt(tmp));
						numsC = nums;
					}
				}

			}

			System.out.println(ans);
		}
	}

}
