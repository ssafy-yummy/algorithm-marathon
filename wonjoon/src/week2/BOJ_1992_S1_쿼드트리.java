package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_S1_쿼드트리 {

	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		cut(0, 0, N, N);
		System.out.println(sb);
	}

	private static void cut(int sr, int sc, int er, int ec) {
		for (int i = sr; i < er; i++) {
			for (int j = sc; j < ec; j++) {
				if (board[i][j] != board[sr][sc]) {
					int rowCut = (sr + er) / 2;
					int colCut = (sc + ec) / 2;

					sb.append("(");
					cut(sr, sc, rowCut, colCut);
					cut(sr, colCut, rowCut, ec);
					cut(rowCut, sc, er, colCut);
					cut(rowCut, colCut, er, ec);
					sb.append(")");
					return;
				}

			}

		}
		sb.append(board[sr][sc]);

	}
}
