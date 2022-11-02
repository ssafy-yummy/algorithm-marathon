package hanmin.src.week11;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class SWEA_5653_줄기세포배양 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int answer;
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] visit;
	static List<point> list;
	static List<point> list2;

	static class point {
		int x;
		int y;
		int hp;

		point(int x, int y, int hp) {
			this.x = x;
			this.y = y;
			this.hp = hp;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			//음수 방향으로 무한히 증식하므로 위치 조정 
			map = new int[N + 800][M + 800];
			visit = new int[N + 800][M + 800];
			list = new ArrayList<>();
			list2 = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					map[i + 350][j + 350] = Integer.parseInt(st.nextToken());
					//세포다있다면 list에 추가
					if (map[i + 350][j + 350] != 0) {
						list.add(new point(j + 350, i + 350, map[i + 350][j + 350]));
						visit[i + 350][j + 350] = 1;
					}
				}
			}

			// start
			int k = 0;
			//K시간동안 반복
			while (k++ < K) {
				//list 깊은 복사
				for (point l : list)
					list2.add(l);
				for (point l : list) {
					//양수 비활성 상태
					//음수 활성상태
					//0 죽은 상태
					
					//비활성상태면 -1
					if (map[l.y][l.x] > 0) {
						map[l.y][l.x]--;
						if (map[l.y][l.x] == 0)
							map[l.y][l.x] = -l.hp;
					}
					//활성상태면 0까지 +1
					else if (map[l.y][l.x] < 0) {
						func(l.x, l.y, l.hp);
						map[l.y][l.x]++;
					}
				}
				list.clear();
				//죽은 세포가 아닌 것만 카운트
				for (point l : list2)
					if (map[l.y][l.x] != 0)
						list.add(l);
				list2.clear();
			}
			answer = list.size();
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	//사방 탐색하며 번식
	private static void func(int x, int y, int hp) {
		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (visit[ny][nx] != 0)
				continue;
			visit[ny][nx] = 1;
			map[ny][nx] = hp;
			list2.add(new point(nx, ny, hp));
		}
	}
}