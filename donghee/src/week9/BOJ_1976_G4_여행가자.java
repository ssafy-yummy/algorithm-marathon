package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1976_G4_여행가자 {
	
	
	static int N,M,ways[];
	static List<Integer>[] edges;
	static boolean[][] visited;
	static Queue<Integer> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ways =new int [M];
		edges= new List[N+1];
		visited= new boolean[N+1][N+1];
		que = new LinkedList<Integer>();
		for (int i = 0; i <= N; i++) {
			edges[i]=new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			visited[i][i]=true;
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					edges[i].add(j);
					visited[i][j]=true;
				}
			}
		}
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ways[i]= Integer.parseInt(st.nextToken());
		}//end of reading
		
		
//		for(List<Integer> i : edges) {
//			System.out.println(Arrays.toString(i.toArray()));
//		}
		
		for (int i = 1; i < M; i++) {
			if(visited[ways[i-1]][ways[i]])continue;
			boolean chk =true;
			boolean[] visited2= new boolean[N+1];
			visited2[ways[i]]=true;
			for (int j = 0; j < edges[ways[i]].size(); j++) {
				que.offer( edges[ways[i]].get(j));
				visited2[edges[ways[i]].get(j)] = true;
			}
			while(!que.isEmpty()) {
				int tmp = que.poll();
				if(tmp == ways[i-1]) {
					visited[ways[i-1]][ways[i]]=true;
					visited[ways[i]][ways[i-1]]=true;
					que.clear();
					chk =false;
					break;
				}
				for (int j = 0; j < edges[tmp].size(); j++) {
					if(!visited2[edges[tmp].get(j)]) {
						que.offer(edges[tmp].get(j));
						visited2[edges[tmp].get(j)]=true;
					}
				}
			}
			if(chk) {
				System.out.println("NO");
				System.exit(0);
			}
			
		}
		System.out.println("YES");
	}

}
