package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_G4_빙산 {
	
	static int N,M,map[][],map2[][],result;
	static boolean[][] visited;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		
		map = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j]= temp;
			}
		}// end of reading
		
		while(true) {
			map2= new int[N][M];
			boolean startChk= true;
			int startR= -1;
			int startC= -1;
			int sum =0;
			//1. 녹는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] !=0) {
						melt(i,j);
						if(startChk && (map[i][j]+map2[i][j]) !=0) {
							startR=i;
							startC=j;
							startChk= false;
						}
						sum +=(map[i][j]+map2[i][j]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] += map2[i][j];
				}
			}
			
			result ++;
			//다 녹아버렸다면
			if(sum==0) {
				result =0;
				break;
			}
			
			//2. 2조각이 됐는지 체크
			if(check(startR,startC,sum))break;
			
		}
		
		System.out.println(result);
		
	}
	private static boolean check(int r,int c,int sum) {
		int sum2=0;
		visited=new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {r,c});
		visited[r][c]=true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int rr =cur[0];
			int cc= cur[1];
			sum2 += map[rr][cc];
			if(sum2 == sum )return false;
			
			for (int i = 0; i < dr.length; i++) {
				int nr = rr + dr[i];
				int nc = cc + dc[i];
				if(nr >=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc] != 0) {
					que.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
			}
			
		}
		
		
		return true;
	}
	private static void melt(int r, int c) {
		for (int i = 0; i < dc.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] ==0)map2[r][c]--;
			}
		}
		if(Math.abs(map2[r][c])>map[r][c]) {
			map2[r][c] = -1*map[r][c];
		}
	}

}
