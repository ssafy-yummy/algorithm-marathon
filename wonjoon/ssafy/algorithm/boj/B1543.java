package com.ssafy.algorithm.boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1543 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String data = br.readLine();
		String target = br.readLine();
		int cnt = 0;

		for (int i = 0; i <= data.length() - target.length(); i++) {
			String tmp = data.substring(i, i + target.length());
			if (tmp.equals(target)) {
				cnt++;
				i += target.length() - 1;
			}
		}

		System.out.println(cnt);
	}
}
