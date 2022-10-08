package hanmin.src.week9;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1976_G4_여행가자 {
	static List<Integer> list;
	static int[][] map;
	static int[] p;
	static int N;
	static int M;
	static int answer;

	static int findp(int a) {
		if (p[a] == a)
			return a;
		return p[a] = findp(p[a]);
	}

	static int unionp(int a, int b) {
		a = findp(a);
		b = findp(b);
		if (a == b)
			return 0;
		if (a < b)
			p[b] = a;
		else
			p[a] = b;

		return 1;
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		for (int i = 0; i < N + 1; ++i)
			p[i] = i;
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//같은 집합에 속한다면 union
				if (map[i][j] == 1)
					unionp(i + 1, j + 1);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		// start
		int fst = list.get(0);
		answer = 1;
		for (int i = 1; i < M; ++i) {
			if (findp(fst) != findp(list.get(i)))
				answer = 0;
		}
		// end

		// 출력
		String ans = "NO";
		if (answer == 1)
			ans = "YES";

		System.out.println(ans);
	}
}
