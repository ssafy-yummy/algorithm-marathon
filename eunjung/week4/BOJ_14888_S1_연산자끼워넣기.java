package week4;

import java.util.*;

public class BOJ_14888_S1_연산자끼워넣기 {
	static int N;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] num,ops,perm;
	static ArrayList<Character> operator = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		num = new int[N];
		visited = new boolean[N-1]; // 부호 방문 리스트
		
		for (int i = 0; i < N; i++) {
			num[i] = scann.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			int n = scann.nextInt();
			for (int j = 0; j < n; j++) {
				if(i==0) operator.add('+');
				if(i==1) operator.add('-');
				if(i==2) operator.add('*');
				if(i==3) operator.add('/'); // 리스트에 부호넣음
			}
		}
	
		dfs(1,num[0]);
		System.out.println(max);
		System.out.println(min); // 최댓값, 최솟값 출력
	}
	private static void dfs(int depth, int sum) {
		// 식이 끝날경우
		if(depth==N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		// 부호 순열 dfs
		for (int i = 0; i < N-1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth+1, calc(i,sum,num[depth])); // 계산메소드 호출하여 누적 계산값 구함
				visited[i] = false;
			}
		}
	}
	private static int calc(int index, int n1, int n2) {
		int result = 0;
		char ch = operator.get(index); // 부호 가져오고
		
		// 부호에 맞게 결과값 리턴
		switch(ch) {
			case '+': 
				result = n1+n2;
				break;
			case '-':
				result = n1-n2;
				break;
			case '*':
				result = n1*n2;
				break;
			case '/':
				result = n1/n2;
				break;
			}
		return result;
	}
}
