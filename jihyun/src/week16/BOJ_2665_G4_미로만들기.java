package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2665_G4_미로만들기 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int answer = -1;
	static List<Pos> list;
	static int[][] map;
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		boolean[][] visit = new boolean[n][n];
		visit[0][0]=true;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0,0));
		int[][] black = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				black[i][j]=Integer.MAX_VALUE;
			}
		}
		black[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			int x = p.x;
			int y = p.y;

			
			if(x==n-1 && y==n-1) {
				answer=black[n-1][n-1];
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				
				if(map[nx][ny]==0) { //검은방이면
					if(black[x][y]+1>=black[nx][ny])
						continue;
					
					black[nx][ny]=black[x][y]+1;
					queue.offer(new Pos(nx,ny));
				}
				else { //흰방이면
					if(black[x][y]>=black[nx][ny])
						continue;
					black[nx][ny]=black[x][y];
					queue.offer(new Pos(nx,ny));
				}

				
			}
		}	
		
		System.out.println(answer);

	}

}
