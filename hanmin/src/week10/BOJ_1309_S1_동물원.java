package hanmin.src.week10;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_S1_동물원 {
	static int[][] dp;
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][3];

		// start
		// dp를 3가지 부분으로나눔
		// dp[i][0] i단계에서 우리를 사용하지 않았을 경우
		// dp[i][1] i단계에서 첫번째 우리를 사용했을 경우
		// dp[i][2] i단계에서 두번째 우리를 사용했을 경우
		// dp[i][0] = 전 단계의 모든 경우의 수 가능
		// dp[i][1] and dp[i][2] = 전 단계에서 자기 위치 우리 빼고 사용 가능
		
		dp[0][0] = 1;
		for (int i = 1; i < N + 1; ++i) {
			dp[i][0] += (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] += (dp[i - 1][0] + dp[i - 1][1]) % 9901;
			dp[i][2] += (dp[i - 1][0] + dp[i - 1][2]) % 9901;
		}
		// end

		// 출력
		answer = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
		System.out.println(answer);
	}
}
