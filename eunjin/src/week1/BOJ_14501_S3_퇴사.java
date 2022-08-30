package week1;

import java.util.Scanner;

public class BOJ_14501_S3_퇴사 {

	static int N;
	static int[] T, P;
	static int sum, max_sum;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		} // 입력 끝
		
		dfs(0,sum);
		System.out.println(max_sum);

	}

	private static void dfs(int start, int s) {
		
		for(int i=start; i<=N; i++) {
			if(i==N) {
				max_sum = Math.max(max_sum, s);
				return;	// 재귀가 끝나는 조건
			}
			if(T[i]>N-i || visited[i]) continue;	// 상담 기간이 N일을 넘기면 안 됨
			
			for(int j=0; j<T[i]; j++)
				visited[i+j]=true;
			s += P[i];
			dfs(i+1,s);
			for(int j=0; j<T[i]; j++)
				visited[i+j]=false;
			s -= P[i];
		}
	}

}
