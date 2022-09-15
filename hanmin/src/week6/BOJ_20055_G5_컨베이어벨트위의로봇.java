package hanmin.src.week6;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {
	// 297636kb 632
	static Queue<Integer> q;
	static int[] arr;
	static int[] visit;
	static int N;
	static int K;
	static int answer;
	static int k;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N * 2];
		visit = new int[N * 2];
		st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		for (int i = 0; i < N * 2; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		// 1 컨베이어 회전
		// 2 먼저올라간 로봇부터 이동 이동불가시 가만히 내구도-1
		// 3 올리는 위치 로봇 올리기 내구도-1
		// 4 내구도k이상시 종료
		while (k < K) {
			answer++;
			rotateBelt();
			moveRobot();
			putUpRobot();
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static void putUpRobot() {
		if (arr[0] == 0 || visit[0] != 0)
			return;
		visit[0] = 1;
		q.offer(0);
		if (--arr[0] == 0)
			k++;
	}

	private static void moveRobot() {
		int sz = q.size();
		for (int i = 0; i < sz; ++i) {
			int now = q.poll();
			if (visit[now + 1] != 0 || arr[now + 1] == 0) {
				q.offer(now);
				continue;
			}
			visit[now] = 0;
			if (--arr[now + 1] == 0)
				k++;
			if (checkN(now + 1))
				continue;
			visit[now + 1] = 1;
			q.offer(now + 1);
		}

	}

	private static boolean checkN(int i) {
		if (i >= N - 1)
			return true;
		return false;
	}

	private static void rotateBelt() {
		int tmp = arr[N * 2 - 1];
		for (int i = N * 2 - 1; i > 0; --i) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;
		int sz = q.size();
		for (int i = 0; i < sz; i++) {
			int now = q.poll();
			visit[now] = 0;
			if (checkN(now + 1)) {
				continue;
			}
			q.offer(now + 1);
			visit[now + 1] = 1;
		}
	}
}
