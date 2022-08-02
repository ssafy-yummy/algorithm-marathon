package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	static int N, M, l, m, r;
	static int[] A;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st1.nextToken());
		
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 2. 문제 풀기
		for (int i = 0; i < M; i++) {
			bw.write(solve(Integer.parseInt(st2.nextToken())));
			bw.write("\n");
		}
		
		// 3. 출력
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 배열 A에 target이 들어있다면 1을 반환하고, 그렇지 않으면 0을 반환하는 메서드
	private static String solve(int target) {
		l = 0;
		m = N / 2;
		r = N - 1;
		
		while (l <= r) {
			if (A[m] == target)
				return "1";
			else if (A[m] < target)
				l = m + 1;
			else
				r = m - 1;
			m = (l + r) / 2;
		}
		
		return "0";
	}

}