package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_G4_뱀 {

	static int[][] board;
	static int n;
	static int k;
	static int l;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static Queue<Node> snakes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n + 1][n + 1];

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ar = Integer.parseInt(st.nextToken());
			int ac = Integer.parseInt(st.nextToken());
			board[ar][ac] = 1;
		}

		System.out.println();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		l = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < l; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st2.nextToken());
			String dir = st2.nextToken();

//			for (int j = 0; j < time; j++) {
//				Node cur = snakes.poll();
//				
//				
//			}
		}

	}

	static void move() {
		
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
