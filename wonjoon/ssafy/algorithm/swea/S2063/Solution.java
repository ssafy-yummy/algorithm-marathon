package com.ssafy.algorithm.swea.S2063;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(
				"C:\\SSAFY\\ssafy-workspace\\ssafy-algorithm\\src\\com\\ssafy\\swea\\S2063\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		t = Integer.parseInt(br.readLine());
		String data = br.readLine();

		StringTokenizer st = new StringTokenizer(data);
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		System.out.println(arr[arr.length / 2]);

	}
}
