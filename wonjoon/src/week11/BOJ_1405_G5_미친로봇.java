package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_G5_미친로봇 {

	static int N;
	static double ans;
	static boolean[][] visited = new boolean[30][30];
	static double[] dir = new double[4];
	static int[] dr = { 0, 0, 1, -1 }; // 동 서 남 북 : 우 좌 하 상
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 4; i++)
			dir[i] = Double.parseDouble(st.nextToken()) * 0.01;

		dfs(0, 15, 15, 1);

		System.out.println(ans);
	}

	static void dfs(int cnt, int r, int c, double sum) {
		if (cnt == N) {
			ans += sum;
			return;
		}

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!visited[nr][nc]) {
				dfs(cnt + 1, nr, nc, sum * dir[i]);
				visited[nr][nc] = false;
			}
		}
	}
}
