package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252_G3_줄세우기 {
	static int[] indegree;
	static int N,M;
	static ArrayList<Integer>[] l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N+1];
		l = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			l[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			l[a].add(b);
			indegree[b]++;
		}
		
		sort();
    	
	}

	private static void sort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(indegree[i]==0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num+" ");
			
			if (l[num].size() == 0) continue;

			for (int i = 0; i < l[num].size(); i++) {
				int cur = l[num].get(i);
				indegree[cur]--;
				if(indegree[cur]==0) q.add(cur);
			}
		}
	}

}