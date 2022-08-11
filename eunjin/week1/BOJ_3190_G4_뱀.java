package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3190_G4_뱀 {

	static int N, K, L, X;
	static char C;
	static int[][] map;
	static int appr, appc;	// 사과 위치 저장
	
	static int time;
	static int[][] dd = {{0,1},{1,0},{0,-1},{-1,0}};  // 우,하,좌,상
	static int d, dr, dc;
	static int r, c;  // 뱀 머리 위치 저장
	
	static boolean fin;	// 종료 조건
	
	static class Snake {	// 뱀 머리+몸통 위치 저장
		int rr;
		int cc;
		public Snake(int rr, int cc) {
			super();
			this.rr = rr;
			this.cc = cc;
		}
	}
	static Queue<Snake> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		K = sc.nextInt();
		for(int i=0; i<K; i++) {
			appr = sc.nextInt();
			appc = sc.nextInt();
			map[appr][appc] = 2;	// map 0:평지, 1:뱀, 2:사과
		}
		
		//time = 0; fin = false; d = 0;
		r = 1; c = 1;
		dr=dd[d][0]; dc=dd[d][1];
		que = new LinkedList<Snake>();
		que.offer(new Snake(r,c));
		
		L = sc.nextInt();
		for(int i=0; i<L; i++) {
			if(fin) break;
			X = sc.nextInt();
			C = sc.next().charAt(0);
			for(int j=time; j<X; j++) {	// time 변수는 go가 실행할 때마다 증가
				go(X, C);
				if(fin) break;
			}
		}
		while(!fin)
			go(0,'0');	// 인풋데이터가 없어도 뱀은 매초 움직인다(벽이든 몸이든 부딪힐 때까지)
		
		System.out.println(time);
	}
	private static void go(int t, char ch) {
		time++;
		
		// 앞으로 전진
		r+=dr;
		c+=dc;
		
		// 머리가 만약 map 밖이라면 종료!
		if( r<1 || r>N || c<1 || c>N ) {
			fin = true;
			return;
		}
		
		// 지나온 길을 지울지 말지
		que.offer(new Snake(r,c));
		if(map[r][c]==0) {	// 평지라면 뱀의 꼬리를 지운다
			Snake sn = que.poll();
			map[sn.rr][sn.cc] = 0;	// map에 뱀의 흔적을 지운다
		}	// 사과가 있다면 (map[r][c]==2) 꼬리를 지우지 않는다.
		
		// 뱀의 머리가 뱀의 몸에 부딪혔다면 종료!
		if(map[r][c]==1) {	// 뱀의 몸이라면 종료!
			fin = true;
			return;
		}
		
		map[r][c] = 1;	// 여기서 map에 뱀의 흔적을 표시한다
		
		// 방향을 전환할지 말지
		if(time==t) {
			if(ch=='L')
				d=(d+3)%4;
			else if(ch=='D')
				d=(d+1)%4;
			dr = dd[d][0];
			dc = dd[d][1];
		}
		return;
	}

}
