package hanmin.src.week11;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2573_G4_빙산 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> ice;
	static int[][] map;
	static int[][] visit;
	static int[][] icc;
	static int N;
	static int M;
	static int answer;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new ArrayList<>();
		map = new int[N][M];
		icc = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//빙산 갯수 카운트
				if (map[i][j] != 0) {
					cnt++;
					ice.add(new Point(j, i));
				}
			}
		}

		// start
		answer = 0;
		//탐색시 빙산이 2개로 나눠졌다면 종료
		while (func(ice.get(0).x, ice.get(0).y) == cnt) {
			ice.clear();
			cnt = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[i][j] == 0)
						continue;
					//빙산 녹음
					map[i][j] -= icc[i][j];
					if (map[i][j] < 0)
						map[i][j] = 0;
					//빙산이 남아있다면 ice 리스트에 추가
					else if (map[i][j] > 0) {
						ice.add(new Point(j, i));
						cnt++;
					}
				}
			}
			//빙산이 모두 녹았으면 종료
			if (ice.size() == 0) {
				answer = 0;
				break;
			}
			answer++;
		}

		// end

		// 출력
		System.out.println(answer);
	}

	private static int func(int x, int y) {
		visit = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		visit[y][x] = 1;
		q.offer(new Point(x, y));
		int tmpCnt = 0;

		while (!q.isEmpty()) {
			Point now = q.poll();
			tmpCnt++;
			int iceCnt = 0;
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (map[ny][nx] == 0) {
					iceCnt++;
					continue;
				}
				if (visit[ny][nx] != 0)
					continue;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
			//인접한 바다 갯수 카운트
			icc[now.y][now.x] = iceCnt;
		}
		return tmpCnt;
	}
}
