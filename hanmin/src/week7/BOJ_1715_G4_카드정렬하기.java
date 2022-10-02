package hanmin.src.week7;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1715_G4_카드정렬하기 {
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}

		// start
		//값이 작은 값을 비교해야 최소값이 나온다
		//가장 작은 두개를 뽑아 비교후 추가
		while (pq.size() > 1) {
			int fst = pq.poll();
			int scd = pq.poll();
			answer += fst + scd;
			pq.offer(fst + scd);
		}
		// end

		// 출력
		System.out.println(answer);
	}
}
