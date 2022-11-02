package week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843_G5_콘센트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(st.nextToken()));

		int max = 0; // 최대
		int min = 33000;// 최소
		int ans = 0;
		while (!pq.isEmpty()) {
			int now = pq.poll();
			max = Math.max(max, now);
			min = Math.min(min, now);

			arr.add(now);
			if (arr.size() == M || pq.isEmpty()) {
				// 충전기 충전량 빼주기
				ans += min;
				for (int x : arr) {
					int diff = x - min;
					if (diff != 0)
						pq.add(diff);
				}
				arr.clear();
				max = 0;
				min = 33000;
			}
		}
		System.out.println(ans);
	}
}
