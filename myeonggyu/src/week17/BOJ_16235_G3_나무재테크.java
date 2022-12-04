package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16235_G3_나무재테크 {

	static class Status{
		
		int nut;
		ArrayList<Integer> trees;
		
		public Status(int nut, ArrayList<Integer> trees) {
			super();
			this.nut = nut;
			this.trees = trees;
		}
		public Status() {
			super();
			trees = new ArrayList<>();
		}
		@Override
		public String toString() {
			return "Status [nut=" + nut + ", trees=" + trees + "]";
		}
		
	}
	
	static int[][] diff = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
	static int n;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] nut = new int[n][n];
		Status[][] map = new Status[n][n];
		int[][] summer = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Status(5,new ArrayList<>());
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken());
			
			map[r][c].trees.add(a);
		}
		
		while(k != 0) {
			
			//봄

//			System.out.println("k : " + k);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Status s = map[i][j];
					
					Collections.sort(s.trees);
					for (int idx = 0; idx < s.trees.size(); idx++) {
						if(s.nut - s.trees.get(idx) < 0) {
							
							summer[i][j] += s.trees.get(idx)/2;							
							s.trees.remove(idx);
							idx--;
						}
						else {
							s.nut -= s.trees.get(idx);
							s.trees.set(idx, s.trees.get(idx)+1);
						}
					}
					
//					System.out.println("i : " + i + " j : " + j + " trees : " +s.trees.toString());
				
				}
			}
			
			//여름
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Status s = map[i][j];
					s.nut += summer[i][j];
					summer[i][j] = 0;
				}
			}
			
			//가을
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Status s = map[i][j];
					
					for (int idx = 0; idx < s.trees.size(); idx++) {
						int tree = s.trees.get(idx);
						
						if(tree % 5 == 0) {
							for (int[] d : diff) {
								int nr = i + d[0];
								int nc = j + d[1];
								
								if(!check(nr,nc))
									continue;
								
								map[nr][nc].trees.add(1);
							}
						}
					}
				}
			}
			
			//겨울
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					Status s = map[i][j];
					s.nut += nut[i][j];
					
				}
			}
			
			
			k--;
			
			
		}
		
		int sums = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sums += map[i][j].trees.size();
			}
		}
		
		System.out.println(sums);
	}


	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}

}
