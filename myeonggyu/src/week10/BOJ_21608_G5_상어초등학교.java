package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21608_G5_상어초등학교 {
	
	
	static int n;
	static HashMap<Integer, int[]> hash;
	static Position[][] map;
	static int[][] diff = {{0,1},{1,0},{-1,0},{0,-1}};
	
	static class Position implements Comparable<Position>{
		
		int f;
		int e;
		int r;
		int c;
		int v;
		
		public Position(int f, int e, int r, int c, int v) {
			super();
			this.f = f;
			this.e = e;
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
		
		

		@Override
		public String toString() {
			return "Position [f=" + f + ", e=" + e + ", r=" + r + ", c=" + c + ", v=" + v + "]";
		}





		@Override
		public int compareTo(Position o) {
						
			if(o.v != 0 && this.v == 0)
				return -1;
			
			if(this.v != 0 && o.v == 0)
				return 1;
			
			if(this.f == o.f) {
				
				if(this.e == o.e) {
					
					if(this.r == o.r) {
						return Integer.compare(this.c, o.c);
						
					}
					
					return Integer.compare(this.r, o.r);
					
				}
				
				return Integer.compare(o.e, this.e);
				
			}
			
			return Integer.compare(o.f, this.f);
			
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new Position[n][n];
		hash = new HashMap<>();
		int sums = 0;

		PriorityQueue<Position> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				int e = 0;
				for (int[] d: diff) {
					int nr = i+d[0];
					int nc = j+d[1];
					
					if(!check(nr,nc))
						continue;
					e++;
				}
				
				
				map[i][j] = new Position(0,e,i,j,0);
				queue.offer(map[i][j]);
			}
		}
		

		
		
		
		
		for (int q = 0; q < n*n; q++) {			
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			hash.put(k, new int[] {a,b,c,d});
			
			
			
			//선호도 갱신			
			for (Position p : queue) {
				

				int f = 0;
				for (int[] dd : diff) {
					int nr = p.r + dd[0];
					int nc = p.c + dd[1];
					
					if(!check(nr,nc))
						continue;
					
					int x = map[nr][nc].v;
					if(x == a || x== b || x == c || x == d) {
							f++;
					}
				}
				map[p.r][p.c].f = f;				
			}
			PriorityQueue<Position> nqueue = new PriorityQueue<>();
			for (Position po : queue) {
				nqueue.add(po);
			}
			
			Position p = nqueue.poll();
			map[p.r][p.c].v = k;
			for (int[] dd : diff) {
				int nr = p.r+dd[0];
				int nc = p.c+dd[1];
				
				if(!check(nr,nc))
					continue;
				
				map[nr][nc].e--;
			}
			
			nqueue = new PriorityQueue<>();
			for (Position po : queue) {
				nqueue.add(po);
			}
			
			queue = nqueue;

		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Position p = map[i][j];
				
				int f = 0;
				for (int[] d : diff) {
					int nr = p.r+d[0];
					int nc = p.c+d[1];
					
					if(!check(nr,nc))
						continue;
					
					for (int x : hash.get(p.v)) {
						if(x == map[nr][nc].v)
							f++;
					}
				}
				
				sums += Math.pow(10, f-1);
			}
		}
		
		System.out.println(sums);
		
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}

}
