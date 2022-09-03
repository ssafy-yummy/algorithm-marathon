package hanmin.src.week4;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7576_G5_토마토 {
	// 142220 648
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> list;
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int M;
	static int cnt;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					list.add(new Point(j, i));
				else if (arr[i][j] == 0)
					cnt++;
			}
		}

		// start
		// 안익은 토마토 없으면 0 출력
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		answer = -1;
		func();
		if (cnt > 0)
			answer = -1;
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func() {
		Queue<Point> q = new LinkedList<>();
		// 초기 익은 토마토 list 큐에 추가
		for (Point now : list) {
			visit[now.y][now.x] = 1;
			q.offer(new Point(now.x, now.y));
		}
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (visit[ny][nx] != 0)
					continue;
				if (arr[ny][nx] != 0)
					continue;
				//visit에 날짜값 저장
				visit[ny][nx] = visit[now.y][now.x] + 1;
				cnt--;
				answer = Math.max(visit[ny][nx] - 1, answer);
				q.offer(new Point(nx, ny));
			}

		}

	}
}
