package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_G5_토마토2 {
	
	static int M,N,box[][],result,fullcnt,sum;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static Queue<int[]> que;
	static boolean[][] visited;
	static boolean endchk=true;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		M= Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		visited=new boolean[N][M];
		que = new LinkedList<int[]>();
		fullcnt = M*N;
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j]= tmp;
				if(tmp==1) {
					que.offer(new int[] {i,j,0});
					visited[i][j]=true;
					sum++;
				}else if (tmp==-1) {
					fullcnt--;
				}else {
					endchk=false;
				}
			}
		}//end of reading
		
		if(endchk) {
			System.out.println(0);
		}else {
			start();
			if(fullcnt == sum) {
				System.out.println(result);
			}else {
				System.out.println(-1);
			}
		}
		
		
	}
	private static void start() {
		
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r= cur[0];
			int c= cur[1];
			int days= cur[2];
			result = Math.max(result, days);
			
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr>=0 && nr < N && nc>=0 && nc<M && !visited[nr][nc] && box[nr][nc] ==0) {
					visited[nr][nc]=true;
					que.offer(new int[] {nr,nc,days+1});
					sum++;
				}
			}
		}
	}
	

}
