package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23291_P5_어항정리 {

	
	static int n;
	static int k;
	static int[][] map;
	static int[][] diff = {{1,0},{0,1},{-1,0},{0,-1}};	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		int total = 0;
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			map[0][i] = Integer.parseInt(st.nextToken());
		}
		
		if(checkCount())
		{
			System.out.println(0);
			return;
		}
		
		while(true) {
			
			ArrayList<Integer> arr = new ArrayList<>();
			int mins = (int)1e9;
			for (int i = 0; i < n; i++) {
				if(map[0][i] < mins) {
					mins = map[0][i];
					arr.clear();
					arr.add(i);
				}
				else if(map[0][i] == mins) {
					arr.add(i);
				}
			}
			
			for (Integer i : arr) {
				map[0][i] += 1;
			}
		
		//1번 정리
			int cidx = 1;
			int dept = 1;
			a : while(true) {
//				System.out.println("cbidx : " + cidx + " dept : " + dept);
			
				for (int t = 0; t < 2; t++) {
					
					if(cidx+dept+t>n)
						break a;
	
					for (int j = 0; j <dept ; j++) {
						
						
						for (int i = 0; i < dept+t; i++) {
								map[1+j][cidx+i] = map[i][cidx-1-j];
								map[i][cidx-1-j] = 0;
						} 
					}
					
//					print();
//					System.out.println("----------- cidx :" + cidx + " dept : " + dept);
					cidx += dept+t;				
//					System.out.println("cidx : " + cidx + " dept : " + dept);
					
				}
				dept++;
			}
			
//			System.out.println("sort");
//			print();
			sort();
			restore();
			
			
			
			cidx = (n+1)/2;
			int dep = n/2;
			//2번정리
				
			for (int t = 0; t < 2; t++) {
				for (int i = 0; i < t+1; i++) {
					
					for (int j = 0; j < dep; j++) {
						map[1+i+t][cidx+j] = map[t-i][cidx-1-j];
						map[t-i][cidx-1-j] = 0;
					}
				}
				cidx = (cidx+n+1)/2;
				dep = dep/2;
			}
//			print();
			sort();
			restore();
			
				
			total++;
			if(checkCount())
				break;
				
		}
		System.out.println(total);
//		print();
	}


	private static boolean checkCount() {
		
		int mins = (int)1e9;
		int maxs = 0;
		for (int i : map[0]) {
			mins = Math.min(i, mins);
			maxs = Math.max(i, maxs);
		}
		
		return maxs-mins <= k;
	}


	private static void restore() {
		int[] map2 = new int[n];
		int idx = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if(map[i][j] == 0)
					continue;
				
				map2[idx++] = map[i][j];
				map[i][j] = 0;
				
				
			}
		}
		
		map[0] = Arrays.copyOf(map2, n);
	}


	private static void sort() {
		
		int[][] map2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==0)
					continue;
				
				map2[i][j] = map[i][j];
			}
		}
		
		boolean[][] visited = new boolean[n][n];
		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==0)
					continue;
				
				visited[i][j] = true;
				
				for (int[] d : diff) {
					int nr = i+d[0];
					int nc = j+d[1];
					
					if(!check(nr,nc))
						continue;
					
					if(map[nr][nc] == 0)
						continue;
					
					if(visited[nr][nc])
						continue;
					
					
					int di = map[nr][nc]-map[i][j];
					int v = Math.abs(di)/5;
					
					if(di <0) {
						map2[nr][nc] += v;
						map2[i][j] -= v;
					}
					else {
						map2[nr][nc] -= v;
						map2[i][j] += v;
					}
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = map2[i][j];
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}

	private static void print() {
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
	
	

}
