package week10;

import java.util.Scanner;

public class BOJ_1309_S1_동물원 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		
		int[][] map = new int[n+1][3];
		map[1][0] = 1;
		map[1][1] = 1;
		map[1][2] = 1;
		
		for (int i = 2; i < n+1; i++) {
			
			map[i][0] = (map[i-1][0] + map[i-1][1] + map[i-1][2])%9901;
			map[i][1] = (map[i-1][0] + map[i-1][2])%9901;
			map[i][2] = (map[i-1][0] + map[i-1][1])%9901;
			
		}
		
		int sum = 0;
		for (int i : map[n]) {
			sum += i;
		}
		
		System.out.println(sum%9901);
		
		
	}

}
