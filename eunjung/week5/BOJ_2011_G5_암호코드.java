package boj;
import java.io.*;

public class BOJ_2011_G5_암호코드 {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		dp = new int[len+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		if(str.charAt(0) == '0')
			System.out.println(0); // 암호 시작이 잘못되었을 경우
		
		else if(str.charAt(len-1) == '0' && str.charAt(len-2) != '1' && str.charAt(len-2) != '2')
			System.out.println(0); // 암호가 해석이 안 될 경우
		
		else {
			for(int i = 2; i <= len; i++) {
				int a = Integer.parseInt(str.charAt(i-1) + "");
				if(a > 0) dp[i] = dp[i-1] % 1000000;
				
				a += Integer.parseInt(str.charAt(i-2) + "") * 10;
				
				if(a >= 10 && a <= 26) dp[i] = (dp[i] + dp[i-2]) % 1000000;
			}
			System.out.print(dp[len]);
		}
	}
}