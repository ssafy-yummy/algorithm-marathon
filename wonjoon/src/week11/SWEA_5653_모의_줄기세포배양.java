package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_모의_줄기세포배양 {

	static int N, M, K, ans;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Cell> ll, ld, dl, dd;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int[][] board = new int[N + K][M + K];

			PriorityQueue<Cell> live = new PriorityQueue<>(); // 활성 세포
			Queue<Cell> dead = new LinkedList<>(); // 비활성 세포
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp != 0) {

						int r = i + (K / 2);
						int c = j + (K / 2);
						board[r][c] = tmp;
						dead.add(new Cell(r, c, tmp));
					}
				}
			} // 입력

			for (int i = 0; i < K; i++) {
				liveCheck(live, board);
				deadCheck(dead, board);

				// 활성화 세포 추가
				for (Cell cell : ll)
					live.add(cell);
				for (Cell cell : dl)
					live.add(cell);

				// 비활성화 세포 추가
				for (Cell cell : ld)
					dead.add(cell);
				for (Cell cell : dd)
					dead.add(cell);
				
//				System.out.println(live);
//				System.out.println(dead);
				

			} // 풀이

			sb.append("#").append(tc).append(" ").append(live.size() + dead.size()).append("\n"); // 출력
		}
		System.out.println(sb);
	}

	private static void deadCheck(Queue<Cell> dead, int[][] board) {
		dl = new ArrayList<>(); // 활성화
		dd = new ArrayList<>(); // 활성 대기 중

		while (!dead.isEmpty()) {
			Cell c = dead.poll();
			if (c.level > 1) {
				dd.add(new Cell(c.r, c.c, c.level - 1)); // 대기중
			} else {
				dl.add(new Cell(c.r, c.c, board[c.r][c.c])); // 활성된 세포 추가
			}
		}
	}

	private static void liveCheck(PriorityQueue<Cell> live, int[][] board) {
		ll = new ArrayList<>(); // 활성중 세포
		ld = new ArrayList<>(); // 추가될 비활 세포

		while (!live.isEmpty()) {
			Cell c = live.poll();

			if (c.level > 1)
				ll.add(new Cell(c.r, c.c, c.level - 1));

			for (int i = 0; i < 4; i++) {
				int nr = c.r + dr[i];
				int nc = c.c + dc[i];
				if (board[nr][nc] == 0) {
					board[nr][nc] = board[c.r][c.c]; // 다음 위치에 현재 세포 추가
					ld.add(new Cell(nr, nc, board[c.r][c.c]));
				}
			}
		}
	}

	static class Cell implements Comparable<Cell> {
		int r;
		int c;
		int level;

		public Cell(int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.level, this.level);
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", level=" + level + "]";
		}
	}
}
