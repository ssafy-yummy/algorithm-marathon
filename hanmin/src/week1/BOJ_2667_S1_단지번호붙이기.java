import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	// N 25 * 25
	// 시간복잡도 O(N^2);
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int mx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		// 해당 위치 방문했는지 체크
		visit = new int[N][N];
		// 단지 번호 해당 단지모두 돌면 증가
		int cnt = 1;
		// 단지의 크기 저장
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); ++j) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				// 1 집이 있는 곳 이고 방문한적 없다면 탐색시작
				if (arr[i][j] == 1 && visit[i][j] == 0) {
					// 단지크기 초기화
					mx = 0;
					// 시작점 방문체크 잊지말기
					visit[i][j] = cnt;
					search(i, j, cnt++);
					list.add(mx);

				}
			}
		}
		// 정렬 후 출력
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); ++i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	// 인접한 단지 탐색
	private static void search(int y, int x, int cnt) {
		if (arr[y][x] == 1)
			mx++;
		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 범위 초과 체크후 초과시 continue
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			// 0이거나 방문한적 있다면 continue
			if (arr[ny][nx] == 0 || visit[ny][nx] != 0)
				continue;
			// 해당 위치 방문체크
			visit[ny][nx] = cnt;
			search(ny, nx, cnt);

		}
	}

}
