package hanmin.src.week4;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14888_S1_연산자끼워넣기 {
	static int[] arr;
	static int[] calc;
	static int N;
	static int M;
	static int mx;
	static int mn;
	// 14340 136

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		calc = new int[4];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		// start
		mx = Integer.MIN_VALUE;
		mn = Integer.MAX_VALUE;
		func(0, arr[0]);
		// end

		// 출력
		System.out.println(mx);
		System.out.println(mn);
	}
	
	private static void func(int n, int sum) {
		if (n == N - 1) {
			mx = Math.max(mx, sum);
			mn = Math.min(mn, sum);
			return;
		}
		for (int i = 0; i < 4; ++i) {
			//사용가능한 연산자가 없을 경우 넘어감
			if (calc[i] == 0)
				continue;
			calc[i]--;
			int tmp = op(i, sum, arr[n + 1]);
			func(n + 1, tmp);
			calc[i]++;

		}
	}
	//연산자 계산
	private static int op(int i, int a, int b) {
		switch (i) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		default:
			int ret = 0;
			if (a < 0) {
				ret = a * -1 / b * -1;
			} else
				ret = a / b;
			return ret;
		}
	}
}
