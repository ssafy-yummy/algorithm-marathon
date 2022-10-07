package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207_S1_달력 {

	static int N, ans;
	static int[] days;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		days = new int[366];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int idx = s; idx <= e; idx++) {
				days[idx]++;
			}
		}

		int ans = 0;
		int size = 0;
		int idx = 0;
		for (int i = 1; i <= 365; i++) {
			if (days[i] != 0) {
				size++;
				idx = Math.max(idx, days[i]);
			} else {
				ans += idx * size;
				idx = 0;
				size = 0;
			}
		}
		if (size != 0) {
			ans += idx * size;
			idx = 0;
			size = 0;
		}
		System.out.println(ans);
	}
}
