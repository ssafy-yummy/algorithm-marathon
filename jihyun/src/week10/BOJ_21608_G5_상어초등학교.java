package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_G5_상어초등학교 {
	static class Pos implements Comparable<Pos>{
		int x,y,lc,ec;

		public Pos(int x, int y, int lc, int ec) {
			super();
			this.x = x;
			this.y = y;
			this.lc = lc;
			this.ec = ec;
		}

		@Override
		public int compareTo(Pos o) {
			if(this.lc!=o.lc)
				return -(this.lc-o.lc); //1. 주변에 좋아하는 학생수가 가장 많다
			if(this.ec!=o.ec)
				return -(this.ec-o.ec); //2. 주변에 빈 공간이 많다
			if(this.x!=o.x)
				return this.x-o.x; //3. 가장 작은 행이다
			return this.y-o.y; //4. 가장 작은 열이다
		}	
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //n은 3이상 20이하
		int[][] map = new int[n][n]; //칸에 몇번 학생이 있는가
		int answer = 0; //만족도
		PriorityQueue<Pos> pqueue = new PriorityQueue<>(); //가능한 자리들
		int[][] students = new int[n*n+1][4]; //각 학생들이 좋아하는 학생들
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int[] score = {0,1,10,100,1000};
		
		for(int k=0;k<n*n;k++) { //학생수는 9이상 400이하
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int me = Integer.parseInt(st.nextToken());
			students[me][0] = Integer.parseInt(st.nextToken());
			students[me][1] = Integer.parseInt(st.nextToken());
			students[me][2] = Integer.parseInt(st.nextToken());
			students[me][3] = Integer.parseInt(st.nextToken());
			
			//가능한 모든 자리들을 pqueue에 넣기
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]!=0) //이미 다른 학생이 앉음
						continue;
					int lc=0;
					int ec=0;
					for(int s=0;s<4;s++) { //사방에 대해서
						int nx = i+dx[s];
						int ny = j+dy[s];
						
						if(nx<0 || nx>=n || ny<0 || ny>=n) //벗어나면 out
							continue;
						
						for(int p=0;p<4;p++) { 
							if(map[nx][ny]==students[me][p]) //내가 좋아하는 학생이 있다면
								lc++;
						}
						if(map[nx][ny]==0) //빈 자리가 있다면
							ec++;
					}
					pqueue.offer(new Pos(i,j,lc,ec)); //큐에 추가
				}
			}
			Pos p = pqueue.peek(); //가장 적합한 자리를 찾는다
			map[p.x][p.y]=me; //학생을 배치한다
			pqueue.clear(); //큐 초기화
		}
		
		//만족도 조사
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int sum = 0; //?번 학생에 대해서
				for(int s=0;s<4;s++) { //사방으로
					int nx = i+dx[s];
					int ny = j+dy[s];
					
					if(nx<0 || nx>=n || ny<0 || ny>=n) //벗어나면 out
						continue;
					
					for(int p=0;p<4;p++) {
						if(map[nx][ny]==students[map[i][j]][p]) //좋아하는 학생이 있다면
							sum++;
					}
				}
				answer+=score[sum]; //좋아하는 학생수에 대한 점수를 매김
			}
		}
		System.out.println(answer);
	}
}

/*
1) 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
2) 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
3) 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 
그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
*/