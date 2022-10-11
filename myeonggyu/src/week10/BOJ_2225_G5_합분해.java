package week10;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2225_G5_합분해 {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] map = new int[k][n+1];
		for (int i = 0; i < k; i++) {
			Arrays.fill(map[i], 1);
		}
		
		for (int i = 1; i < k; i++) {
			
			
			
			//i개를 써서 j를 만드는 경우의 수 map[i][j]
			for (int j = 1; j < n+1; j++) {
				
				map[i][j] = (map[i][j-1] + map[i-1][j])%1000000000;
				
			
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println(map[k-1][n]);
		
		
		
	}

}
