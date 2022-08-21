package hanmin.src.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1992_S1_쿼드트리 {
	static int[][] map;
	static int N;
	static int[] dx = { 0, 1, 0, 1 };
	static int[] dy = { 0, 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(func(0, 0, N));
	}

	private static String func(int y, int x, int n) {
		//종료 조건 
		if (n == 1)
			return String.valueOf(map[y][x]);

		String ret = "(";
		String[] tmp = new String[4];
		for (int dir = 0; dir < 4; ++dir) {
			//사각형 4등분 탐색
			tmp[dir] = func(y + (n / 2 * dy[dir]), x + (n / 2 * dx[dir]), n / 2);
			ret += tmp[dir];
		}
		String check = tmp[0];
		int cnt = 1;
		//탐색한 부분이 같은지 체크
		for (int i = 1; i < 4; ++i) {
			if (check.length()==1 &&check.equals(tmp[i])) {
				cnt++;
			}
		}
		if (cnt == 4) {
			return check;
		}
		return ret + ")";
	}
}
