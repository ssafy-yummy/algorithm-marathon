package week13;

import java.io.*;
import java.util.*;

public class SWEA_2503_베스킨라빈스 {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		int ans;
		
		for (int t = 1; t <= T; t++) {
			int n = scann.nextInt();
			
			if(n%4==1) ans = 1;
			else ans = 0;
			System.out.println("#"+t+" "+ans);
		}
	}
}