package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 구현 + 덱으로 해결!
public class BOJ_3190_G4_뱀 {

	static StringTokenizer st;
	static int[][] board;
	static int n, k, l;
	// 오, 아, 왼 ,위
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static ArrayList<Node> snakes = new ArrayList<>();

	// 현재 방향
	static int curDir = 0;
	static String[][] commands;

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n + 1][n + 1];

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int ar = Integer.parseInt(st.nextToken());
			int ac = Integer.parseInt(st.nextToken());
			board[ar][ac] = 1;
		}

		l = Integer.parseInt(br.readLine());
		commands = new String[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			String dir = st.nextToken();
			commands[i][0] = time;
			commands[i][1] = dir;
		}

		// 풀이 & 출력
		System.out.println(solution());
	}

	static int solution() {

		int time = 0;
		int turnIdx = 0;

		// snakeR, snakeC 초기값 (1, 1)
		int sr = 1;
		int sc = 1;

		snakes.add(new Node(sr, sc));

		while (true) {
			time++;
			int nr = sr + dr[curDir];
			int nc = sc + dc[curDir];

			// 이동할 때 마다 벽인지 or 몸통인지 or 사과인지 확인
			// 벽이면 return
			if (nr == 0 || nr > n || nc == 0 || nc > n) {
				return time;
			}

			// 몸통이면 return
			for (int j = 0; j < snakes.size(); j++) {
				Node snake = snakes.get(j);
				if (snake.r == nr && snake.c == nc) {
					return time;
				}

			}

			// 이동 시 다음 장소에 머리 추가
			snakes.add(new Node(nr, nc));

			if (board[nr][nc] == 1) {
				// 사과 먹으면 0으로 바꿈
				board[nr][nc] = 0;
			} else {
				// 평지면 끝(큐 0번째)에 꼬리 자름
				snakes.remove(0);
			}

			// 수행 완료 후 좌표 수정
			sr = nr;
			sc = nc;

			// turn 명령어를 다 수행할 때 까지
			if (turnIdx < l) {
				int turn = Integer.parseInt(commands[turnIdx][0]);
				String nextDir = commands[turnIdx][1];

				if (time == turn) {
					// 우회전
					if (nextDir.equals("D")) {
						curDir = (curDir + 1) % 4;
					} else {
						// 좌회전 0이면 방향 배열 뒤쪽으로 전환
						if (curDir == 0)
							curDir = 3;
						else
							curDir -= 1;
					}
					turnIdx++;
				}
			}
		}
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
