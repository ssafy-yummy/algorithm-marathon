package com.ssafy.algorithm.swea.S2043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		
		int p = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);

		if (p >= k) {
			System.out.println(p - k + 1);
		} else {
			System.out.println(p - k + 1 + 1000);
		}

	}
}
