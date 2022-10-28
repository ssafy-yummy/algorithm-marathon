package hanmin.src.week13;

import java.util.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_G5_A와B {
	static String N;
	static String M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		M = br.readLine();

		// start
		func(N, M);
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(String n, String m) {
		// 길이가 같다면 가능한지 판별
		if (n.length() == m.length()) {
			if (n.compareTo(m) == 0)
				answer = 1;
			return;
		}
		String lastAlpha = m.substring(m.length() - 1);
		String tmp = "";
		// A인 경우 단순하게 끝자리 하나 줄인다
		if (lastAlpha.compareTo("A") == 0) {
			func(n, m.substring(0, m.length() - 1));
		}
		// B인 경우 끝자리를 줄이고 뒤집는다
		else {
			for (int i = m.length() - 2; i >= 0; --i)
				tmp += m.charAt(i);
			func(n, tmp);
		}
	}
}
