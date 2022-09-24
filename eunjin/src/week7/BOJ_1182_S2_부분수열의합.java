package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_S2_부분수열의합 {

	static int N, S, arr[], ans;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		
		if(S==0) ans--;	// 크기가 0인 부분수열의 경우도 구해서 하나 뺌
		System.out.println(ans);
	}

	private static void subset(int cnt, int total) {
		if(cnt==N) {
			if(total==S) ans++;
			return;
		}
		visited[cnt]=true;
		subset(cnt+1, total+arr[cnt]);
		visited[cnt]=false;
		subset(cnt+1, total);
	}

}
