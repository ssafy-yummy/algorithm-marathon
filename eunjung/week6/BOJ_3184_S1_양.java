package week6;

import java.io.*;
import java.util.*;

public class BOJ_3184_S1_양 {
	static int R,C,ocnt,vcnt;
	static int ototal,vtotal;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static ArrayList<Point> list = new ArrayList<>();
	// 좌표 위치 class
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
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o') { // 양이 위치했을 경우
					ototal++;
				}
				if(map[i][j]=='v') { // 늑대가 위치했을 경우
					list.add(new Point(i,j)); // 리스트에 따로 저장
					vtotal++;
				}
				if(map[i][j]=='#') {
					visited[i][j]=true; // 울타리일 경우 미리 방문처리
				}
			}
		}
		
		// 늑대의 위치를 저장한 리스트 탐색
		for (int i = 0; i < list.size(); i++) {
			ocnt = 0; vcnt = 0;
			bfs(i);
			if(ocnt > vcnt) {
				vtotal-=vcnt; // 영역에 양이 더 많을 경우
			}
			else ototal-=ocnt; // 영억에 늑대가 더 많을 경우
		}
		
		System.out.println(ototal+" "+vtotal); // 남은 양과 늑대의 수 출력
		
	}
	private static void bfs(int index) {
		Queue<Point> q = new LinkedList<>();
		q.add(list.get(index));
		
		while(!q.isEmpty()) {
			Point p = q.poll(); // 늑대의 위치
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d]; // 4방 탐색
				
				// 범위내에 있으면서 울타리가 아닌 경우
				if(check(nr,nc) && !visited[nr][nc]) {
					if(map[nr][nc]=='v') vcnt++;
					if(map[nr][nc]=='o') ocnt++;
					visited[nr][nc]=true; // 방문처리
					q.add(new Point(nr,nc));
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
}
