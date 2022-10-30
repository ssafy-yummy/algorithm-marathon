package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_D4_수영대회결승전 {
	
	static int T,N,map[][],result;
	static int[] start,end;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 T = Integer.parseInt(br.readLine());
		 
		 for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited=new boolean[N][N];
			result=0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st= new StringTokenizer(br.readLine());
			start =new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			st= new StringTokenizer(br.readLine());
			end =new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			bfs(start[0],start[1]);
			
			System.out.println("#"+testcase+" "+result);
		}
	}
	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		visited[r][c]=true;
		que.offer(new int[] {r,c,0,0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int rr= cur[0];
			int cc= cur[1];
			int dist = cur[2];
			int time= cur[3];
			
			if(rr==end[0] && cc==end[1]) {
				result=time;
				return;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = rr + dr[i];
				int nc = cc + dc[i];
				
				
				if(nr>=0 && nr<N && nc >=0 && nc<N && !visited[nr][nc]) {
					if(map[nr][nc]==1)continue;
					
					if((map[nr][nc]==0) || (map[nr][nc]==2 && time%3==2)) {
						que.offer(new int[] {nr,nc,dist+1,time+1});
						visited[nr][nc]=true;
					}else if(map[nr][nc]==2 && time%3!=2) {
						que.offer(new int[] {rr,cc,dist,time+1});
					}
				}
			}
		}
	
		result =-1;
	}

}
