package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	
	static int n;
	static int[][] map;
	static int[][] diff = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static int total;
	
	static class Node{
		
		int r;
		int c;
		int d;
		int sums;
		HashSet<Integer> hash;
		
		public Node(int r, int c, int d, int sums, HashSet<Integer> set) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.sums = sums;
			this.hash = set;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + ", sums=" + sums + ", hash=" + hash + "]";
		}
		
		

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			
			total = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i==0) {
						if(j==0 || j== n-1)
							continue;
					}
					
					if(j==0) {
						if(i==0 || i == n-1)
							continue;
					}
					
					
//					System.out.println("i : "+ i + " j : " + j);
					bfs(i,j);
				}
			}
			if(total == 0)
				total = -1;
			System.out.println("#" + t + " " + total);
			
		}
	}

	private static void bfs(int i, int j) {

		Queue<Node> queue = new LinkedList<>();
		HashSet<Integer> s = new HashSet<>();
		s.add(map[i][j]);
		queue.offer(new Node(i,j,0,1,s));
		
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
//			System.out.println(node);
			
			
			a : for (int d = 0; d < 4; d++) {
				if(d==node.d){
					
					int nr = node.r + diff[d][0];
					int nc = node.c + diff[d][1];
					
					if(!check(nr,nc))
						continue;
					
					if(node.d == 3 && equals(new int[] {nr,nc},new int[] {i,j})) {
						total = Math.max(total, node.sums);
						continue a;
					}
					
					if(node.hash.contains(map[nr][nc]))
						continue;
					
					HashSet<Integer> tmp = new HashSet<>();
					for (Integer idx : node.hash) {
						tmp.add(idx);
					}
					tmp.add(map[nr][nc]);
					queue.offer(new Node(nr,nc,node.d,node.sums+1, tmp));
				}
				
				if(node.r == i && node.c == j)
					continue;
				
				else if(node.d+1 < 4 && d==node.d+1){
					int nr = node.r + diff[d][0];
					int nc = node.c + diff[d][1];
					
					if(!check(nr,nc))
						continue;
					
					if(node.d == 2 && equals(new int[] {nr,nc},new int[] {i,j})) {
						total = Math.max(total, node.sums);
						continue a;
					}

					if(node.hash.contains(map[nr][nc]))
						continue;
					
					HashSet<Integer> tmp = new HashSet<>();
					for (Integer idx : node.hash) {
						tmp.add(idx);
					}
					tmp.add(map[nr][nc]);
						
					queue.offer(new Node(nr,nc,node.d+1,node.sums+1, tmp));
				}
			}
		}
		
		
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}

	private static boolean equals(int[] is, int[] arr) {
		return is[0] == arr[0] && is[1] == arr[1];
	}
	
	

}
