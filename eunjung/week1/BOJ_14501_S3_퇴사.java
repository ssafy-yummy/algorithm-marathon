package week1;

import java.util.Scanner;

public class BOJ_14501_S3_퇴사 {
	static int N;
	static int[][] map;
	static int max = -1;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt()	;
		map = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			map[i][0] = scann.nextInt(); // 걸리는 일 수
			map[i][1] = scann.nextInt(); // pay
		}
		
		dfs(0,0);
		System.out.println(max);
	}
	
	private static void dfs(int day, int sum) {
		// 주어진 일 수와 일치할 경우
		if(day==N) {
			max = Math.max(max, sum);
			return;
		}
		// 주어진 일 수 범위 내의 경우 recursion
		if(day+map[day][0]<=N) {
			dfs(day+map[day][0], sum+map[day][1]);
		}
		// 주어진 일 수를 초과할 경우
		else {
			max = Math.max(max, sum);
			dfs(day+1, sum);
			return;
		}
		dfs(day+1, sum);
	}
}
