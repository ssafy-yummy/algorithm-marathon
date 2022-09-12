package hanmin.src.week3;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2293_G5_동전1 {
	// 14152kb 128ms
	static int[] dp;
	static int[] val;
	static int N;
	static int K;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		val = new int[N];
		dp = new int[K + 1];
		for (int i = 0; i < N; ++i) {
			val[i] = Integer.parseInt(br.readLine());
		}

		// start
		//N개의 동전을 이용해 K원을 만들기
		//dp[i] = i원을 만드는 방법의 수
		//dp[i]= dp[i-val[j]]
		//(i-val[j])원을 	이용해 i원의 방법을 찾을 수 있음 
		dp[0] = 1;
		for (int j = 0; j < N; ++j) {
			for (int i = 1; i <= K; ++i) {
				if (i >= val[j]) {
					dp[i] += dp[i - val[j]];
				}
			}
		}
		// end

		// 출력
		System.out.println(dp[K]);
	}
}
