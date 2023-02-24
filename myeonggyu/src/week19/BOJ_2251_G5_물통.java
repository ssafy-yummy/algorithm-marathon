package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_G5_물통 {

	
	static class Bucket{
		
		int a;
		int b;
		int c;
		public Bucket(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public Bucket() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Bucket [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
		
		
		
		
	}
	
	static int a;
	static int b;
	static int c;
	static HashSet<Integer> hash;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		hash = new HashSet<>();
		
		bfs();
		int[] res = new int[hash.size()];
		int idx = 0;
		for (Integer i : hash) {
			res[idx++] = i;
		}
		
		Arrays.sort(res);
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
		
		
		
		
	}

	private static void bfs() {
		
		Queue<Bucket> queue = new LinkedList<>();
		queue.offer(new Bucket(0,0,c));
		boolean[][][] visited = new boolean[201][201][201];
		visited[0][0][c] = true;
		
		while(!queue.isEmpty()) {
			
			Bucket cur = queue.poll();
			
			if(cur.a == 0) {
				if(hash.contains(cur.c))
					continue;
				
				hash.add(cur.c);
			}
			
			//a물을 쏟아
			if(cur.a != 0) {
				
				//b가 꽉차있지 않으면
				if(cur.b != b) {
					int diff = Math.min(cur.a,b-cur.b);
					
					if(!visited[cur.a-diff][cur.b+diff][cur.c]) {
					
						queue.offer(new Bucket(cur.a-diff, cur.b+diff,cur.c));
						visited[cur.a-diff][cur.b+diff][cur.c] = true;
					}
				}
				//c가 꽉차있지 않으면
				if(cur.c != c) {
					int diff = Math.min(cur.a,c-cur.c);
					
					if(!visited[cur.a-diff][cur.b][cur.c+diff]) {
					
						queue.offer(new Bucket(cur.a-diff, cur.b,cur.c+diff));
						visited[cur.a-diff][cur.b][cur.c+diff] = true;
					}
				}
				
			}
			
			//b물을 쏟아
			if(cur.b != 0) {
				
				//a가 꽉차있지 않으면
				if(cur.a != a) {
					int diff = Math.min(cur.b,a-cur.a);

					if(!visited[cur.a+diff][cur.b-diff][cur.c]) {
					
						queue.offer(new Bucket(cur.a+diff, cur.b-diff,cur.c));
						visited[cur.a+diff][cur.b-diff][cur.c] = true;
					}
				}
				//c가 꽉차있지 않으면
				if(cur.c != c) {
					int diff = Math.min(cur.b,c-cur.c);

					if(!visited[cur.a][cur.b-diff][cur.c+diff]) {
					
						queue.offer(new Bucket(cur.a, cur.b-diff,cur.c+diff));
						visited[cur.a][cur.b-diff][cur.c+diff] = true;
					}
				}
				
			}
			
			//c물을 쏟아
			if(cur.c != 0) {
				
				//b가 꽉차있지 않으면
				if(cur.b != b) {
					int diff = Math.min(cur.c,b-cur.b);
					
					if(!visited[cur.a][cur.b+diff][cur.c-diff]) {
					
						queue.offer(new Bucket(cur.a, cur.b+diff,cur.c-diff));
						visited[cur.a][cur.b+diff][cur.c-diff] = true;
					}
				}
				//a가 꽉차있지 않으면
				if(cur.a != a) {
					int diff = Math.min(cur.c,a-cur.a);

					if(!visited[cur.a+diff][cur.b][cur.c-diff]) {
					
						queue.offer(new Bucket(cur.a+diff, cur.b,cur.c-diff));
						visited[cur.a+diff][cur.b][cur.c-diff] = true;
					}
				}
				
			}
			
		}
		
	}

}
