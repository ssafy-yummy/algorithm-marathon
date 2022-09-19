package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_S2_나무자르기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] trees = new long[N];

		long low = 0;
		long high = Integer.MIN_VALUE;
		long mid = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			low = Math.min(low, trees[i]);
			high = Math.max(high, trees[i]);
		}

		while (low <= high) {
			mid = (low + high) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}

			if (M == sum) {
				break;
			} else if (sum > M) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (low > high) {
			System.out.println(high);
		} else {
			System.out.println(mid);
		}
	}

}
