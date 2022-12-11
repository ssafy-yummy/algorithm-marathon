package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2115_모의_벌꿀채취 {

	static int n;
	static int m;
	static int c;
	static int[][] map;
	static int[] honeyA;
	static int[] honeyB;
	
	static int score;
	
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int totalScore = 0;
			honeyA = new int[m];
			honeyB = new int[m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n-m; j++) {
					
					for (int a = 0; a < m; a++) {
						honeyA[a] = map[i][j+a];
					}
					
					
					score = 0;
					findScore(honeyA);
					int scoreA = score; 
					
					
					if(i==n-1 && j > n-(2*m))
						break;
					
					for (int r = i; r < n; r++) {
						for (int c = 0; c <= n-m; c++) {
							
							int cc = c;
							
							if(r == i) {
								cc = j+m+c;
							}

							if(cc+m>n)
								break;
							
							
							for (int a = 0; a < m; a++) {
								honeyB[a] = map[r][cc+a];
							}
						
							
							score = 0;
							findScore(honeyB);
							int scoreB = score;
							
							totalScore = Math.max(totalScore, scoreA + scoreB);
						
						}
					}
					
				}
			}
			
			System.out.println("#"+t+" " + totalScore);
			
		}
		
	}

	private static void findScore(int[] honey) {

		for (int i = 1; i <= honey.length; i++) {
			arr = new int[i];
			subset(0,0,i,honey);
		}
		
	}

	private static void subset(int start, int cnt, int len, int[] honey) {

		if(cnt==len) {
			int sums = 0;
			
			for (int i = 0; i < len; i++) {
				sums += arr[i];
			}
			
			if(sums > c)
				return;
			
			sums = 0;
			for (int i = 0; i < len; i++) {
				sums += arr[i]*arr[i];
			}
			
			score = Math.max(score, sums);
			
		}
		else {
			
			for (int i = start; i < m; i++) {
				arr[cnt] = honey[i];
				subset(i+1,cnt+1,len,honey);
			}
			
		}
		
	}

}
