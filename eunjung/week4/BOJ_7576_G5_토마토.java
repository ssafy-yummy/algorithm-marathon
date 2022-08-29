package week4;

import java.io.*;
import java.util.*;

public class BOJ_7576_G5_토마토 {
	static int N,M,count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	static Queue<Point> q = new LinkedList<>();	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	} // 좌표 class 선언
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) q.add(new Point(i,j)); // 익은 토마토 좌표 큐에 삽입
			}
		}
		
		// 큐에 값이 존재할 경우, bfs 호출하고 날짜 count 증가
		while(!q.isEmpty()) {
			bfs();
			count++;
		}
		
		int flag = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					flag = 1;
					break;
				} // 토마토가 모두 익지 않은 상황일 경우, break
			}
		}
		if(flag == 1) System.out.println(-1); // 익지않은 토마토가 존재할때 -1 출력
		else System.out.println(count-1); // 아닌 경우 최소날짜 출력
	}
	private static void bfs() {
		int size = q.size(); // 날짜별로 토마토를 확산하기 위해

		for (int i = 0; i < size; i++) {
			Point p = q.poll(); // 큐에서 값을 꺼냄
			visited[p.r][p.c] = true; // 방문 표시
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]==0) {
					map[nr][nc] = 1; // 토마토를 익게 만든다
					q.offer(new Point(nr,nc)); // 확산된 좌표 큐에 넣음
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
}
