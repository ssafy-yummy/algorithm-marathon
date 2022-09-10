package boj;
import java.io.*;
import java.util.*;

public class BOJ_14503_G5_로봇청소기 {
	static int N, M, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Point {
		int r, c, dir;
		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M]; // 청소를 했거나 벽을 담아줄 visited
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()); // 로봇 청소기가 있는 칸의 좌표
		int dir = Integer.parseInt(st.nextToken()); // 방향
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					visited[i][j] = true;
				} // 벽일 경우 방문처리
			}
		}
		
		Point rt = new Point(r,c,dir);
		cleaning(rt);
	}

	private static void cleaning(Point p) {
		while (true) {
			if (!visited[p.r][p.c]) {
				visited[p.r][p.c] = true; // 청소가 안되어 있다면 청소
				count++; // 청소한 칸의 개수 ++
			}
			
			int k = 0;
			
			while (k < 4) {
				p.dir--;
				if (p.dir < 0) {
					p.dir = 3; // 북쪽에서 회전할 경우는 서쪽으로
				}
				int nr = p.r + dr[p.dir];
				int nc = p.c + dc[p.dir];
               
				if (!visited[nr][nc]) {
					p.r = nr; p.c = nc; // 왼쪽방향이 청소가 안돼있으면 이동
					break;
				}
				k++; // 청소가 되어있으면 회전
				
                // 사방이 청소가 되었을 경우
				if (k == 4) {
					// 후진했는데 벽일 경우 종료
					if (map[p.r - dr[p.dir]][p.c - dc[p.dir]] == 1) {
						System.out.println(count); // 청소한 칸의 개수 출력
						System.exit(0);
					}
					// 벽이 아닐 경우 후진
					else {
						p.r = p.r - dr[p.dir];
						p.c = p.c - dc[p.dir];
						break;
					}
				}
			}
		}
	}
}
