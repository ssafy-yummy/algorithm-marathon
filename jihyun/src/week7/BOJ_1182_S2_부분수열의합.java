package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_S2_부분수열의합 {
	static int answer = 0;
	static int n;
	static int s;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) { //길이가 1~n까지의 부분수열을 각각 구하기.
			dfs(0, 0, i, 0);
		}
		System.out.println(answer);

	}

	private static void dfs(int end, int start, int r, int sum) {
		if(end==r) { //구하고자 하는 길이의 부분수열이 구해지면
			if(sum==s) //내가 원한 합이 나왔을 때
				answer++; //count
			return;
		}
		for(int i=start;i<n;i++) { //부분수열 -> 즉 조합을 구하기
			dfs(end+1,i+1,r,sum+arr[i]); //현재 부분수열 길이, 조합조건, 목표 부분수열 길이, 합계
		}
		
	}

}
