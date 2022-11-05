package hanmin.src.week13;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23843_G5_콘센트 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static Integer[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 큰수 순으로 정렬
		Arrays.sort(arr, (Integer a, Integer b) -> -Integer.compare(a, b));

		// start
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// M개의 콘센트를 pq에 추가
		for (int i = 0; i < M; ++i)
			pq.offer(0);
		// 충전시간이 긴순으로 pq에서 작은값을 poll해서 추가
		for (int i = 0; i < N; ++i) {
			int now = pq.poll();
			pq.offer(now + arr[i]);
		}
		// 가장 긴 충전시간 선택
		while (!pq.isEmpty())
			answer = Math.max(answer, pq.poll());

		// end

		// 출력
		System.out.println(answer);
	}
}
