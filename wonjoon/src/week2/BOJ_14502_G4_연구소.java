package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_G4_연구소 {

	static int N, M, ans = 0;
	static int[][] board, simul;
	static ArrayList<SafeZone> sz = new ArrayList<>(); // 조합에 사용할 안전 구역 좌표
	static ArrayList<Virus> vs = new ArrayList<>(); // 큐에 넣을 바이러스 좌표
	static int[] threeWalls;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		simul = new int[N][M];
		threeWalls = new int[3];

		// board 생성 & 안전 구역, 바이러스 위치 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				board[i][j] = tmp;

				if (tmp == 0)
					sz.add(new SafeZone(i, j));

				if (tmp == 2)
					vs.add(new Virus(i, j));
			}
		}

		// 풀이
		combi(0, 0);

		// 정답
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt == 3) {

			// 시뮬 보드 초기화
			simulInit();

			// 바이러스 분포 & 안전 구역 최대값 저장
			ans = Math.max(ans, bfs());
			return;
		}

		for (int i = start; i < sz.size(); i++) {
			threeWalls[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	private static void simulInit() {
		// 시뮬 보드 생성
		for (int i = 0; i < board.length; i++) {
			System.arraycopy(board[i], 0, simul[i], 0, simul[i].length);
		}

		// 시뮬 보드에 벽 세우기
		for (int i = 0; i < 3; i++) {
			int r = sz.get(threeWalls[i]).r;
			int c = sz.get(threeWalls[i]).c;
			simul[r][c] = 1;
		}
	}

	private static int bfs() {
		int cnt = 0;

		Queue<Virus> vq = new LinkedList<>();

		for (Virus virus : vs) {
			vq.offer(virus);
		}

		while (!vq.isEmpty()) {
			Virus cur = vq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (checkNext(nr, nc)) {
					simul[nr][nc] = 2;
					vq.offer(new Virus(nr, nc));
				}
			}
		}

		// 바이러스 분포 후 안전 구역 카운팅
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (simul[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}

	private static boolean checkNext(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M && simul[nr][nc] == 0;
	}

	static class SafeZone {
		int r;
		int c;

		public SafeZone(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Virus {
		int r;
		int c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
