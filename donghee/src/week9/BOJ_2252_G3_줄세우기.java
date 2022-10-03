package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_G3_줄세우기 {
	
	
	static int N,M,indegree[];
	
	static Queue<Integer> que,result;
	static List<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		indegree= new int [N+1];
		arr= new List[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			indegree[b]++;
		}
		topology(indegree,arr);
		result.poll();
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
	}
	private static void topology(int[] indegree, List<Integer>[] arr) {
		que =new LinkedList<>();
		result =new LinkedList<>();
		
		result.toString();
		
		for (int i = 0; i < N+1; i++) {
			if(indegree[i]==0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			int node = que.poll();
			result.offer(node);
			
			for(Integer i: arr[node]) {
				indegree[i]--;
				
				if(indegree[i]==0) {
					que.offer(i);
				}
			}
		}
		
	}

}
