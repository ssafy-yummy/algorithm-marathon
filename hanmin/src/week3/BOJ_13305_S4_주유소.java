package hanmin.src.week3;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_13305_S4_주유소 {
	// n 100000
	// dis 1000000000
	// station 1000000000
	// 낮은 가격이 나올때까지 현재 가격으로 계산
	// 35912kb 408ms
	static long[] dis;
	static long[] station;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dis = new long[N];
		station = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; ++i) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			station[i] = Integer.parseInt(st.nextToken());
		}

		// start
		long answer = 0;
		long mn = station[0];// 지금까지 가장 낮은 가격
		for (int i = 1; i < N; ++i) {
			answer += dis[i - 1] * mn;
			// 다음 주요소 가격이 높다면 현재 선택한 가격으로 계산
			// 낮다면 더 낮은 값이 나올 때 까지 지금 가격으로 계산
			if (mn > station[i]) {
				mn = station[i];
			}
		}
		// end

		// 출력
		System.out.println(answer);

	}
}
