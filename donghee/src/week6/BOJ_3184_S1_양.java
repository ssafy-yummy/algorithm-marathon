package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_S1_양 {
	
	static int R,C, sheep,wolf;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited=new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]= tmp[j];
			}
		}//read of reading
		
//		for(char[] m: map) {
//			System.out.println(Arrays.toString(m));
//		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					int[] results = start(i,j);
					sheep += results[0];
					wolf += results[1];
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
		
	}
	private static int[] start(int r, int c) {
		Queue<int[]>que =new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		visited[r][c]= true;
		int s=0;
		int w=0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int rr = cur[0];
			int cc = cur[1];
			
			if(map[rr][cc]=='v')w++;
			else if(map[rr][cc]=='o')s++;
			
			for (int i = 0; i < dr.length; i++) {
				int nr = rr+dr[i];
				int nc = cc+dc[i];
				
				if(nr>=0 && nr <R && nc>=0 && nc<C && !visited[nr][nc] && map[nr][nc]!='#' ) {
					visited[nr][nc]=true;
					que.offer(new int[] {nr,nc});
				}
			}
		}
		
		if(s>w) {
			w=0;
		}else {
			s=0;
		}
		
		return new int[] {s,w};
	}

}
