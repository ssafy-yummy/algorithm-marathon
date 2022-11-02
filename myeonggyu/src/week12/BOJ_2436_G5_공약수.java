package week12;

import java.util.Scanner;

public class BOJ_2436_G5_공약수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int tmp = y/x;
		int mins = Integer.MAX_VALUE;
		int ra = 0;
		int rb = 0;
		for (int i = 1; i <= tmp ; i++) {
			int a = i;
			if(tmp%i != 0)
				continue;
			int b = tmp/i;
			
			if(GCD(Math.max(a, b),Math.min(a, b)) != 1) {
				continue;
			}
			
			if(mins > a+b) {
				mins = a+b;
				ra = a;
				rb = b;
			}
		}
		ra *= x;
		rb *= x;
		System.out.println(Math.min(ra, rb)+" "+ Math.max(ra, rb));
		
	}
	
	static int GCD(int a,int b){
	    while(true){
	        int r = a%b;
	        if(r==0) return b;
			
	        a = b;
	        b = r;
	    }
	}

}