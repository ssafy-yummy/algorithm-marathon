package hanmin.src.week9;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[][] visit;
	static int[] value;
	static int N;
	static int L;
	static int R;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new int[N][N];
		value = new int[N * N + 1];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		func();
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func() {
		int endFlg = 1;
		// 인구이동이 없을 때 까지 반복
		while (endFlg == 1) {
			endFlg = 0;
			// 인구값 value의 위치값
			int unionCnt = 0;

			// bfs 탐색으로 연합 카운트
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (visit[i][j] != 0)
						continue;

					if (bfs(i, j, ++unionCnt) == 1) {
						//한번이라도 탐색했다면 while문 반복
						endFlg = 1;
					}
				}
			}

			// visit 초기화 및 value값 재할당
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					visit[i][j] = 0;
					map[i][j] = value[map[i][j]];
				}
			}
			Arrays.fill(value, 0);
			
			if (endFlg == 1)
				answer++;
		}
	}

	private static int bfs(int y, int x, int union) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visit[y][x] = 1;
		// 연합 숫자 카운트
		int cnt = 0;

		while (!q.isEmpty()) {
			Point now = q.poll();
			cnt++;
			// 현재위치 나라의 인구수
			int nowPop = map[now.y][now.x];
			// 인구수를 위치값으로 변경
			map[now.y][now.x] = union;
			// 연합의 인구수 더하기
			value[union] += nowPop;
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (visit[ny][nx] != 0)
					continue;
				//이동할 나라의 인구수
				int nextPop = map[ny][nx];
				//차이가 LR값 사이가 아니라면 continue;
				int dif = Math.abs(nextPop - nowPop);
				if (dif < L || dif > R)
					continue;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
		}

		// 연합나라의 인구수
		value[union] /= cnt;

		// 방문한 나라의 수가 1일 경우 연합이 안이뤄짐
		if (cnt == 1)
			return 0;
		return 1;
	}
}
