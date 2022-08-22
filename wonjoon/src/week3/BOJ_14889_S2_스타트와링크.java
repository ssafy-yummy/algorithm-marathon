package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_S2_스타트와링크 {

	static int N, ans = Integer.MAX_VALUE;
	static int[][] board;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt == N / 2) {
			makeTeam(nums);
			return;
		}

		for (int i = start; i < N; i++) {
			nums[i] = 1;
			combi(cnt + 1, i + 1);
			nums[i] = 0;
		}
	}

	private static void makeTeam(int[] nums) {

		int atot = 0, btot = 0;
		int[] al = new int[N / 2];
		int[] bl = new int[N / 2];
		int ai = 0;
		int bi = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				al[ai++] = i;
			} else {
				bl[bi++] = i;
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i == j)
					continue;
				atot += board[al[i]][al[j]];
				btot += board[bl[i]][bl[j]];
			}
		}
		ans = Math.min(ans, Math.abs(atot - btot));
	}
}
