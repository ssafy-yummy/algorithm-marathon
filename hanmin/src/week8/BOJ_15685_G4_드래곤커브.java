package hanmin.src.week8;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15685_G4_드래곤커브 {
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, 1, -1, 1, -1 };
	static List<P> list;
	static int[][] map;
	static int N;
	static int answer;

	static class P {
		int x;
		int y;
		int d;
		int g;

		P(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		list = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
			func(x, y, d, g);
			list.clear();
		}

		// start

		// end

		// 출력
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j) {
				// 사각형 꼭지점이 모두 있다면
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
					answer++;
			}
		}
		System.out.println(answer);
	}

	private static void func(int x, int y, int d, int g) {
		if (g == 0) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			map[ny][nx] = 1;
			list.add(new P(nx, ny, d, g));
			return;
		}
		// g가 0일때까지 재귀
		func(x, y, d, g - 1);
		// list의 끝위치 부터 시작
		int nx = list.get(list.size() - 1).x, ny = list.get(list.size() - 1).y;
		// list의 끝부터 탐색
		for (int i = list.size() - 1; i >= 0; --i) {
			P now = list.get(i);
			// 90도 회전
			int nd = (now.d + 1) % 4;
			nx = nx + dx[nd];
			ny = ny + dy[nd];
			if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101)
				continue;
			map[ny][nx] = 1;
			// 끝위치에 계속 추가
			list.add(new P(nx, ny, nd, g));
		}
	}
}
