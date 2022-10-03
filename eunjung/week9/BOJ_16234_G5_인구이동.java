package week9;

import java.io.*;
import java.util.*;

public class BOJ_16234_G5_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static ArrayList<Point> l = new ArrayList<>();
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
		
	}
	
	private static int move() {
		int count = 0;
		
		while(true) {
			visited = new boolean[N][N];
			boolean canMove = false;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						int total = bfs(i, j);
						if(l.size() > 1) {
							int avg = total / l.size();
							for(Point p : l) {
								map[p.x][p.y] = avg;
							}
							canMove = true;
						}
					}
				}
			}
			if(!canMove) {
				return count;
			}
			count++;
		}
	}
	private static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		
		l.add(new Point(x, y));
		visited[x][y] = true;
		
		int total = map[x][y];
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visited[nx][ny]) {
					int difference = Math.abs(map[p.x][p.y] - map[nx][ny]);
					if(L <= difference && difference <= R) {
						q.offer(new Point(nx, ny));
						l.add(new Point(nx, ny));
						total += map[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return total;
	}

}