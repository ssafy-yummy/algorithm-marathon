package week1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3190_G4_뱀 {
	static int[][] map; //지도
	static boolean[][] snake; // 뱀 지도
	static int N,M,L;
	
	static int[] times;
	static int[] directions;
	
	static char status = 'R' ; //현재 방향
	
	static int[] dr= {0,1,0,-1}; // 우,하,좌,상
	static int[] dc= {1,0,-1,0};
	
	static Stack<Point> head; // 뱀 머리 좌표
	static Queue<Point> tail; // 뱀 꼬리 좌표
	
	static int result; // 출력할 결과물
	
	static boolean chk;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		N= Integer.parseInt(br.readLine());
		M= Integer.parseInt(br.readLine());
		
		head= new Stack<>();
		tail= new LinkedList<>();
		head.add(new Point(0,0));
		tail.add(new Point(0,0));
		
		map= new int[N][N];
		snake= new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			map[r-1][c-1]= 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char direction =  st.nextToken().charAt(0);
			move(time,direction);
			
		}
		
		move();
		
		
	}


	private static void move(int t, char d) {
		int temp = status=='R'? 0: status=='D'? 1: status=='L'? 2:status=='U'? 3:-1;
		snake[head.peek().x][head.peek().y]= true;
		snake[tail.peek().x][tail.peek().y]= true;
		
		while(true) {
			result ++; //시간 1초 추가
			int nr = head.peek().x+ dr[temp];
			int nc = head.peek().y+ dc[temp];
			
			if(nr >=0 && nr <N && nc >=0 && nc <N && !snake[nr][nc]) {
				snake[nr][nc]=true;
				head.add(new Point(nr,nc));
				tail.add(new Point(nr,nc));
				if(map[nr][nc]==0) {
					Point tmp = tail.poll();
					snake[tmp.x][tmp.y]=false;
				}else {
					map[nr][nc]=0;
				}
			}else {
				System.out.println(result);
				System.exit(0);
			}
			
			if(result==t)break;
		}
		
		//다 가고 머리 방향 바꾸기
		if(d=='L') {
			status= status=='R'? 'U': status=='D'? 'R': status=='L'? 'D' :status=='U'?'L':'0';     
		}else if(d=='D') {
			status= status=='R'? 'D': status=='D'? 'L': status=='L'? 'U' :status=='U'?'R':'0';     
		}
		
		
	}
	private static void move() {
		int temp = status=='R'? 0: status=='D'? 1: status=='L'? 2:status=='U'? 3:-1;
		snake[head.peek().x][head.peek().y]= true;
		snake[tail.peek().x][tail.peek().y]= true;
		
		while(true) {
			result ++; //시간 1초 추가
			int nr = head.peek().x+ dr[temp];
			int nc = head.peek().y+ dc[temp];
			
			if(nr >=0 && nr <N && nc >=0 && nc <N && !snake[nr][nc]) {
				snake[nr][nc]=true;
				head.add(new Point(nr,nc));
				tail.add(new Point(nr,nc));
				if(map[nr][nc]==0) {
					Point tmp = tail.poll();
					snake[tmp.x][tmp.y]=false;
				}else {
					map[nr][nc]=0;
				}
			}else {
				System.out.println(result);
				System.exit(0);
			}
			
		}
		
		
		
	}

}
