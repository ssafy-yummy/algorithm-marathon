package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_S2_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Integer[] arr = new Integer[n];
		
		long max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max=Math.max(max, arr[i]);
		}

		long left = 0;
		long right = max;

		while (left <= right) { //이분탐색
			long mid = (long) ((left + right) / 2);
			long sum = 0;

			for (int i = 0; i < n; i++) { //현재 높이로 구할 수 있는 나무토막의 합을 구한다.
				if (arr[i] > mid)
					sum += arr[i] - mid;
			}
			if (sum >= m) //합이 m보다 크거나 같으면 현재 높이를 더 높인다
				left = mid + 1;
			else //합이 m보다 작으면 현재 높이를 더 낮춘다.
				right = mid - 1;
			//System.out.println(left + " "+right);
		}
		System.out.println(right);

	}

}
