package week12;

import java.util.Scanner;

public class BOJ_2436_G5_공약수 {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		long gcd = scann.nextInt(); // 최대공약수
		long lcm = scann.nextInt(); // 최소공배수
		
		long AB = gcd*lcm;
		
		long ans1 = gcd, ans2 = AB/gcd;
		
		 for (long i = gcd; i * i <= AB; i += gcd) {
             if (AB % i == 0) {
                 long tmp = AB / i;

                 if (gcd(i, tmp) == gcd) {
                     if (ans1 + ans2 > i + tmp) {
                         ans1 = i;
                         ans2 = tmp;
                     }
                 }
             }
         }
		
		System.out.println(ans1+" "+ans2);
	}
	public static long gcd(long a, long b) {
        long res;
        
        while (b > 0) {
            res = a % b;
            a = b;
            b = res;
        }
        return a;
    }
}
