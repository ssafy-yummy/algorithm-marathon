package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1405_G5_미친로봇 {
	static int num;
    static int[] dir;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static double result = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		dir = new int[4];
		for (int i = 0; i < 4; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[30][30];
		visited[15][15] = true;
		
		dfs(15, 15, 0, 1.0);
		System.out.println(result);
	}

	private static void dfs(int r, int c, int count, double tmp) {
		if(count == num) {
			result += tmp;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, count + 1, tmp * (double)dir[d]*0.01);
					visited[nr][nc] = false;
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<30 && nc>=0 && nc<30;
	}
	
}