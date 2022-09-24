package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_모의_탈주범검거 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] visited = new boolean[n][m];
			Queue<Pos> queue = new LinkedList<>();
			queue.offer(new Pos(r,c));
			visited[r][c]=true;
			int[][] dirs = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}}; //터널 구조물 타입
			int[] dx = {-1,1,0,0}; //상하좌우
			int[] dy = {0,0,-1,1};
			int[] meet = {1,0,3,2}; //하상우좌
			for(int i=0;i<l;i++) { 
				int qs = queue.size();	//시간마다 이동하는 파이프를 관리하기 위함.
				for(int j=0;j<qs;j++) {
					Pos p = queue.poll();
					answer++; //이동 가능한 파이프
					int x = p.x;
					int y = p.y;
					int dir = map[x][y]; //d번 터널 구조 타입
					for(int d=0;d<dirs[dir].length;d++) {
						int nx = x+dx[dirs[dir][d]]; //다음 예상 이동 칸
						int ny = y+dy[dirs[dir][d]];
						
						if(nx<0 || nx>=n || ny<0 || ny>=m)
							continue;
						if(visited[nx][ny]==true)
							continue;
						if(map[nx][ny]==0)
							continue;
						boolean flag=false; 
						for(int k=0;k<dirs[map[nx][ny]].length;k++) {
							if(dirs[map[nx][ny]][k]==meet[dirs[dir][d]]) //나의 현재 파이프에서, 다음 파이프로 넘거가려면 연결이 되어있어햐한다.
								flag=true;
						}
						if(flag==false) //이미 지나간 곳은 다시 지나지 않는다.
							continue;
						
						visited[nx][ny]=true; 
						queue.offer(new Pos(nx,ny));
						
					}
				}		
			}			
			System.out.printf("#%d %d\n",tc,answer);
		}

	}

}
