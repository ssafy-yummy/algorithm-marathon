package hanmin.src.week14;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2116_G5_주사위쌓기 {
	static int[][] dice;
	static int N;
	static int answer;
	static Map<Integer, Integer> m = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; ++j) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		//주사위의 반대편 매핑
		m.put(0, 5);
		m.put(1, 3);
		m.put(2, 4);
		m.put(3, 1);
		m.put(4, 2);
		m.put(5, 0);

		for (int i = 0; i < 6; ++i) {
			//주사위의 모든 면을 위로두고 탐색
			answer = Math.max(answer, func(i));
		}

		// end

		// 출력
		System.out.println(answer);
	}

	private static int func(int top) {
		int sum = 0;
		//바닥면
		int bottom = -1;
		//다음주사위 바닥면의 숫자값 
		int nextBottom = dice[0][top];
		
		for (int i = 0; i < N; ++i) {
			int mx = 0;
			//바닥면의 idx 찾기
			for (int j = 0; j < 6; ++j) {
				if (nextBottom == dice[i][j]) {
					bottom = j;
					break;
				}
			}
			//윗면의 idx 찾기
			top = m.get(bottom);
			//옆면에서 가장 큰값 검색
			for (int j = 0; j < 6; ++j) {
				if (j == bottom)
					continue;
				if (j == top) {
					nextBottom = dice[i][j];
					continue;
				}
				mx = Math.max(mx, dice[i][j]);
			}
			sum += mx;
		}
		return sum;
	}
}
