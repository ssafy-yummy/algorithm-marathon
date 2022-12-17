package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2665_G4_미로만들기 {
	
	static int n;
	static int[][] map;
	static int[][] diff = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static class Node implements Comparable<Node>{
		
		int r;
		int c;
		int bCnt;
		public Node(int r, int c, int bCnt) {
			super();
			this.r = r;
			this.c = c;
			this.bCnt = bCnt;
		}
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", bCnt=" + bCnt + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.bCnt,o.bCnt);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {

			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = (Integer.parseInt(tmp[j])+1)%2;
			}
		}
		
		int res = bfs();
		System.out.println(res);
		
	}

	private static int bfs() {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0));
		boolean[][] visited = new boolean[n][n];
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			visited[cur.r][cur.c] = true;
			
			if(cur.r == n-1 && cur.c == n-1)
				return cur.bCnt;
			
			for (int[] d : diff) {
				int nr = cur.r + d[0];
				int nc = cur.c + d[1];
				
				if(!check(nr,nc))
					continue;
				
				if(visited[nr][nc])
					continue;
				
				pq.offer(new Node(nr,nc,cur.bCnt+map[nr][nc]));
			}
			
		}
		
		return 0;
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}

}
