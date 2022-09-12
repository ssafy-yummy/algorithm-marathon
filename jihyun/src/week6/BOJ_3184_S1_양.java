package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_S1_양 {
	static class Pos {
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int oResult=0;
		int vResult=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!='#') { //울타리가 아닐때
					Queue<Pos> queue = new LinkedList<>();
					queue.offer(new Pos(i,j));
					int oCount=0; //양의 마리수
					int vCount=0; //늑대의 마리수
					if(map[i][j]=='o')
						oCount++; //양의 마리수 증가
					else if(map[i][j]=='v')
						vCount++; //늑대의 마리수 증가
					map[i][j]='#'; //공간 방문 처리
					
					while(!queue.isEmpty()) {
						Pos p = queue.poll();
						int x = p.x;
						int y = p.y;
						for(int d=0;d<4;d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							
							if(nx<0 || nx>=n || ny<0 || ny>=m)
								continue;
							
							if(map[nx][ny]=='#') //울타리면 무시
								continue;
							
							if(map[nx][ny]=='o') //양이면 양의 마리수 증가
								oCount++;
							else if(map[nx][ny]=='v') //늑대면 늑대의 마리수 증가
								vCount++;
							
							queue.offer(new Pos(nx,ny));
							map[nx][ny]='#'; //공간 방문 처리 
						}
					}
					//울타리 내의 모든 양과 늑대의 수를 셌다.
					//양이 더 많다면 양의 마리수를 결과값에 추가하고, 늑대가 더 많다면 늑대의 마리수를 결과값에 추가한다.
					if(oCount>vCount)
						oResult+=oCount;
					else
						vResult+=vCount;
				}
			}
		}
		System.out.println(oResult + " " + vResult);

	}

}
