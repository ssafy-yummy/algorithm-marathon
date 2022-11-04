package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {
	
	static int H,W,map[][],result;
	static boolean[][] visited ;
	static int[] dr = {0,1,0};
	static int[] dc = {1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int [H][W];
		visited= new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int cnt = H-1;
			for (int j = 0; j < temp; j++) {
				map[cnt--][i] = 1;
			}
		}//end of reading
		
		for(int[] m: map) {
			System.out.println(Arrays.toString(m));
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]==1 && j>=2 && map[i][j-1] !=1 &&!visited[i][j-1]) {
					start(i,j);
				}
			}
		}
		
		System.out.println(result);
		
	}
	private static void start(int r, int c) {
		//1. 왼쪽으로 가면서 있는지
		if(check(r,c)) {
			
			//2. 있으면 빗물 채우기
			rain(r,c-1);
		}
	}
	private static void rain(int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int [] {r,c});
		visited[r][c]=true;
		
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int rr = cur[0];
			int cc = cur[1];
			result ++;
			
			for (int i = 0; i < dr.length; i++) {
				int nr =rr +dr[i];
				int nc = cc +dc[i];
				
				if(nr>=0 && nr<H && nc>=0 && nc<W && !visited[nr][nc] && map[nr][nc] !=1) {
					que.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
			}
		}
		
	}
	private static boolean check(int r, int c) {
		for (int i = c-2; i >=0; i--) {
			if(map[r][i]==1)return true;
		}
		return false;
	}

}
