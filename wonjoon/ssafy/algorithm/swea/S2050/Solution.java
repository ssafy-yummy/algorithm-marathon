package com.ssafy.algorithm.swea.S2050;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2050\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] - 64 +" ");
		}

	}
}
