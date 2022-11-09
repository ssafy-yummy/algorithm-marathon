package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_12904_A와B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuffer T = new StringBuffer(br.readLine());
		
		while(S.length() != T.length()) {
			int n = T.length();
			char c = T.charAt(n-1);	// 문자열 T에서 맨 뒤의 문자
			T = T.deleteCharAt(n-1);	// 맨 뒤의 문자를 제거한다.
			if(c == 'B') {	// 맨 뒤의 문자가 'B'였을 때, 문자를 뒤집는다.
				T.reverse();
			}
		}
		
		System.out.println(S.equals(T.toString())?1:0);
	}

}
