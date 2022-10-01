package hanmin.src.week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class PG_92342_2_양궁대회 {
	static int[] answer = {};
	static int mx = 0;

	public int[] solution(int n, int[] info) {
		answer = new int[11];
		func(0, n, info, new int[11], 0);
		if (mx == 0)
			answer = new int[] { -1 };
		return answer;
	}

	private void func(int now, int n, int[] info, int[] lion, int st) {
		if (now == n) {
			int sum1 = 0;
			int sum2 = 0;
			//라이언과 어파치의 점수 계산
			for (int i = 0; i < 11; ++i) {
				if (lion[i] > info[i]) {
					sum1 += 10 - i;
				} else if (lion[i] <= info[i] && info[i] != 0) {
					sum2 += 10 - i;
				}
			}
			//점수가 높은 것 선택
			if (mx <= sum1 - sum2) {
				//점수가 같다면 낮은 점수의 과녁을 많이 맞춘 쪽 선택 
				if (mx == sum1 - sum2) {
					for (int i = 10; i >= 0; --i) {
						if (lion[i] > answer[i]) {
							System.arraycopy(lion, 0, answer, 0, 11);
							return;
						} else if (lion[i] < answer[i])
							return;
					}
				}
				mx = sum1 - sum2;
				System.arraycopy(lion, 0, answer, 0, 11);
			}
			return;
		}
		for (int i = st; i < 11; ++i) {
			//라이언이 어파치보다 같은 점수에 2발이상 맞추는 것은 점수에 영향이 없다
			if (lion[i] > info[i])
				continue;
			lion[i]++;
			func(now + 1, n, info, lion, i);
			lion[i]--;
		}
	}

	public static void main(String args[]) throws Exception {
		solution(5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 });
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(br.readLine());
		Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
		}

		int T;
//		T = Integer.parseInt(br.readLine());
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력

			// start

			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}