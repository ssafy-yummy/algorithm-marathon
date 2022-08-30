package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_S1_연산자끼워넣기 {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums; // 숫자 배열
	static int[] selected; // 연산자 순서 배열
	static int[] op; // 연산자 개수 배열

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		op = new int[4];
		nums = new int[N];
		selected = new int[N - 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		// 풀이
		perm(0);

		
		// 출력
		System.out.println(max);
		System.out.println(min);
	}

	// 나열할 수 있는 모든 경우의 수 : 순열 함수
	private static void perm(int cnt) {
		if (cnt == N - 1) { // 주어진 문제에서 연산자 갯수는 항상 N-1개
			// 연산자 선택 완료 / 계산 시간
			int res = nums[0];
			for (int i = 0; i < N - 1; i++) {
				switch (selected[i]) {
				case 0:
					res += nums[i + 1];
					break;
				case 1:
					res -= nums[i + 1];
					break;
				case 2:
					res *= nums[i + 1];
					break;
				case 3:
					res /= nums[i + 1];
					break;
				}
			}

			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		// 연산자 4가지를 모두 뽑는다
		for (int i = 0; i < 4; i++) {
			// 해당 연산자를 모두 사용할 때(0이 될 때) 까지 뽑기
			if (op[i] == 0)
				continue;
			op[i]--;
			selected[cnt] = i;
			perm(cnt + 1);
			op[i]++;

		}

	}

}
