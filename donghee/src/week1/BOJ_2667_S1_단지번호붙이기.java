package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ_2667_S1_단지번호붙이기 {
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> answers;
	static int N;
	static int Count;
	static int cntHomes;
	static boolean returnChk;

	static StringBuilder sb;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		answers = new ArrayList<>();

		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		} // end of reading

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				if (map[i][j] != 0) {
					find(i, j);
					Count++;
					answers.add(cntHomes);
					cntHomes = 0;
				}
			}
		}
		answers.sort(Comparator.naturalOrder());
		for (int i = 0; i < answers.size(); i++) {
			sb.append(answers.get(i) + "\n");
		}

		System.out.println(Count + "\n" + sb.toString());
	}

	private static void find(int r, int c) {
		visited[r][c] = true;
		cntHomes++;

		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == false && map[nr][nc] != 0) {
				find(nr, nc);
			}
		}
	}

}
