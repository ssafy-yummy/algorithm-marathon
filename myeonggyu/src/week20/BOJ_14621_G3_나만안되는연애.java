package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621_G3_나만안되는연애 {

	static class Path implements Comparable<Path>{
		
		int a;
		int b;
		int w;
		
		
		
		@Override
		public String toString() {
			return "Path [a=" + a + ", b=" + b + ", w=" + w + "]";
		}



		public Path() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Path(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}



		@Override
		public int compareTo(Path o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static int[] parent;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] gender = new int[n+1];
		for (int i = 0; i < n; i++) {
			String x = st.nextToken();
			gender[i+1] = x.equals("M") ? 1 : 0;
			
		}
		
		PriorityQueue<Path> pq = new PriorityQueue<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Path path = new Path(a,b,w);
			pq.offer(path);
		}
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			
			Path p = pq.poll();
			
			if(find(p.a) != find(p.b) && gender[p.a] != gender[p.b]) {
				
				union(p.a,p.b);
				ans += p.w;
				cnt++;
			}
			
		}
		
		if(cnt != n-1)
			ans = -1;
		System.out.println(ans);
		
	}

	private static void union(int a, int b) {
		
		a = find(a);
		b = find(b);

		parent[a] = Math.min(a, b);
		parent[b] = Math.min(a, b);
		
	}

	private static int find(int a) {
		while(parent[a] != a) {
			a = parent[a];
		}
		return a;
	}

}
