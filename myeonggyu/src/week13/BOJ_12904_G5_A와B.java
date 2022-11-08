package week13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_12904_G5_A와B {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] tmp = sc.next().toCharArray();		

		ArrayList<Character> t = new ArrayList<>();
		for (Character tt : tmp) {
			t.add(tt);
		}
		while(s.length()!=t.size()) {
			
			if(t.get(t.size()-1) == 'A') {
				t.remove(t.size()-1);
			}
			else {
				t.remove(t.size()-1);
				Collections.reverse(t);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : t) {
			sb.append(c);
		}
		String ss = sb.toString();
		if(ss.equals(s))
			System.out.println(1);
		else
			System.out.println(0);
		
	}

}
