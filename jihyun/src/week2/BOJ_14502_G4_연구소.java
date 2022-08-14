package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_G4_연구소 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int n,m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Pos> virus;
	static int[][] arr;
	static int zero_count = 0;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					virus.add(new Pos(i,j)); //바이러스 좌표를 저장
				}
				if(arr[i][j]==0)
					zero_count++; //평범한 칸 개수 저장
			}
		}
		dfs(0,0);
		
		System.out.println(answer);
		
	}
	private static void dfs(int end, int start) {
		if(end==3) { //벽 3개를 생성 했을 경우
			bfs(); //바이러스 퍼트린다.
			return;
		}
		for(int k=start; k<n*m;k++) { //빈 벽 3개를 조합으로 구하는 과정
			int i = k/m;
			int j = k%m;
			if(arr[i][j]==0) {
				arr[i][j]=1;
				dfs(end+1,k+1);
				arr[i][j]=0;
			}
		}
	}
	private static void bfs() {
		int count=zero_count-3; //현재 안전지대 개수 count
		int[][] visit = new int[n][m];
		for(int i=0;i<virus.size();i++) { //모든 바이러스에 대하여
			Queue<Pos> queue = new LinkedList<>();
			queue.offer(virus.get(i));
			visit[virus.get(i).x][virus.get(i).y]=1;
			while(!queue.isEmpty()) { //바이러스 시작점을 기준으로 사방 탐색을 하며 퍼트린다.
				Pos p = queue.poll();
				for(int k=0;k<4;k++) {
					int nx = p.x+dx[k];
					int ny = p.y+dy[k];
					
					if(nx<0 || nx>=n || ny<0 || ny>=m)
						continue;
					
					if(visit[nx][ny]==0 && arr[nx][ny]==0) { //바이러스가 방문하지 않았던 지역이고, 평범한 칸이었다면
						visit[nx][ny]=1; //바이러스를 퍼트린다.
						queue.offer(new Pos(nx,ny));
						count--; //안전지대 개수 감소
						if(count<=answer) //안전지대가 현재 최대 안전지대 개수보다 작아지면 그 벽은 실패한 벽이다.
							return;	
					}
				}
			}
		}
		answer = count;
		
	}
}

