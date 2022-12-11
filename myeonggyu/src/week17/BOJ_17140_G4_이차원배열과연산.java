package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140_G4_이차원배열과연산 {

	static int r;
	static int c;
	static int k;
	static int[][] map;
	
	static class Num implements Comparable<Num>{
		int n;
		int cnt;
		public Num(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
		public Num() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Num [n=" + n + ", cnt=" + cnt + "]";
		}
		@Override
		public int compareTo(Num o) {
			if(this.cnt==o.cnt) {
				return Integer.compare(this.n, o.n);
			}
			else {
				return Integer.compare(this.cnt, o.cnt);				
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(simulation());
				
	}

	private static int simulation() {

		int t = 0;
		
		while(t <= 100) {
			
			//행연산인지 열연산인지
			if( r-1 < map.length && c-1 < map[0].length && map[r-1][c-1] == k)
				return t;
			calc();
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
//			System.out.println("-----------");
			t++;
			
		}
		
		return -1;
		
	}

	private static void calc() {
		int rCnt = map.length;
		int cCnt = map[0].length;
		if(rCnt >= cCnt) {
			
			ArrayList<Num>[] arr = new ArrayList[rCnt];
			int maxCcnt = 0;
			for (int i = 0; i < rCnt; i++) {
				
				arr[i] = new ArrayList<>();
				int[] nums = new int[101];
				
				for (int j = 0; j < cCnt; j++) {
					if(map[i][j] == 0)
						continue;
					
					nums[map[i][j]] += 1;
					
				}
				
				for (int j = 1; j < 101; j++) {
					if(nums[j] == 0)
						continue;
					
					arr[i].add(new Num(j,nums[j]));
					if(arr[i].size()==50)
						break;
				}
				
				Collections.sort(arr[i]);
				maxCcnt = Math.max(maxCcnt, arr[i].size()*2);
				
			}
			
			map = new int[rCnt][maxCcnt];
			for (int i = 0; i < rCnt; i++) {
				
				int idx = 0;
				for (int j = 0; j < maxCcnt; j++) {
					
					if(idx < arr[i].size()) {
						map[i][j] = arr[i].get(idx).n;
						map[i][j+1] = arr[i].get(idx).cnt;
						idx++;
						j++;
					}
					else {
						map[i][j] = 0;
					}
				}
			}
			
		}
		
		//열연산
		else {
			
			ArrayList<Num>[] arr = new ArrayList[cCnt];
			int maxRcnt = 0;
			for (int j = 0; j < cCnt; j++) {
				
				arr[j] = new ArrayList<>();
				int[] nums = new int[101];
				
				for (int i = 0; i < rCnt; i++) {
					if(map[i][j] == 0)
						continue;
					
					nums[map[i][j]] += 1;
					
				}
				
				for (int i = 1; i < 101; i++) {
					if(nums[i] == 0)
						continue;
					
					arr[j].add(new Num(i,nums[i]));
					if(arr[j].size() == 50)
						break;
				}
				
				Collections.sort(arr[j]);
				maxRcnt = Math.max(maxRcnt, arr[j].size()*2);
				
			}
			
			map = new int[maxRcnt][cCnt];
			for (int j = 0; j < cCnt; j++) {
				int idx = 0;
				for (int i = 0; i < maxRcnt; i++) {
					
					if(idx < arr[j].size()) {
						map[i][j] = arr[j].get(idx).n;
						map[i+1][j] = arr[j].get(idx).cnt;
						i++;
						idx++;
					}
					else {
						map[i][j] = 0;
					}
				}
			}
			
		}
		
	}

}
