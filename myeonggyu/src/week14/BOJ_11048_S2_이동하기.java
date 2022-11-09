package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_S2_이동하기 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i==0 && j== 0)
					continue;
				
				int l = 0;
				int u = 0;
				
				if(i-1>=0)
					u = map[i-1][j];
				if(j-1>=0)
					l = map[i][j-1];
				
				map[i][j] += Math.max(u, l);
			}
		}
		
		System.out.println(map[n-1][m-1]);
		
	}

}
