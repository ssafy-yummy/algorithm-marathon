package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2011_G5_암호코드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] data = br.readLine().toCharArray();

		// 첫 문자가 0이면 잘못된 문자열
		if (data[0] == '0') {
			System.out.println(0);
			return;
		}

		int[] dp = new int[data.length + 1];

		dp[0] = 1;
		dp[1] = 1;

		// 문자열이 i개일 때 dp 점화식 : dp[i] = dp[i - 2] + dp[i - 1]
		for (int i = 2; i <= data.length; i++) {
			String tmp = String.valueOf(data[i - 2]);
			char now = data[i - 1];

			// 현재가 0일 때
			if (now == '0') {
				// 앞자리가 1, 2가 아니면 (00, 30, 40, ... ,90) 잘못된 문자열
				if (tmp.equals("1") || tmp.equals("2"))
					dp[i] = dp[i - 2];
				else
					break;
			}
			// 앞자리가 0이면 경우의 수는 변화 없음
			else if (tmp.equals("0"))
				dp[i] = dp[i - 1];
			else {
				int tmpInt = Integer.parseInt(tmp + now);

				// 앞자리랑 연결해서 1~26사이에 들면 점화식 사용
				if (tmpInt > 0 && tmpInt < 27)
					dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000;
				else
					dp[i] = dp[i - 1];
			}

		}

		System.out.println(dp[data.length]);
	}
}
