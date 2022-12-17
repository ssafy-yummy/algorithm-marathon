package week14;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_8394_S3_악수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] l = new int[n];
		int[] r = new int[n];
		int[] z = new int[n];
		l[0] = 0;//왼쪽
		r[0] = 1;//오른쪽
		z[0] = 1;//안하기
		
		for (int i = 1; i < n; i++) {
			l[i] = (r[i-1])%10;
			r[i] = (z[i-1]+l[i-1])%10;
			z[i] = (l[i-1]+z[i-1])%10;
			
		}
		
		System.out.println((l[n-1]+z[n-1])%10);
	}

}
