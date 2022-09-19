package hanmin.src.week4.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class SWEA_ShuffleOMatic {
	static int answer;
	static int N;
	static int flg;
	static int[] arr;
	static Set<String> s;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			s = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// start
			answer = Integer.MAX_VALUE;
			flg = 0;
			func(arr);
			if (answer == Integer.MAX_VALUE)
				answer = -1;
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int[] card) {
		Queue<int[]> q = new LinkedList<>();
		q.add(card);
		isOverLap(card);
		int cnt = 0;
		if (isSort(card)) {
			answer = cnt;
			return;
		}
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int sz = 0; sz < size; ++sz) {
				int[] now = q.poll();
				for (int i = 0; i < N; ++i) {
					int[] tmpCard = new int[N];
					System.arraycopy(now, 0, tmpCard, 0, N);
					shuffleX(tmpCard, i);
					if (isSort(tmpCard)) {
						answer = cnt;
						return;
					}
					if (isOverLap(tmpCard))
						continue;
					q.add(tmpCard);
				}
			}
		}
	}

	// String으로 중복체크
	private static boolean isOverLap(int[] tmpCard) {
		String tmp = "";
		for (int i = 0; i < N; ++i) {
			if (tmpCard[i] >= 10) {
				char tmp2 = (char) (tmpCard[i] + 'A' - 10);
				tmp += tmp2;
				continue;
			}
			tmp += tmpCard[i];
		}
		if (s.contains(tmp))
			return true;
		s.add(tmp);
		return false;
	}

	private static void shuffleX(int[] tmpCard, int x) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i = 0; i < N / 2; ++i) {
			q1.offer(tmpCard[i]);
			q2.offer(tmpCard[i + N / 2]);
		}
		int idx1 = 0;
		int idx2 = 0;
		int idx = 0;
		x = N / 2 - x;
		while (idx1 < N / 2 && idx2 < N / 2) {
			if (x > 0) {
				tmpCard[idx++] = q1.poll();
				x--;
				idx1++;
			} else {
				tmpCard[idx++] = q2.poll();
				x++;
				idx2++;
			}
		}
		while (idx1 < N / 2) {
			tmpCard[idx++] = q1.poll();
			idx1++;
		}
		while (idx2 < N / 2) {
			tmpCard[idx++] = q2.poll();
			idx2++;
		}
	}

	private static boolean isSort(int[] arr) {
		for (int i = 0; i < N - 1; ++i) {
			if (Math.abs(arr[i] - arr[i + 1]) != 1)
				return false;
		}
		return true;
	}
}