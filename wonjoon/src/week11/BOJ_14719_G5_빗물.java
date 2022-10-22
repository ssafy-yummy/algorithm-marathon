package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {

	// 1번 방법 1. 높이를 하나씩 받아 거리와 곱하면서 고인 빗물을 구한다.
	// 실패 : 오른쪽으로 점차 상승하는 부분은 구할 수 있지만 내려가는 부분은 최대 높이를 구할 수 없다. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W];
		int ans = 0;
		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < W; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < W - 1; i++) {
			left = right = 0;

			for (int j = 0; j < i; j++)
				left = Math.max(arr[j], left); // 왼쪽 기둥

			for (int j = i + 1; j < W; j++)
				right = Math.max(arr[j], right); // 오른쪽 기둥

			// 현재 고인 빗물
			if (arr[i] < left && arr[i] < right)
				ans += Math.min(left, right) - arr[i];
		}
		System.out.println(ans);
	}
}