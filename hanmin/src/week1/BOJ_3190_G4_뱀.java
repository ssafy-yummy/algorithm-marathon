import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3190_G4_뱀 {
	// N 100 * 100
	// 시간 (10000초 + 10000) *100
	// 시간복잡도 O(XK);
	static int[][] arr;
	static int N;
	static int K;
	static int L;
	static int[] dx = { 1, 0, -1, 0 };// 오 아 왼 위
	static int[] dy = { 0, 1, 0, -1 };
	static int answer;
	static int dir;
	static Map<Integer, Integer> m;
	static Deque<Point> snake;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		// 사과 위치 저장
		for (int i = 0; i < K; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y][x] = 1;
		}
		L = Integer.parseInt(br.readLine());
		m = new HashMap<>();
		// x초에 c회전 맵에 저장
		for (int i = 0; i < L; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			switch (c) {
			case 'L':
				m.put(x, 0);
				break;
			case 'D':
				m.put(x, 1);
				break;
			}
		}
		// 뱀 몸통 덱으로 저장
		snake = new LinkedList<>();
		snake.add(new Point(1, 1));
		simulation();
		System.out.println(answer);
	}

	// 뱀 시뮬
	private static void simulation() {
		// 0초에서 10000+10000초까지 루프
		while (true) {
			answer++;

			int x = snake.getFirst().x;
			int y = snake.getFirst().y;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 맵 경계 체크
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				return;
			}
			// 몸과 접촉
			for (Point body : snake) {
				if (body.x == nx && body.y == ny)
					return;
			}
			// 머리 이동
			snake.offerFirst(new Point(nx, ny));
			// 사과가 없으면 꼬리 이동
			if (arr[y][x] != 1) {
				snake.pollLast();
			}
			arr[y][x] = 0;

			// x초 끝난 후 방향이동
			if (m.get(answer) != null) {
				int changeDir = m.get(answer);
				if (changeDir == 0) // left
					dir = (dir + 3) % 4;
				else// right
					dir = (dir + 5) % 4;
			}
		}
	}

}
