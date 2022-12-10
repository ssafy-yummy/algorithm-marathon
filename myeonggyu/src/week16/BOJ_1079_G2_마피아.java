package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1079_G2_마피아 {

	static int n;
	static int[] scores;
	static int[][] relation;
	static int myNumber;
	static boolean[] deadPeople;
	static int res = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		scores = new int[n];
		relation = new int[n][n];
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				relation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		myNumber = Integer.parseInt(br.readLine());
		deadPeople = new boolean[n];
		//현재 사람수, 죽인사람 배열을 들고 게임을 시작
		search(n, 0);
		
		System.out.println(res);
		
	}

	private static void search(int cnt, int night) {

		
		if(cnt==1 || deadPeople[myNumber] == true) {
			res = Math.max(res, night);
			return;
		}
		
		//밤이면
		if(cnt%2 == 0) {
			
			for (int i = 0; i < n; i++) {
				if(deadPeople[i])
					continue;
				
				if(i==myNumber)
					continue;
				
				deadPeople[i] = true;
				changeScore(i,1);
				search(cnt-1, night+1);
				deadPeople[i] = false;
				changeScore(i, -1);
				
			}
			
		}
		//낮이면
		else {
			
			int maxIdx = 0;
			int maxs = 0;
			for (int i = 0; i < n; i++) {
				
				if(deadPeople[i])
					continue;
				
				if(maxs < scores[i]) {
					maxs = scores[i];
					maxIdx = i;
				}
				else if(maxs == scores[i]) {
					if(maxIdx > i)
						maxIdx = i;
				}
			}
			
			deadPeople[maxIdx] = true;
			search(cnt-1, night);
			deadPeople[maxIdx] = false;
			
		}
		
	}

	private static void changeScore(int idx, int type) {
		for (int i = 0; i < n; i++) {
			
			if(i == idx)
				continue;
			
			if(type == 1)
				scores[i] += relation[idx][i];
			else
				scores[i] -= relation[idx][i];
		}
	}

}
