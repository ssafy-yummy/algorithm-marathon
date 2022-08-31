package hanmin.src.week5;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_G5_암호코드 {
	// 14256 124
	static int[][] dp;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();

		// start
		int sz = arr.length;
		dp = new int[sz][2];
		dp[0][0] = 1;
		// 0이 나오면 불가능
		if (arr[0] == '0') {
			System.out.println(0);
			return;
		}
		for (int i = 1; i < sz; ++i) {
			// 10,20제외 0, 30, 40, 50, 60, 70, 80 90이 나오면 불가능
			if (arr[i] == '0' && !(arr[i - 1] == '1' || arr[i - 1] == '2')) {
				System.out.println(0);
				return;
			}
			// 1~9까지 어떤수가 나오더라도 가능
			if (arr[i] != '0') {
				dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000;
			}
			// 2자리 알파벳이 가능하면
			if ((arr[i - 1] - '0') * 10 + arr[i] - '0' <= 26) {
				dp[i][1] = dp[i - 1][0];
			}
		}
		// end

		// 출력
		System.out.println((dp[sz - 1][0] + dp[sz - 1][1]) % 1000000);
	}
}
// 1 2 2 4 6
// 2
// 1-0

// 2 5
// 25
// 1-1

// 2 5 1
// 25 1
// 2-0

// 2 5 1 1
// 2 5 11
// 25 1 1
// 25 11
// 2-2

// 2 5 1 1 4
// 2 5 11 4
// 25 1 1 4
// 25 11 4
// 2 5 1 14
// 25 1 14
// 4-2

// 1
// 1-0

// 1 1
// 11
// 1-1

// 1 1 1
// 11 1
// 1 11
// 2-1

// 1 1 1 1
// 1 1 11
// 11 1 1
// 11 11
// 1 11 1
// 3-2

// 1 1 1 1 1
// 1 1 1 11
// 1 1 11 1
// 11 1 1 1
// 11 1 11
// 11 11 1
// 1 11 1 1
// 1 11 11
// 5-3