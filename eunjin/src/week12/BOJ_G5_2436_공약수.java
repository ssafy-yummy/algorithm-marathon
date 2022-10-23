package week12;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_G5_2436_공약수 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long GCD = sc.nextLong();	// 최대공약수
		long LCM = sc.nextLong();	// 최소공배수
		//read
		
		long a = (long)Math.sqrt((long)GCD*LCM);
		long b = 0;
		
		while (true) {
			if((GCD*LCM) % a == 0) {
				b = (GCD*LCM)/a;
				if(check(a, b, GCD))	// a와 b의 최대공약수가 GCD인지 검사
					break;
			}
			a--;
		}
		
		if(a==1) b = LCM;
		System.out.println(a+" "+b);
	}

	private static boolean check(long a, long b, long GCD) {
		return GCD==gcd(a,b);	// gcd(a,b) : a,b의 최대공약수를 구하는 함수
	}

	private static long gcd(long a, long b) {
		if(a<b) {	// 항상 a가 b보다 큰 수로 만들어준다. (a>b)
			long temp = b;
			b = a;
			a = temp;
		}
		
		if(b==0) return a;
		
		return gcd(a%b, b);
	}
}
