package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_S1_경비원 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] dir = {{},{0,0},{n,0},{0,0},{0,m}}; //북남(y좌표 +), 서동(x좌표 +)
		int shop = Integer.parseInt(br.readLine());
		Pos[] shops = new Pos[shop];
		for(int i=0;i<shop;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); //방향
			int l = Integer.parseInt(st.nextToken()); //거리
			shops[i] = new Pos(dir[d][0]+(d>2?l:0),dir[d][1]+(d<=2?l:0)); //좌표 설정
		}		
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken()); //방향
		int l = Integer.parseInt(st.nextToken()); //거리
		Pos me = new Pos(dir[d][0]+(d>2?l:0),dir[d][1]+(d<=2?l:0));
		
		int answer = 0;
		for(int i=0;i<shop;i++) { //나  <-> 각 상점들에 대해 
			int dis;
			if(Math.abs(shops[i].x-me.x)==n || Math.abs(shops[i].y-me.y)==m) { //서로 반대편에 있으면
				dis = shops[i].x + me.x + shops[i].y + me.y;
			}
			else { //서로 반대편에 있지 않으면
				dis = Math.abs(shops[i].x-me.x) + Math.abs(shops[i].y-me.y);
			}
			
			answer+=Math.min(dis, 2*(n+m)-dis); //시계방향과 반시계방향 거리 비교
		}
		System.out.println(answer);
	}

}