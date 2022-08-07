package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {

	static int N, M;
	static int[] A;
	static int[] B;

	static int head;
	static int tail;
	static int target;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		} // end of reading

		StringBuilder sb = new StringBuilder();

		Arrays.sort(A);

		for (int i = 0; i < M; i++) {
			chk = false;
			target = B[i];
			head = 0;
			tail = A.length - 1;

			while (head <= tail) {
				int mid = (head + tail) / 2;

				if (target == A[mid]) {
					sb.append("1\n");
					chk = true;
					break;
				}

				else if (target < A[mid]) {
					tail = mid - 1;
				} else if (target > A[mid]) {
					head = mid + 1;
				}
			}

			if (!chk) {

				sb.append("0\n");
			}
		}

		System.out.println(sb.toString());

	}

}
