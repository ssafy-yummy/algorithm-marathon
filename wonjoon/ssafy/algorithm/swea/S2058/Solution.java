package com.ssafy.algorithm.swea.S2058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] data = br.readLine().split("");
		int sum = 0;
		for (String d : data) {
			sum += Integer.parseInt(d);
		}
		System.out.println(sum);
	}
}
