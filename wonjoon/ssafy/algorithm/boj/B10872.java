package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10872 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[13];
		arr[0] = 1;
		arr[1] = 1;

		recur(n);
		System.out.println(arr[n]);

	}

	static int recur(int x) {

		if (x <= 1)
			return x;

		if (arr[x] != 0)
			return arr[x];

		arr[x] = x * recur(x - 1);
		return arr[x];
	}
}
