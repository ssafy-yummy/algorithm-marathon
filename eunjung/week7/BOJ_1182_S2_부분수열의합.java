package week7;

import java.util.*;

public class BOJ_1182_S2_부분수열의합 {
	static int N,S;
	static int[] arr;
	static int count;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		S = scann.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scann.nextInt();
		}
		
		// 수열의 시작 위치별로 dfs
		for (int i = 0; i < N; i++) {
			dfs(i,0);
		}
		
		System.out.println(count);
	}

	private static void dfs(int index, int sum) {
		sum+=arr[index];
		
		// 부분수열의 합이 S와 일치할 경우 count++
		if(sum==S) {
			count++;
		}
		
		// backtracking
		for (int i = index+1; i < arr.length; i++) {
			dfs(i,sum);
		}
	}
}
