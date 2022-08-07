package com.ssafy.algorithm.swea.hw_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과제4_Flattern {
	static int[] arr = new int[100];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIdx = 0;
			int minIdx = 0;
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int x = 0; x <= n; x++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int i = 0; i < 100; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}

					if (arr[i] < min) {
						min = arr[i];
						minIdx = i;
					}
				}
				arr[maxIdx] -= 1;
				arr[minIdx] += 1;
			}

			for (int i = 0; i < 100; i++) {
				if (arr[i] > max) {
					max = arr[i];
					maxIdx = i;
				}

				if (arr[i] < min) {
					min = arr[i];
					minIdx = i;
				}
			}

			System.out.println("#" + tc + " " + (max - min));
		}
	}
}