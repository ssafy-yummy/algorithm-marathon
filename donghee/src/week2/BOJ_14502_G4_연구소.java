package week2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_G4_연구소 {
	static int R,C;
	static int[][] map;
	static int[][] temp;
	static boolean[][]visited;
	static int result= Integer.MIN_VALUE;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		map=new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}//end of reading
		
//		for(int[]m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		
		dfs(0,0);
		System.out.println(result);
		
	}
	private static void dfs( int start ,int cnt) {
		if(cnt==3) {
			int sum=0;
			//map복사
			temp= new int[R][C];
			visited= new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					temp[i][j]=map[i][j];
				}
			}
			
			virus(); //바이러스 퍼뜨리기
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(temp[i][j]==0)sum++;
				}
			}
			result= Math.max(result, sum);
			return;
		}
		
		for(int i=start; i<R*C; i++) {
			int dr= i /C;
			int dc= i %C;
			
			if(map[dr][dc] == 0) {
				
				map[dr][dc]=1;
				dfs(i+1,cnt+1);
				map[dr][dc]=0;
			}
			
		}
		
		
	}
	private static void virus() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(temp[i][j]==2 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
	}
	private static void bfs(int r, int c) {
		visited[r][c]=true;
		Queue<Point> que= new LinkedList<Point>();
		
		que.offer(new Point(r,c));
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for (int i = 0; i < dc.length; i++) {
				
				int nr= cur.x+dr[i];
				int nc= cur.y+dc[i];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
					if(temp[nr][nc] ==1 )continue;
					temp[nr][nc]=2;
					visited[nr][nc]=true;
					que.offer(new Point(nr,nc));
				}
			}
		}
	}

}
