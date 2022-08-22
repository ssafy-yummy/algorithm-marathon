package hanmin.src.week2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_G4_연구소 {
	static int[][] arr;
	static int[][] copy;
	static int[][] visit;
	static int[] comb;
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		// 입력
		// 64C3 = 41664
		// 정해서 막은 후 남은 구역 최댓값 계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		List<Point> zero = new ArrayList<>();
		List<Point> virus = new ArrayList<>();
		int cntWall = 0;
		int mx = N * M;
		int answer = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {// 0 위치 저장
					zero.add(new Point(j, i));
				} else if (arr[i][j] == 2) {
					virus.add(new Point(j, i));
				} else {// 벽 개수 카운트
					cntWall++;
				}
			}
		}
		// 벽 세울 위치 뽑기
		int sz = zero.size();
		comb = new int[sz];
		for (int i = sz - 1, cnt = 0; cnt < 3; --i, cnt++) {
			comb[i] = 1;
		}

		do {
			// 맵 복사
			copy = new int[N][M];
			for (int i = 0; i < N; ++i) {
				System.arraycopy(arr[i], 0, copy[i], 0, M);
			}
			visit = new int[N][M];
			// 벽 세우기
			for (int i = 0; i < sz; ++i) {
				if (comb[i] == 1) {
					Point wall = zero.get(i);
					copy[wall.y][wall.x] = 1;
				}
			}
			// 벽 + 바이러스 카운트
			int sum = cntWall + 3;
			for (int i = 0; i < virus.size(); ++i) {
				Point now = virus.get(i);
				sum += bfs(now.y, now.x);
			}
			// 안전 영역의 크기
			if (mx - sum > answer)
				answer = mx - sum;
		} while (np(sz - 1));

		System.out.println(answer);

	}

	// bfs로 바이러스 이동
	private static int bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[y][x] = 1;
		// 바이러스가 이동한 값
		int cnt = 0;
		while (!q.isEmpty()) {
			Point now = q.poll();
			cnt++;
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				// 범위 체크
				if (check(ny, nx))
					continue;
				// 방문 체크
				if (visit[ny][nx] == 1)
					continue;
				// 벽이거나 바이러스면 이동 불가
				if (copy[ny][nx] != 0)
					continue;
				visit[ny][nx] = 1;
				q.add(new Point(nx, ny));
			}
		}
		return cnt;
	}

	// 범위 초과 체크
	private static boolean check(int ny, int nx) {
		return (ny < 0 || ny >= N || nx < 0 || nx >= M);
	}

	// next_permutation
	private static boolean np(int size) {
		int i = size;
		while (i > 0 && comb[i - 1] >= comb[i])
			--i;
		int j = size;
		if (i == 0)
			return false;
		while (comb[i - 1] >= comb[j])
			--j;
		int tmp = comb[j];
		comb[j] = comb[i - 1];
		comb[i - 1] = tmp;
		int k = size;
		while (i <= k) {
			tmp = comb[i];
			comb[i] = comb[k];
			comb[k] = tmp;
			k--;
			i++;
		}
		return true;
	}
}
