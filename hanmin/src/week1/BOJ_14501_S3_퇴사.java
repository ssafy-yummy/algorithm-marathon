package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오답
public class BOJ_14501_S3_퇴사 {

	static int n;
	static int[][] works;
	static int ans = 0;
	// n일 동안 최대로 얻을 수 있는 수익
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		// 배열 초기화
		works = new int[n][2];
		for (int i = 0; i < works.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			works[i][0] = Integer.parseInt(st.nextToken());
			works[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			// t: 소모 시간
			int t = works[i][0];
			// p: 받는 금액
			int p = works[i][1];

			// 현재 날짜 i에 소모 시간 t을 더한 것이 총 시간 n을 넘어가지 않아야 한다.
			if (i + t <= n) {
				// 현재(i+t)까지 얻을 수 있는 최대 금액을 dp에 저장
				dp[i + t] = Math.max(dp[i + t], dp[i] + p);
			}
			// 해당 일자가 0인 경우 최대 값을 넣어준다.
			// 즉 해당 날짜에 일하지 않는다면 현재까지 최대 값을 넣어준다.
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
		// 오답 코드 .. 이중 포문으로 해결 X
//		for (int i = 0; i < works.length; i++) {
//			int time = 0;
//			int tmp = 0;
//			for (int j = i; j < works.length; j++) {
//				int t = works[j][0];
//				int p = works[j][1];
//				if (i + time + t <= n) {
//					time += t;
//					tmp += p;
//					j = i + time - 1;
//				}
//			}
//			ans = Math.max(ans, tmp);
//		}

	}
}
