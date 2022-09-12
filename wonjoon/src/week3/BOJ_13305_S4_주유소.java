package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] dist = new long[N - 1];
		long[] citys = new long[N];

		for (int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			citys[i] = Long.parseLong(st.nextToken());
		}

		long sum = 0;
		long minPrice = citys[0];
		for (int i = 0; i < N - 1; i++) {
			if (citys[i] < minPrice) {
				minPrice = citys[i];
			}
			sum += minPrice * dist[i];
		}
		System.out.println(sum);
	}
}
