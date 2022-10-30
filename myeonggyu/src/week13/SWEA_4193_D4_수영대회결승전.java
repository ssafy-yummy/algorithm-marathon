package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_D4_수영대회결승전 {

	static int n;
	static int[][] map;
	static int[] s;
	static int[] e;
	static int[][] diff = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			s = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

			st = new StringTokenizer(br.readLine());
			e = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			
			System.out.println("#" + t + " " + bfs());
		}

	}

	private static int bfs() {

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		queue.offer(new int[] {s[0],s[1],0});
		map[s[0]][s[1]] = -1;
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
//			System.out.println(Arrays.toString(cur));
			
			for (int[] d : diff) {
				
				int nr = cur[0] + d[0];
				int nc = cur[1] + d[1];
				
				if(!check(nr,nc))
					continue;
				
				if(map[nr][nc] == -1)
					continue;
				
				if(map[nr][nc] == 1)
					continue;
				
				if(nr == e[0] && nc == e[1])
					return cur[2]+1;
				
				
				if(map[nr][nc] == 2) {
					queue.offer(new int[] {nr,nc,cur[2]+3-(cur[2]%3)});
					continue;
				}
				queue.offer(new int[] {nr,nc,cur[2]+1});
				map[nr][nc] = -1;
				
			}
			
		}
		
		return -1;
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}
	
}

