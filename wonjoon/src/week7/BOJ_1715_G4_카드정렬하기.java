package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_G4_카드정렬하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		if (N == 1) {
			System.out.println(0);
			return;
		}

		while (pq.size() > 2) {
			int tmp = pq.poll() + pq.poll();
			ans += tmp;
			pq.add(tmp);
		}

		System.out.println(ans + pq.poll() + pq.poll());
	}
}
