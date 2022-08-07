package com.ssafy.algorithm.swea.S1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S1873 {

	static int r, c;
	static String[][] board;
	static int strLen;
	static String[] commands;

	static int tankR, tankC;
	static String tankDir;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static HashMap<String, int[]> dir = new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				"D:\\ssafy\\ssafy-java-workspace\\workspace\\src\\com\\ssafy\\algorithm\\swea\\S1873\\input3.txt"));

		dir.put("^", new int[] { -1, 0 });
		dir.put(">", new int[] { 0, 1 });
		dir.put("v", new int[] { 1, 0 });
		dir.put("<", new int[] { 0, -1 });

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			System.out.print("#" + tc + " ");
			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			board = new String[r][c];

			for (int i = 0; i < r; i++) {
				board[i] = br.readLine().split("");
				for (int j = 0; j < c; j++) {
					if (board[i][j].equals("<") || board[i][j].equals("^") || board[i][j].equals("v")
							|| board[i][j].equals(">")) {
						tankR = i;
						tankC = j;
						tankDir = board[i][j];
					}
				}
			}

			strLen = Integer.parseInt(br.readLine());
			commands = br.readLine().split("");

			for (String comm : commands) {
				int nr = tankR + dir.get(tankDir)[0];
				int nc = tankC + dir.get(tankDir)[1];

				switch (comm) {
				case "S":

					while (true) {

						if (!checkNext(nr, nc)) {
							break;
						}

						if (board[nr][nc].equals("#")) {
							break;
						}

						if (board[nr][nc].equals("*")) {
							board[nr][nc] = ".";
							break;
						}

						nr += dir.get(tankDir)[0];
						nc += dir.get(tankDir)[1];
					}
					break;

				case "U":
					tankDir = "^";

					nr = tankR + dir.get(tankDir)[0];
					nc = tankC + dir.get(tankDir)[1];

					move(nr, nc);

					break;

				case "D":
					tankDir = "v";
					nr = tankR + dir.get(tankDir)[0];
					nc = tankC + dir.get(tankDir)[1];

					move(nr, nc);
					break;

				case "L":
					tankDir = "<";
					nr = tankR + dir.get(tankDir)[0];
					nc = tankC + dir.get(tankDir)[1];
					move(nr, nc);
					break;

				case "R":
					tankDir = ">";
					nr = tankR + dir.get(tankDir)[0];
					nc = tankC + dir.get(tankDir)[1];
					move(nr, nc);
					break;
				}

			}
			for (String[] a : board) {
				for (String b : a) {
					System.out.print(b);
				}
				System.out.println();
			}
		}
	}

	static void move(int nr, int nc) {
		if (!checkNext(nr, nc) || board[nr][nc].equals("-") || board[nr][nc].equals("*") || board[nr][nc].equals("#")) {
			board[tankR][tankC] = tankDir;
			return;
		}
		board[tankR][tankC] = ".";

		tankR = nr;
		tankC = nc;
		board[tankR][tankC] = tankDir;

	}

	static boolean checkNext(int nr, int nc) {
		if ((nr >= 0 && nr < r) && (nc >= 0 && nc < c)) {
			return true;
		}
		return false;
	}
}
