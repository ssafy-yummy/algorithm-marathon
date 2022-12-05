package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21924_G4_도시건설 {

	static int n;
	static int m;
	static PriorityQueue<Path> pq;
	static int[] finds;
	
	static class Path implements Comparable<Path>{
		
		int a;
		int b;
		int w;
		public Path(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
		public Path() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Path [a=" + a + ", b=" + b + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Path o) {
			return Integer.compare(this.w, o.w);
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		long total = 0;
		
		Path[] paths = new Path[m];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			total += w;
			paths[i] = new Path(a,b,w);
		}
		
		
		Arrays.sort(paths);
		finds = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			finds[i] = i;
		}

		int cnt = 1;
		long sums = 0;
		
		for (int i = 0; i < m; i++) {
			
			Path p = paths[i];
			
			if(find(p.a,p.b))
				continue;
			
			
			union(p.a,p.b);
			
			sums += p.w;
			cnt++;
			
		}
		
		
		if(cnt != n)
			System.out.println(-1);
		else
			System.out.println(total-sums);
		
		
		
	}

	private static void union(int a, int b) {

		while(finds[a] != a){
			a = finds[a];
		}
		
		while(finds[b] != b) {
			b = finds[b];
		}

		finds[a] = Math.min(a, b);
		finds[b] = Math.min(a, b);
		
	}

	private static boolean find(int a, int b) {
		while(finds[a] != a){
			a = finds[a];
		}
		
		while(finds[b] != b) {
			b = finds[b];
		}
		
		return a==b;
	}

}
