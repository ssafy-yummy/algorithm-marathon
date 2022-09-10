package hanmin.src.week6;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3184_S1_양 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> list;
	static char[][] map;
	static int[][] visit;
	static int s;
	static int w;
	static int R;
	static int C;
	static int answer;
	static int answer2;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		list = new ArrayList<>();
		for (int i = 0; i < R; ++i) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				if (map[i][j] == 'o' || map[i][j] == 'v') {
					list.add(new Point(j, i));
				}
			}
		}
		// start
		visit = new int[R][C];
		for (int i = 0; i < list.size(); ++i) {
			int nx = list.get(i).x;
			int ny = list.get(i).y;
			if (visit[ny][nx] != 0)
				continue;
			w = 0;
			s = 0;
			if (map[ny][nx] == 'v')
				w++;
			else
				s++;
			//울타리 안의 양과 늑대 갯수 카운트
			func(ny, nx);
			//양이 많다면 생존
			if (s > w)
				answer += s;
			else
				answer2 += w;
		}
		// end

		// 출력
		System.out.println(answer + " " + answer2);

	}

	private static void func(int y, int x) {
		visit[y][x] = 1;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= C || ny < 0 || ny >= R)
					continue;
				if (visit[ny][nx] != 0)
					continue;
				if (map[ny][nx] == '#')
					continue;
				if (map[ny][nx] == 'v')
					w++;
				if (map[ny][nx] == 'o')
					s++;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
		}
	}
}
