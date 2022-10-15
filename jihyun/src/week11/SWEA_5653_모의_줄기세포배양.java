package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_모의_줄기세포배양 {
	static class Pos {
		int x,y,z;

		public Pos(int x, int y, int z) {
			super();
			this.x = x; //x좌표
			this.y = y; //y좌표
			this.z = z; //현재 상태
		}

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); //세로
			int m = Integer.parseInt(st.nextToken()); //가로
			int k = Integer.parseInt(st.nextToken()); //배양 시간
			int[][] map = new int[650][650]; //줄기세포  퍼져있는 맵 
			int[][] time = new int[650][650]; //줄기세포 생성 시간
			Queue<Pos> hqueue = new LinkedList<>();
			Queue<Pos> bqueue = new LinkedList<>();
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			
			for(int i=0;i<650;i++) {
				for(int j=0;j<650;j++) {
					time[i][j]=-1;
				}
			}
			for(int i=300;i<n+300;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=300;j<m+300;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) { //세포 존재
						bqueue.offer(new Pos(i, j, map[i][j]));
						time[i][j]=0;
					}
				}
			} //입력끝
			for(int t=1;t<=k;t++) {
				Queue<Pos> tqueue = new LinkedList<>();
				int hqueueSize = hqueue.size();
				for(int i=0;i<hqueueSize;i++) { //활성 상태 처리
					Pos p = hqueue.poll();
					int x = p.x;
					int y = p.y;
					if(p.z==map[x][y]) { //첫 한시간일때
						for(int d=0;d<4;d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							
							if(time[nx][ny]==-1) { //빈 셀 
								time[nx][ny]=t;
								tqueue.offer(new Pos(nx,ny));
							}
							
							if(time[nx][ny]!=t) 
								continue;
													
							map[nx][ny]=Math.max(map[nx][ny], map[x][y]);
						}
					}
					p.z--; //활성 세포의 수명 줄이기
					if(p.z!=0) { //활성 세포의 수명이 남아 있다면 큐에 추가
						hqueue.offer(p);
					}

					
				}
				int bqueueSize = bqueue.size();
				for(int i=0;i<bqueueSize;i++) { //비활성 상태 처리
					Pos p = bqueue.poll();
					int x = p.x;
					int y = p.y;
					p.z--; //활성상태까지 필요한 시간 줄이기
					if(p.z==0) { //이제 활성화가 가능하면
						p.z = map[x][y];
						hqueue.offer(p); //활성화 큐로 옮기기
					}
					else {
						bqueue.offer(p); //비활성화 큐에 유지하기
					}
				}
				
				while(!tqueue.isEmpty()) {
					Pos p = tqueue.poll();
					int x = p.x;
					int y = p.y;
					bqueue.offer(new Pos(x,y,map[x][y]));
				}
				//System.out.println(hqueue.size()+" "+bqueue.size());
			}
			
			
			int answer = hqueue.size()+bqueue.size();
			System.out.printf("#%d %d\n", tc, answer);
		}

	}

}
