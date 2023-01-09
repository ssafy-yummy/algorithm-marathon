package week13;

import java.io.*;
import java.util.*;

public class SWEA_4193_수영대회결승전 {
	static int N;
	static int min, time;
	static Point s,e;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int[][] map;
	static boolean isTrue;
	static boolean[][] visited;
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) visited[i][j] = true;
					if(map[i][j]==2) map[i][j] = 12; // 소용돌이일 경우
				}
			}
			s = new Point(0,0);
			e = new Point(0,0);
			st = new StringTokenizer(br.readLine());
			s.r = Integer.parseInt(st.nextToken());
			s.c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			e.r = Integer.parseInt(st.nextToken());
			e.c = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			time = 0;
			isTrue = false;
			
			swimming(s);
			if(isTrue) System.out.println("#"+t+" "+min);
			else System.out.println("#"+t+" "+(-1));
			
		}
	}
	
	private static void swimming(Point s) {
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		visited[s.r][s.c] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				
				if(p.r==e.r && p.c==e.c) {
					min = Math.min(min, time);
					isTrue = true;
					return;
				}
				// 동일한 시간동안 경로이동 해야함
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					
					if(check(nr,nc) && !visited[nr][nc]) {
						// 지나가려는 곳이 소용돌이 일 경우
						if(map[nr][nc]>10) {
							q.add(new Point(p.r,p.c));
						}
						// 일반일 경우
						else {
							q.add(new Point(nr,nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
			storm(); // 소용돌이는 매초마다 감소
			time++;
		}
	}

	private static void storm() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>10) map[i][j]--;
				else if(map[i][j]==10) map[i][j] = 12;
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
