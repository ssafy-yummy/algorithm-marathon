package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_S1_연산자끼워넣기 {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums;
	static int[] selected;
	static int[] op;

	public static void main(String[] args) throws Exception {

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

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		perm(0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		if (cnt == N - 1) {
			// 연산자 선택 완료
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

		for (int i = 0; i < 4; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			selected[cnt] = i;
			perm(cnt + 1);
			op[i]++;

		}

	}

}
