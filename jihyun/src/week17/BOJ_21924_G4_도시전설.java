package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_21924_G4_도시전설 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}		
	}
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //건물의 개수
		int m = Integer.parseInt(st.nextToken()); //도로의 개수
		Edge[] edge = new Edge[m];
		long sum1 = 0;
		long sum2 = 0;
		parents = new int[n];
		for(int i=0;i<n;i++) {
			parents[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			sum1+=weight;
			edge[i] = new Edge(from,to,weight);
		}
		Arrays.sort(edge);
		
		int cnt = 0;
		long answer = -1;
		for(int i=0;i<m;i++) {
			Edge e = edge[i];
			if(Union(e.from, e.to)) {
				cnt++;
				sum2+=e.weight;
				if(cnt==n-1) {
					answer = sum1-sum2;
					break;
				}
			}
		}
		System.out.println(answer);
		
	}
	private static boolean Union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)
			return false;
		
		if(aRoot>bRoot)
			parents[aRoot] = bRoot;
		else
			parents[bRoot] = aRoot;
		
		return true;
	}
	private static int find(int x) {
		if(parents[x]==x)
			return x;
		return find(parents[x]);
	}
}
