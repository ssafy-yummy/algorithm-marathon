package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_8394_악수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 0;
		int ans = a+b;
		
		for (int i = 1; i < N; i++) {
			b = a;
			a = ans;
			ans = (a+b)%10;
		}
		
		System.out.println(ans);
	}

}
