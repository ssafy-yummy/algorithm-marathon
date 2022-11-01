package week13;

import java.util.Scanner;

public class SWEA_2503_D3_베스킨라빈스N {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			
			if(n%4 == 1)
				System.out.println("#" +t +" " + 1);
			else
				System.out.println("#" +t +" " + 0);
		}
	}
	
}

