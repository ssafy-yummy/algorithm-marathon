package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자_UF {

	static int N, M, idx;
	static int[][] board;
	static int[] schedule, parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		board = new int[N][N];
		makeSet();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					union(i, j);
			}
		}

		schedule = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			schedule[i] = find(Integer.parseInt(st.nextToken()));
		}

		int root = schedule[0];
		for (int i = 1; i < M; i++) {
			if (root != schedule[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// x의 부모 찾기
	private static int find(int x) {
		// 현재 자신 부모 체크
		if (parents[x] == x)
			return x;

		// 부모를 root로 지정
		return parents[x] = find(parents[x]);
	}

	// 부모 합치기
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		// 이미 같으면 return
		if (a == b)
			return;

		// 부모 값이 작은 쪽에 흡수
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}
}
