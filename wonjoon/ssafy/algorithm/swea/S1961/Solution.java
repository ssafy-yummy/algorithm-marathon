package com.ssafy.algorithm.swea.S1961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int n;

	public static void main(String[] args) throws Exception, IOException {

		System.setIn(new FileInputStream("C:\\SSAFY\\java0719\\java0719_2\\src\\com\\ssafy\\swea\\S1961\\input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int j = 0; j < n; j++) {
				String[] data = br.readLine().split(" ");
				for (int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(data[k]);
				}
			}

			System.out.println("#" + tc);
			int[][] arr90 = rotate(arr);
			int[][] arr180 = rotate(arr90);
			int[][] arr270 = rotate(arr180);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr90[i][j]);
				}

				System.out.print(" ");

				for (int j = 0; j < n; j++) {
					System.out.print(arr180[i][j]);
				}

				System.out.print(" ");

				for (int j = 0; j < n; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
	}

	static int[][] rotate(int[][] arr) {
		int[][] tmp = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				tmp[i][j] = arr[n - 1 - j][i];
			}
		}
		return tmp;
	}

}
