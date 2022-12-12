package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6549_P5_히스토그램에서가장큰직사각형 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			long maxs = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0)
				break;
			
			int[] histogram = new int[n];			
			for (int i = 0; i < n; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
				
			}
			
			Stack<int[]> stack = new Stack<>();
			
			
			
			for (int i = 0; i < n; i++) {
				
					
				while(!stack.isEmpty() && stack.peek()[0] >= histogram[i]) {
					
					//사각형 계산
					int[] cur = stack.pop();
					
					long width = stack.isEmpty() ? i : i-stack.peek()[1]-1;
					long height = cur[0];
					
					
					long ans = width*height;
					maxs = Math.max(ans, maxs);							
				}
				
				
			
				
				stack.push(new int[] {histogram[i],i});
					
				
			}
			
			while(!stack.isEmpty()) {
				
				int[] cur = stack.pop();
				
				long width = stack.isEmpty() ? n : n-stack.peek()[1]-1;
				long height = cur[0];
				
				long ans = width*height;
				maxs = Math.max(ans, maxs);			
				
			}
			sb.append(maxs+"\n");
		}
			
		System.out.println(sb.toString());
		
	}

}
