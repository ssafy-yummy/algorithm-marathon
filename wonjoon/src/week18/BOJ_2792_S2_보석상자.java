package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2792_S2_보석상자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M];

		int lt = 1;
		int rt = 0;
		int mid = 0;

		int tot = 0; // 최소 인원
		int answer = 0;

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			rt = Math.max(rt, arr[i]); // 최대 보석 체크
		}

		while (lt <= rt) {
			mid = (lt + rt) / 2; // 질투심
			tot = 0;

			for (int i = 0; i < M; i++) {
				tot += arr[i] / mid;

				if (arr[i] % mid != 0) { // 남으면 한명 추가
					tot++;
				}
			}
			
			// 보석을 받아야하는 학생 수가 실제 학생보다 많으면 X
			if (tot > N) {
				lt = mid + 1;
			} else {
				// 질투심 저장
//				System.out.println("질투심 : " + tot + " | " + mid);
				rt = mid - 1;
				answer = mid;
			}
		}

		// 질투심의 최솟값 출력
		System.out.println(answer);
	}
}
