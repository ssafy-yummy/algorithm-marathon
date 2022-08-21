package hanmin.src.week3;

import java.util.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14889_S2_스타트와링크 {
	// N 20
	// 20C10 * 10^2
	// 51128kb 464ms
	static int[][] map;
	static int[] c;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		c = new int[N];
		for (int i = N / 2; i < N; ++i)
			c[i] = 1;
		int answer = Integer.MAX_VALUE;
		// NC2 계산
		do {
			List<Integer> team1 = new ArrayList<>();
			List<Integer> team2 = new ArrayList<>();
			// next_permutation으로 2팀 나누기
			for (int i = 0; i < N; ++i) {
				if (c[i] == 1) {
					team1.add(i);
				} else
					team2.add(i);
			}
			int sum1 = 0;
			int sum2 = 0;
			int sz = team1.size();
			// 팀별로 2명씩 뽑아서 능력치 계산
			for (int i = 0; i < sz; ++i) {
				for (int j = i + 1; j < sz; ++j) {
					int fst = team1.get(i);
					int snd = team1.get(j);
					sum1 += map[fst][snd] + map[snd][fst];
					fst = team2.get(i);
					snd = team2.get(j);
					sum2 += map[fst][snd] + map[snd][fst];
				}
			}
			// 차이의 최솟값
			if (Math.abs(sum1 - sum2) < answer)
				answer = Math.abs(sum1 - sum2);
		} while (NP(N - 1));
		// end

		// 출력
		System.out.println(answer);
	}

	private static boolean NP(int size) {
		int i = size;
		while (i > 0 && c[i - 1] >= c[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (c[i - 1] >= c[j])
			j--;
		int tmp = c[j];
		c[j] = c[i - 1];
		c[i - 1] = tmp;

		int k = size;
		while (i <= k) {
			tmp = c[i];
			c[i] = c[k];
			c[k] = tmp;
			k--;
			i++;
		}
		return true;
	}
}
