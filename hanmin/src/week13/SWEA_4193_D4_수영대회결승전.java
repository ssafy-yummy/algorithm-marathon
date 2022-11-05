package hanmin.src.week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class SWEA_4193_D4_수영대회결승전 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int answer;
	static int[][] arr;
	static int[][] visit;
	static int N;

	static class point {
		int x;
		int y;
		int time;

		point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			Point s = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point e = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// start
			answer = -1;
			// time이 작은순으로 pq 생성
			PriorityQueue<point> pq = new PriorityQueue<>((point a, point b) -> Integer.compare(a.time, b.time));
			pq.offer(new point(s.x, s.y, 0));
			visit[s.x][s.y] = 1;
			while (!pq.isEmpty()) {
				point now = pq.poll();
				// 종료지점 도달
				if (now.x == e.x && now.y == e.y) {
					answer = now.time;
					break;
				}
				for (int dir = 0; dir < 4; ++dir) {
					int nx = now.x + dx[dir];
					int ny = now.y + dy[dir];
					// 범위초과
					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;
					// 방문한적이 있으면 continue
					if (visit[nx][ny] != 0)
						continue;
					// 벽이 있다면 continue
					if (arr[nx][ny] == 1)
						continue;
					// 소용돌이라면
					if (arr[nx][ny] == 2) {
						// 소용돌이가 잠잠해질때 까지의 시간을 더해서 pq에 추가
						int pass = 2 - now.time % 3;
						visit[nx][ny] = 1;
						pq.offer(new point(nx, ny, now.time + pass + 1));
						continue;
					}
					visit[nx][ny] = 1;
					pq.offer(new point(nx, ny, now.time + 1));
				}
			}
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}