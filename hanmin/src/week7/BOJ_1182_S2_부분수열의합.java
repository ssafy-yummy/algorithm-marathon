package hanmin.src.week7;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1182_S2_부분수열의합 {
	static int[] arr;
	static int[] visit;
	static int N;
	static int S;
	static int answer;
	static int flg;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		//flg를 통해 초기 0 값 제거
		flg = 0;
		func(0, 0, 0);
		// end

		// 출력
		System.out.println(answer);

	}

	private static void func(int n, int sum, int start) {
		if (sum == S && flg == 1) {
			answer++;
		}
		if (n == N)
			return;
		flg = 1;
		for (int i = start; i < N; ++i) {
			if (visit[i] == 1)
				continue;
			visit[i] = 1;
			func(n + 1, sum + arr[i], i + 1);
			visit[i] = 0;
		}
	}
}
