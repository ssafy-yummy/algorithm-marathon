package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {

	static int[][] map;
	static int n;
	static int m;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		map = new int[n][m];
		
		int max = 0;
		for (int i = 0; i < m; i++) {
			int v= Integer.parseInt(st.nextToken());
			max = Math.max(v, max);
			for (int j = 0; j < v; j++) {
				map[j][i] = 1;
			}
		}
		

//		for (int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 1)
					continue;
				
				
				check(i,j);
			}
		}
		
		System.out.println(sum);
						
		
		

	}

	private static void check(int i, int j) {
		
		int leftCol = j-1;
		int rightCol = j+1;
		int cnt = 1;
		ArrayList<Integer> p = new ArrayList<>();
		p.add(j);
		while(leftCol  >= 0 && map[i][leftCol] != 1) {

			p.add(leftCol);
			leftCol--;
			cnt++;
		}
		
		if(leftCol == -1)
			return;
		
		while(rightCol < m && map[i][rightCol] != 1) {

			p.add(rightCol);
			rightCol++;
			cnt++;
		}
		
		if(rightCol == m)
			return;
		
		sum += cnt;
		for (Integer integer : p) {
			map[i][integer] = 1;
		}
		
	}

}
