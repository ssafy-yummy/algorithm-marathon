package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15685_G4_드래곤커브 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int[] dx = {0,-1,0,1}; //우상좌하
		int[] dy = {1,0,-1,0};
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken()); //시작점
			int x = Integer.parseInt(st.nextToken()); //시작점
			int d = Integer.parseInt(st.nextToken()); //시작방향
			int g = Integer.parseInt(st.nextToken()); //세대
			
			int[] dirs = new int[1<<g]; //g세대까지 진화하면 길이가 얼마인가
			dirs[0]=d; //출발지 방향
			map[x][y]=1; //출발지 지나간 곳
			for(int j=0;j<g;j++) { //0세대 -> g세대
				for(int k=0;k<(1<<j);k++) { //이전 세대 기준으로
					dirs[(1<<(j+1))-1-k] = (dirs[k]+1)%4; //이전 세대의 그 다음 방향 값을 다음 세대에 물려준다. ex)우상좌상/좌하좌상 0->7 1->6, 2->5, 3->4
				}
			}
			for(int j=0;j<dirs.length;j++) { //저장해놓은 방향 값을 이용하여
				x += dx[dirs[j]];
				y += dy[dirs[j]];
				
				map[x][y]=1; //출발지로부터 1를 그려간다.
			}
		}
		int answer = 0;
		for(int i=0;i<100;i++) { //100x100 지도에서
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) {
					boolean flag = true;
					loop : for(int ii=0;ii<2;ii++) { //2x2 모든 칸이 1인가 확인한다.
						for(int jj=0;jj<2;jj++) {
							if(map[i+ii][j+jj]!=1) {
								flag=false;
								break loop;
							}
						}
					}
					if(flag==true) //정사각형(모든 칸이 1이면) 정답 +1
						answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
