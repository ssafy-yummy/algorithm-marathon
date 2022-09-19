package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {
	static class Pos{
		int x,y,d;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static Pos cur;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		cur = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {-1,0,1,0}; //북 동 남 서 
		int[] dy = {0,1,0,-1};
		int answer=0;
		loop1: while(true) {
			answer++; //현재 위치 청소함
			map[cur.x][cur.y]=2; //청소 완료 : 2
			//System.out.println(cur.x+ " "+cur.y);
			
			loop2 : while(true) {
				for(int d=0;d<4;d++) { //왼쪽 방향에 청소할 공간이 없다면 그 방향으로 회전하고 2번으로 돌아간다.
					int nx = cur.x+dx[(cur.d+3-d)%4]; //왼쪽 방향
					int ny = cur.y+dy[(cur.d+3-d)%4]; //왼쪽 방향
					if(map[nx][ny]==0) { //왼쪽방향에 아직 청소하지 않은 공간이 존재한다면
						cur.x = nx; //그 방향으로 회전한 다음 한 칸을 전진하고
						cur.y = ny;
						cur.d = (cur.d+3-d)%4;
						break loop2;//1번부터 진행
					}	
				}
				int nx = cur.x+dx[(cur.d+2)%4];
				int ny = cur.y+dy[(cur.d+2)%4];
				if(map[nx][ny]!=1) { //네 방향 모두 청소가 이미 되어있거나 벽인 경우
					cur.x=nx;//바라보는 방향을 유지한 채로 한칸 후진을 하고 2번으로 돌아간다. 
					cur.y=ny;
					continue;
				}
				//네 방향 모두 이미 청소가 되더있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우
				break loop1; //작동을 멈춘다.
			}
		}
		System.out.println(answer);
		
	}

}
