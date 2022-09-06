package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_18352_S2_특정거리의도시찾기 {
	static int N,M,K,X;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static List<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken());
		
		result= new ArrayList<>();
		adjList= new ArrayList[N+1];
		visited= new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			adjList[i] =new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
		}
//		for (int i = 0; i < adjList.length; i++) {
//			System.out.println(Arrays.toString(adjList[i].toArray()));
//		}
		
		bfs();
		
		
		if(result.size()==0) {
			System.out.println(-1);
		}else {
			Collections.sort(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
		
	}


	private static void bfs() {
		visited[X]=true;
		Queue<int[]> que= new LinkedList<>();
		que.offer(new int[] {X,0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[1]==K) {
				result.add(cur[0]);
				continue;
			}
			
			for (int i = 0; i < adjList[cur[0]].size(); i++) {
				int tmp= adjList[cur[0]].get(i);
				if(!visited[tmp]) {
					que.offer(new int[] {tmp,cur[1]+1});
					visited[tmp]=true;
				}
				
			}
			
		}
		
	}
}
