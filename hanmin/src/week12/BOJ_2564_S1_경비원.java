package hanmin.src.week12;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2564_S1_경비원 {
	static int[][] arr;
	static int K;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new int[K][2];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = changeDir(Integer.parseInt(st.nextToken()));
			arr[i][1] = changeLoc(arr[i][0], Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		int ddir = changeDir(Integer.parseInt(st.nextToken()));
		int dloc = changeLoc(ddir, Integer.parseInt(st.nextToken()));

		// start
		for (int i = 0; i < K; ++i) {
			int dir = arr[i][0];
			int loc = arr[i][1];
			int n = N, m = M;
			if (ddir % 2 == 0) {
				n = M;
				m = N;
			}

			//같은 선위에 존재
			if (ddir == dir) {
				answer += calcLine(dloc, loc);
			} else if ((ddir + 2) % 4 == dir) {
				//평행한 위치에 존재
				answer += calcPallel(n-dloc, loc, n, m);
			} else {
				//수직으로 만남
				if ((ddir + 1) % 4 == dir)
					answer += calcRightAngle(n - dloc, loc);
				else
					answer += calcRightAngle(dloc, m - loc);
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}

	static int changeDir(int dir) {
		int ndir = -1;
		switch (dir) {
		case 1:
			ndir = 0;
			break;
		case 2:
			ndir = 2;
			break;
		case 3:
			ndir = 3;
			break;
		case 4:
			ndir = 1;
			break;
		}
		return ndir;
	}

	static int changeLoc(int dir, int loc) {
		int nloc = loc;
		switch (dir) {
		case 2:
			nloc = M - loc;
			break;
		case 3:
			nloc = N - loc;
			break;
		}
		return nloc;
	}

	static int calcPallel(int p1, int p2, int n, int m) {
		return Math.min(p1 + p2, n - p1 + n - p2) + m;
	}

	static int calcLine(int p1, int p2) {
		return Math.abs(p1 - p2);
	}

	static int calcRightAngle(int p1, int p2) {
		return p1 + p2;
	}
}
