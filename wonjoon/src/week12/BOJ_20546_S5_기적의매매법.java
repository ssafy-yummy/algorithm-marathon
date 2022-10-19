package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546_S5_기적의매매법 {

	static int term = 14;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());
		int[] prices = new int[term + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= term; i++)
			prices[i] = Integer.parseInt(st.nextToken());
		prices[0] = prices[1];
		// 준형이 BNP , 성민이 타이밍
		int J = money;
		int jCnt = 0;
		int S = money;
		int sCnt = 0;
		int upCnt = 0;
		int downCnt = 0;

		for (int i = 1; i <= term; i++) {
			// 준형이가 주식 살 수 있으면
			if (J >= prices[i]) {
				// 전량 매수
				jCnt += J / prices[i];
				J %= prices[i];
			}

			// 주가 상승
			if (prices[i] > prices[i - 1]) {
				downCnt = 0;
				upCnt++;
				if (upCnt == 3) {
					// 준형 전량 매도
					S += (sCnt * prices[i]);
					upCnt = 0;
					sCnt = 0;

				}
			} else if (prices[i] < prices[i - 1]) {
				upCnt = 0;
				downCnt++;
				if (downCnt >= 3) {
					// 전량 매수
					sCnt += S / prices[i];
					S %= prices[i];
				}
			}
		}

		// 이익 계산
		J += (jCnt * prices[term]);
		S += (sCnt * prices[term]);

		if (J == S)
			System.out.println("SAMESAME");
		else
			System.out.println(J > S ? "BNP" : "TIMING");

	}
}
