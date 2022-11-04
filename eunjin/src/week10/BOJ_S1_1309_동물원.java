package week10;

import java.util.Scanner;

public class BOJ_S1_1309_동물원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = 1;
		int a = 1;
		int b = 0;
		for (int i = 0; i < N; i++) {
			b = a+b;
			a = ans;
			ans = (a+2*b)%9901;
		}
		
		System.out.println(ans);
	}
}
