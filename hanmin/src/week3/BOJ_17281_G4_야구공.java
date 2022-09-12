package hanmin.src.week3;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17281_G4_야구공 {
	static int[] p = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int[][] arr;
	static int N;

	// 8885kb 760
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		int answer = 0;
		do {
			int score = 0;
			int idx = 0;
			List<Integer> order = new ArrayList<>();
			for (int i = 0; i < 8; ++i) {
				if (i == 3)
					order.add(0);
				order.add(p[i]);
			}
			// 게임 시작
			for (int inning = 0; inning < N; ++inning) {
				int[] base = new int[3];
				int out = 0;
				// 아웃이 3이 될때까지 score를 계산
				while (out < 3) {
					int now = order.get(idx);
					idx = (idx + 1) % 9;
					int player = arr[inning][now];
					switch (player) {
					case 0://아웃
						out++;
						break;
					case 1://안타
						for (int i = 2; i < 3; ++i) {
							if (base[i] == 1) {
								score++;
							}
							base[i] = 0;
						}
						if (base[1] == 1) {
							base[2] = 1;
							base[1] = 0;
						}
						if (base[0] == 1) {
							base[1] = 1;
							base[0] = 0;
						}
						base[0] = 1;
						break;
					case 2://2루타
						for (int i = 1; i < 3; ++i) {
							if (base[i] == 1) {
								score++;
							}
							base[i] = 0;
						}
						if (base[0] == 1) {
							base[2] = 1;
							base[0] = 0;
						}
						base[1] = 1;
						break;
					case 3://3루타
						for (int i = 0; i < 3; ++i) {
							if (base[i] == 1) {
								score++;
							}
							base[i] = 0;
						}
						base[2] = 1;
						break;
					case 4://홈런
						for (int i = 0; i < 3; ++i) {
							if (base[i] == 1)
								score++;
							base[i] = 0;
						}
						score++;
						break;
					}
				}
			}
			answer = answer > score ? answer : score;
		} while (np(9 - 2));// 1번은 4번타자 고정이므로 8개의 경우의 수만 구한다.
		// end

		// 출력
		System.out.println(answer);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] >= p[j])
			--j;
		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;
		int k = size;
		while (i < k) {
			tmp = p[k];
			p[k--] = p[i];
			p[i++] = tmp;
		}
		return true;
	}
}
