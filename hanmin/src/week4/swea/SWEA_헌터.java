package hanmin.src.week4.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.awt.*;

class SWEA_헌터 {
	static int answer;
	static int N;
	static int cnt;
	static int[][] map;
	static int[] visit;
	// 헌터와 몬스터 위치값
	static Point[] m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static List<Integer> list;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			m = new Point[9];
			list = new ArrayList<>();
			cnt = 0;
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						cnt++;
						list.add(map[i][j]);
					} else if (map[i][j] < 0) {
						list.add(map[i][j]);
					}
				}
			}
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] != 0)
						m[map[i][j] + cnt] = new Point(j, i);
				}
			}
			// start
			answer = Integer.MAX_VALUE;
			visit = new int[cnt * 2];
			func(0, 0, 0, 0);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int n, int y, int x, int sum) {
		if (n == cnt * 2) {
			answer = Math.min(answer, sum);
			return;
		}
		for (int i = 0; i < cnt * 2; ++i) {
			if (visit[i] == 1)
				continue;
			int tmpSum = sum;
			int num = list.get(i);
			if (num < 0 && !check(num))// 집먼저방문 x
				continue;
			int ny = m[num + cnt].y;
			int nx = m[num + cnt].x;
			visit[i] = 1;
			tmpSum += calc(x, y, nx, ny);
			func(n + 1, ny, nx, tmpSum);
			visit[i] = 0;
		}
	}

	private static int calc(int x, int y, int nx, int ny) {
		return Math.abs(x - nx) + Math.abs(y - ny);
	}

	// 몬스터를 잡고 집에 방문하는지 확인
	private static boolean check(int num) {
		for (int i = 0; i < cnt * 2; ++i) {
			if (-num == list.get(i)) {
				if (visit[i] == 1)
					return true;
			}
		}
		return false;
	}

}