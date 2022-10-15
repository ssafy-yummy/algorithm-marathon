package week9;

import java.io.*;
import java.util.*;

public class BOJ_1916_G5_최소비용구하기 {
	static int N, M, result;
	static boolean[] visited;
	static ArrayList<int[]>[] l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];

		l = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			l[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			l[s].add(new int[] {e,p});
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start,end);

		System.out.println(result);
	}

	private static void dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(int[] o1, int[] o2) -> Integer.compare(o1[1],o2[1]));

		for (int i = 0; i < l[start].size(); i++) {
			int[] cur = l[start].get(i);
			pq.add(new int[] {cur[0],cur[1]});
		}
		visited[start] = true;
		
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if(now[0]==end) {
				result = now[1];
				break;
			}
			for (int i = 0; i < l[now[0]].size(); i++) {
				int[] cur = l[now[0]].get(i);
				if(!visited[cur[0]]) {
					pq.add(new int[] {cur[0],cur[1]+now[1]});
				}
			}
			visited[now[0]] = true;
		}
	}
}