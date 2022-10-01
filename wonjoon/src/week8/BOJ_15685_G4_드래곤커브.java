package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685_G4_드래곤커브 {

	static int ans;
	static int[][] board;

	// 우 상 좌 하
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		board = new int[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(d);
			
			// 하나씩 빼서 방향 돌리고 다시 삽입
			for (int j = 0; j < g; j++) {
				int size = arr.size();
				for (int k = size - 1; k >= 0; k--) {
					arr.add((arr.get(k) + 1) % 4);
				}
			}

			
			// 완성된 세대의 커브 돌면서 기록
			for (int j = 0; j < arr.size(); j++) {
				int dir = arr.get(j);
				board[y][x] = 1;
				x += dx[dir];
				y += dy[dir];
				board[y][x] = 1;
			}

		}

		for (int i = 0; i < 101 - 1; i++) {
			for (int j = 0; j < 101 - 1; j++) {
				if (board[i][j] + board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1] == 4)
					ans++;
			}
		}

		System.out.println(ans);
	}
}
