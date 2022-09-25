package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_S2_부분수열의합 {

	static int N, S, ans;
	static int[] arr, selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		subset(0, 0);

		// S가 0일 때 , 아무것도 사용하지 않는 경우로 1개 빼준다
		if (S == 0)
			ans--;

		System.out.println(ans);
	}

	private static void subset(int dep, int sum) {
		if (dep == N) {
			if (sum == S)
				ans++;
			return;
		}
		subset(dep + 1, arr[dep] + sum);
		subset(dep + 1, sum);

	}

}
