package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_G5_A와B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		while (s.length() != t.length()) {
			if (t.charAt(t.length() - 1) == 'A') {
				t = t.substring(0, t.length() - 1);
			} 
			else {
				t = t.substring(0, t.length() - 1);
				t=new StringBuilder(t).reverse().toString();
			}

		}
		
		if(s.equals(t))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
