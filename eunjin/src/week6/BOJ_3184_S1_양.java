package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_S1_양 {

	static int R, C;
	static char map[][];
	static boolean visited[][];
	static int sheep, fox;
	static int dd[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			char[] ch = s.toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
			}
		} //read

		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!='#' && !visited[i][j])
					find(i,j);
			}
		}
		
		System.out.println(sheep+" "+fox);
	}

	private static void find(int row, int col) {
		int cnt_s = 0;
		int cnt_f = 0;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {row, col});
		visited[row][col]=true;
		if(map[row][col]=='o')
			cnt_s++;
		else if(map[row][col]=='v')
			cnt_f++;
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = arr[0]+dd[d][0];
				int nc = arr[1]+dd[d][1];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]=='#' || visited[nr][nc]) continue;
				visited[nr][nc]=true;
				que.offer(new int[] {nr,nc});
				if(map[nr][nc]=='o')
					cnt_s++;
				else if(map[nr][nc]=='v')
					cnt_f++;
			}
		}
		
		if(cnt_s > cnt_f)
			sheep += cnt_s;
		else
			fox += cnt_f;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

}
