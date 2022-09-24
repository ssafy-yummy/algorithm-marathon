package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_S2_부분수열의합 {
	
	static int N,S,nums[],result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		S= Integer.parseInt(st.nextToken());
		
		nums= new int[N];
		visited=new boolean[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i]= Integer.parseInt(st.nextToken());
		}// end of reading
		
		if(S==0)result--;
		subset(0);
		System.out.println(result);
	}
	private static void subset(int cnt) {
		if(cnt ==N) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					sum +=nums[i];
				}
			}
			if(sum==S) {
				result++;
			}
			return;
		}
		
			visited[cnt]=true;
			subset(cnt+1);
			visited[cnt]=false;
			subset(cnt+1);
	}

}
