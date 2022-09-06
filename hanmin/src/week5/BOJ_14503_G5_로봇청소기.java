package hanmin.src.week5;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14503_G5_로봇청소기 {
	// 14392 132
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { -1, 0, 1, 0, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[][] clean;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		clean = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// start
		func(y, x, d);
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int y, int x, int d) {
		int cnt = 0;
		while (true) {
			if (cnt == 4) {
				d = (d + 2) % 4;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (map[ny][nx] == 1) {
					break;
				}
				x = nx;
				y = ny;
				d = (d + 2) % 4;
				cnt = 0;
			}
			if (!isClean(y, x)) {
				answer++;
				clean[y][x] = 1;
			}
			d = (d + 3) % 4;
			int nx = x + dx[d];
			int ny = y + dy[d];
			cnt++;
			if (clean[ny][nx] == 1 || map[ny][nx] == 1)
				continue;
			y = ny;
			x = nx;
			cnt = 0;

		}
	}

	private static boolean isClean(int y, int x) {
		if (clean[y][x] == 1)
			return true;
		return false;
	}
}
