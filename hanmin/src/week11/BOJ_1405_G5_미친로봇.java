package hanmin.src.week11;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1405_G5_미친로봇 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[][] visit;
	static int N;
	static double[] per;
	static double answer;
	static double answer2;
	static double mx;
	static double hit;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		per = new double[4];
		visit = new int[31][31];
		for (int i = 0; i < 4; ++i)
			per[i] = Double.parseDouble(st.nextToken()) / 100;

		// start
		mx = Math.pow(4, N);
		visit[15][15] = 1;
		func(15, 15, N, 1.0);
		double tmp = hit / mx;
		answer = 1.0 - hit;
		// end

		// 출력
		System.out.println(answer2);
	}

	private static void func(int x, int y, int n, double np) {
		if (n == 0) {
			answer2 += np;
			return;
		}
		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			double nper = per[dir];

			if (visit[ny][nx] != 0) {
				// 겹쳤다 = 이후의 모든 경우도 겹친다.
				double t = Math.pow(4, n - 1);
				hit += (Math.pow(4, n - 1)) * np * nper;
				continue;
			}
			visit[ny][nx] = visit[y][x] + 1;
			func(nx, ny, n - 1, np * nper);
			visit[ny][nx] = 0;
		}
	}
}
