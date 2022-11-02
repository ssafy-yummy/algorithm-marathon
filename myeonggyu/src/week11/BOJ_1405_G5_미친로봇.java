package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1405_G5_미친로봇 {

	static int n;
	static double[] arr;
	static int[] perm = {0,1,2,3};
	static int[][] diff = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[] tmp;
	static double total;
	static int m = 29;
	static int total_cnt;
//	static HashSet<Integer> set = new HashSet<>();
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new double[4];
		
		for (int i = 0; i < 4; i++) {
			arr[i] = Double.parseDouble(st.nextToken())/100.0;
		}
		
		tmp = new int[n];
		total = 0;
//		set.add(14*m+14);
		visited = new boolean[m][m]; 
		visited[14][14] = true;
		perm(0, 14, 14);
//		total_cnt = (int) Math.pow(4, n);
//		double ans = (double)total/(double)total_cnt;
//		ans  = ans * 
		System.out.println(total);
//		System.out.println(total_cnt);
	

	}

	private static void perm(int cnt, int r, int c) {
		
		if(cnt == n) {
			cal();
		}
		
		else {
			
			for (int i = 0; i < 4; i++) {
				tmp[cnt] = perm[i];
				int[] d = diff[tmp[cnt]];
				int nr = r+d[0];
				int nc = c+d[1];
				if(visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				perm(cnt+1, nr,nc);
				visited[nr][nc] = false;
				total_cnt++;
			}
			
			
		}
		
		
	}

	private static void cal() {
		
		double per = 1;
		for (int i = 0; i < n; i++) {
			int idx = tmp[i];
			double percent = arr[idx];
			
			per *= percent;
			
		}
		
		total += per;
		
	}


}
