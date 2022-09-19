package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_S2_결혼식 {
	static int N,M,result;
	static boolean[] visited;
	static List<Integer>[] adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		M= Integer.parseInt(br.readLine());
		adjList=new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adjList[i]=new ArrayList<>();
		}
		visited=new boolean[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
//		for (int i = 0; i < adjList.length; i++) {
//			System.out.println(Arrays.toString(adjList[i].toArray()));
//		}
		
		bfs();
		
		System.out.println(result);
		
	}
	private static void bfs() {
		Queue<Integer> que=new LinkedList<Integer>();
		visited[1]=true;
		for (int i = 0; i < adjList[1].size(); i++) {
			que.offer(adjList[1].get(i));
			visited[adjList[1].get(i)]=true;
			result ++;
		}
		
		while(!que.isEmpty()){
			int cur= que.poll();
			for (int i = 0; i < adjList[cur].size(); i++) {
				int tmp = adjList[cur].get(i);
				if(!visited[tmp]) {
					result ++;
					visited[tmp]=true;
				}
			}
		}
	}
	
	
	

}
