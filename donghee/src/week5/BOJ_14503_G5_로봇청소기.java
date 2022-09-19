package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {
	static class Robot{
		int r;
		int c;
		int direct;
		public Robot(int r, int c, int direct) {
			super();
			this.r = r;
			this.c = c;
			this.direct = direct;
		}
		
	}
	
	static int N,M, map[][],result;
	static int[] dr= {0,1,0,-1}; //서 남 동 북
	static int[] dc= {-1,0,1,0};
	static Robot rb;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visited=new boolean[N][M];
		
		st= new StringTokenizer(br.readLine());
		
		rb= new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}//end of reading
		result=1;
		visited[rb.r][rb.c]=true;
		start();
		System.out.println(result);
	}
	private static void start() {
		while(true) {
			boolean chk= true;
			int start= dc.length-rb.direct;
			
			for (int i = start; i < start+4; i++) {
				int nr= rb.r + dr[i%4];
				int nc= rb.c + dc[i%4];
				
				
				//청소자리 있으면 가고 방향 바꾸고 result증가 후 다시 시작
				if(nr>=0 && nr <N && nc>=0 && nc <M ) {
					if(!visited[nr][nc] && map[nr][nc] !=1) {
						rb.r=nr;
						rb.c=nc;
						visited[nr][nc]=true;
						rb.direct=3- i%4;
						result++;
						chk=false;
						break;
					}
				}
			}
			
			//다 돌았는데 갈 데 없음(후진)
			if(chk) {
				int br = rb.r + dr[(start+1)%4];
				int bc = rb.c + dc[(start+1)%4];
				if(map[br][bc] != 1) {
					rb.r= br;
					rb.c= bc;
				}else {
					return;
				}
			}
		}
	}
}
