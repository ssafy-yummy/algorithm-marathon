package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_G5_주사위쌓기 {

	static int N, ans;
	static int[][] dices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++)
			solve(0, i, 0);

		System.out.println(ans);
	}

	private static void solve(int no, int startIdx, int sum) {
		if (no + 1 == N) {
			// 최고점에 도달하면 합 return
			int opIdx = opposite(startIdx);

			int max = 0;
			for (int i = 0; i < 6; i++) {
				// 시작 인덱스도, 반대편 인덱스도 아닌 경우 최대 값 저장
				if (i != startIdx && i != opIdx) {
					max = Math.max(max, dices[no][i]);
				}
			}

			ans = Math.max(ans, sum + max);

			return;
		}
		// 1. 시작 인덱스의 반대편 인덱스를 구한다.
		int opIdx = opposite(startIdx);

		// 2. 반대편 인덱스 값을 가지는 다음 주사위 인덱스를 구한다.
		int nextIdx = 0;
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (dices[no][opIdx] == dices[no + 1][i]) {
				nextIdx = i;
			}

			// 시작 인덱스도, 반대편 인덱스도 아닌 경우 최대 값 저장
			if (i != startIdx && i != opIdx) {
				max = Math.max(max, dices[no][i]);
			}
		}

		// 3. 1-2 반복하면서 시작 인덱스, 반대편 인덱스를 제외한 최대 값을 저장한다.
		solve(no + 1, nextIdx, sum + max);

	}

	private static int opposite(int start) {
		int next = 0;

		switch (start) {
		case 0:
			next = 5;
			break;
		case 1:
			next = 3;
			break;
		case 2:
			next = 4;
			break;
		case 3:
			next = 1;
			break;
		case 4:
			next = 2;
			break;
		case 5:
			next = 0;
			break;
		}

		return next;
	}

}
