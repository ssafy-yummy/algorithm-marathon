package hanmin.src.week4;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2805_S2_나무자르기 {
	static long[] arr;
	static int N;
	static long M;

	// 123160 556
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		long answer = 0;
		long l = 0;
		long r = 2000000000;
		// 이분탐색시작
		while (l <= r) {
			long mid = (l + r) / 2;
			long sum = 0L;
			//자른 나무의 합 계산
			for (int i = 0; i < N; ++i) {
				if (arr[i] > mid)
					sum += arr[i] - mid;
			}
			//합이 크다면 최댓값 계산
			if (sum >= M) {
				l = mid + 1;
				answer = Math.max(mid, answer);
			} else if (sum < M) {
				r = mid - 1;
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}
}
