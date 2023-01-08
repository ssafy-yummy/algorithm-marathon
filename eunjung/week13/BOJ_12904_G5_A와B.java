package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_12904_G5_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		boolean convert = false;
		
		while(true) {
			if(str2.length()==1) {
				if(str2.equals(str1)) {
					convert = true;
				}
				break;
			}
			if(str2.charAt(str2.length()-1) == 'A') {
				str2 = str2.substring(0, str2.length()-1);
			}
			else if(str2.charAt(str2.length()-1) == 'B') {
				str2 = str2.substring(0, str2.length()-1);
				StringBuffer sb = new StringBuffer(str2);
			    str2 = sb.reverse().toString();
			}
			
			if(str2.equals(str1)) {
				convert = true;
				break;
			}
		}
		
		if(convert) System.out.println(1);
		else System.out.println(0);
	}
}