package week9;

import java.io.*;
import java.util.*;

public class BOJ_16234_G5_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static ArrayList<Point> l;
	
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
					// 방문하지 않았을 경우
					if(!visited[i][j]) {
						int total = bfs(i, j);
						if(l.size() > 1) {
							int avg = total / l.size(); // 총 합을 리스트 저장 개수로 나누어 평균 구함
							for(Point p : l) {
								map[p.x][p.y] = avg; // 리스트에 저장된 위치들의 값을 avg로 변경
							}
							canMove = true;
						}
					}
				}
			}
			// 인구이동이 발생하지 않을 경우
			if(!canMove) {
				System.out.println(count);
				System.exit(0);
			}
			// 발생했을 경우
			count++; // 이동 수 증가 
		}
	}
	private static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		l = new ArrayList<>();
		q.offer(new Point(x, y));
		
		l.add(new Point(x, y));
		visited[x][y] = true; // 방문 처리
		
		int total = map[x][y];
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i]; // 4방탐색
				
				// 범위 내면서 방문 안했을 경우
				if(check(nx,ny) && !visited[nx][ny]) {
					int dif = Math.abs(map[p.x][p.y] - map[nx][ny]); // 절댓값 차 구하기
					// 두 수의 차가 L과 R의 사이일 경우
					if(L <= dif && dif <= R) {
						q.offer(new Point(nx, ny));
						l.add(new Point(nx, ny));
						total += map[nx][ny]; // total에 더해줌
						visited[nx][ny] = true;
					}
				}
			}
		}
		return total; // total 값 리턴
	}
	
	private static boolean check(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}
	
}