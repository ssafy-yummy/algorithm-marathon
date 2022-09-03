package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_G5_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = str.charAt(i - 1) - '0';
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			if(arr[i]>=1 && arr[i]<=9) { //일단 한자리를 암호로 처리한다.
				dp[i]=dp[i-1]%1000000; //이전 값을 그대로 물려받는다.
			}
			if(arr[i-1]*10+arr[i]>=10 && arr[i-1]*10+arr[i]<=26) { //만약 전 자리를 포함해서 총 두 자리가 암호가 가능하다면
				dp[i] = (dp[i] + dp[i-2])%1000000; //전전값을 추가한다.
			}
		}

		System.out.println(dp[n]);
	}

}
