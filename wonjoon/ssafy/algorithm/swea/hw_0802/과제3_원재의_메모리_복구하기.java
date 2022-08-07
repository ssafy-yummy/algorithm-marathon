package com.ssafy.algorithm.swea.hw_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 과제3_원재의_메모리_복구하기 {
	static int count;
	static int[] n;
	static int[] initArr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			count = 0;
			String[] data = br.readLine().split("");

			n = new int[data.length];
			initArr = new int[data.length];
			for (int i = 0; i < n.length; i++) {
				n[i] = Integer.parseInt(data[i]);
			}

			for (int i = 0; i < initArr.length; i++) {
				if (initArr[i] != n[i])
					turnMemory(i);
			}

			System.out.println("#" + tc + " " + count);
		}
	}

	static void turnMemory(int idx) {
		count++;
		for (int i = idx; i < initArr.length; i++) {
			initArr[i] = (initArr[i] + 1) % 2;
		}
	}
}
