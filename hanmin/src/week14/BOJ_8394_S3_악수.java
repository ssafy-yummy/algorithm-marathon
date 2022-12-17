package hanmin.src.week14;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8394_S3_악수 {
	static long[] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N];
		dp[0] = 1;
		dp[1] = 2;

		// start
		//자신의 앞사람과 악수하는 경우와 앞사람이 악수해서 안하는 경우로 나타냄
		//
		for (int i = 2; i < N; ++i) {
			//마지막 자리만 출력 == % 10 
			dp[i] = (dp[i - 2] + dp[i - 1])%10;
		}
		// end

		// 출력
		System.out.println(dp[N - 1]);
	}
}
