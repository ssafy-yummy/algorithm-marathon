package hanmin.src.week8;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class SWEA_1953_탈주범검거 {
	static int answer;
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] map;
	static int[][] visit;
	static int[][] move = { { 0, }, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Set<Integer>[] move2;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new int[N][M];
			move2 = new Set[8];
			//hashset으로 각 파이프별 이동가능한 위치 저장
			for (int i = 1; i < 8; ++i) {
				move2[i] = new HashSet<>();
				for (int j = 0; j < move[i].length; ++j) {
					move2[i].add(move[i][j]);
				}
			}

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// start
			func(R, C, L);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int r, int c, int l) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(c, r));
		visit[r][c] = 1;
		answer = 0;
		//bfs로 탐색
		while (!q.isEmpty() && l > 0) {
			int sz = q.size();
			//1시간에 이동 가능한 거리
			for (int s = 0; s < sz; ++s) {
				Point now = q.poll();
				answer++;
				//파이프별 이동가능한 위치 
				for (int i = 0; i < move[map[now.y][now.x]].length; ++i) {
					int dir = move[map[now.y][now.x]][i];
					int nx = now.x + dx[dir];
					int ny = now.y + dy[dir];
					//범위 체크
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						continue;
					//이동할 위치 파이프 체크
					if (map[ny][nx] == 0)
						continue;
					//중복 체크
					if (visit[ny][nx] != 0)
						continue;
					//이동할 파이프와 이어져있는지 체크
					Boolean nextDir = move2[map[ny][nx]].contains((dir + 2) % 4);
					if (!nextDir)
						continue;
					visit[ny][nx] = visit[now.y][now.x] + 1;
					q.offer(new Point(nx, ny));
				}
			}			
			l--;
		}

	}
}