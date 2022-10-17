package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_G4_빙산 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] copy = new int[n][m];
		int bingsanCount = 0;
		int answer = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0)
					bingsanCount++; //빙산 개수 
			}
		}

		loop:
		for (int k = 1;; k++) { //k일
			boolean flag = false;
			arrayCopy(copy,map,n,m);
			boolean[][] visit = new boolean[n][m];
			
			for (int i = 0; i < n; i++) { //행
				for (int j = 0; j < m; j++) { //열				
					if(map[i][j]!=0 && visit[i][j]==false) {
						if(flag==true) { //다른 덩어리를 발견하였다.
							answer = k-1;
							break loop;
						}
						flag = true; //빙산의 녹임이 시작되었다
						//copy에 대해서 bfs 시작
						visit[i][j]=true;
						Queue<Pos> queue = new LinkedList<>();
						queue.offer(new Pos(i,j));
						while(!queue.isEmpty()) {
							Pos p = queue.poll();
							int x = p.x;
							int y = p.y;
							
							for(int z=0;z<4;z++) {
								int nx = x + dx[z];
								int ny = y + dy[z];
								
								if(nx<0 || nx>= n || ny<0 || ny>=m)
									continue;
								if(map[nx][ny]==0) { //주변이 바다이면
									if(copy[x][y]>0)
										copy[x][y]--; //빙산의 면적을 줄인다
									continue;
								}
								if(visit[nx][ny]==true)
									continue;
								
								visit[nx][ny]=true;
								queue.offer(new Pos(nx,ny));

							}
						}
						
					}
				}
			}
			if(flag==false) //빙산도 발견하지 못했다. 즉, 빙산이 전부 녹았다.
				break;
			arrayCopy(map,copy,n,m);
		}
		
		System.out.println(answer);

	}

	private static void arrayCopy(int[][] arr1, int[][] arr2, int n, int m) {
		for (int i = 0; i < n; i++) { //행
			for (int j = 0; j < m; j++) { //열
				arr1[i][j]=arr2[i][j];
			}
		}
		
	}

}
