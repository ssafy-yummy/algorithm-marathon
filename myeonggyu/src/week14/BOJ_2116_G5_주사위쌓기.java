package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_G5_주사위쌓기 {

	
	static int n;
	static int[][] dices;
	static int[] nextIdx = {5,3,4,1,2,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dices = new int[n][6];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxs = 0;
		for (int i = 1; i < 7; i++) {
			int v = dfs(i);
			maxs = Math.max(v,maxs);
//			System.out.println("maxs : " + v);
		}
		
		System.out.println(maxs);
		
	}

	private static int dfs(int s) {

		
		int tmp = 0;
		int sums = 0;
		int total = 0;
		for (int i = 0; i < 6; i++) {
			if(dices[0][i] == s)
				tmp = i;
		}
		
		for (int i = 0; i < 6; i++) {
			if(dices[0][i] == s || dices[0][i] == dices[0][nextIdx[tmp]])
				continue;
			sums = Math.max(sums, dices[0][i]);
		}
		total += sums;
		int next = dices[0][nextIdx[tmp]];
		
		
		for (int j = 1; j < n; j++) {
		
			tmp = 0;
			sums = 0;
			for (int i = 0; i < 6; i++) {
				if(dices[j][i] == next)
					tmp = i;
			}
//			if(next==6)
//				System.out.println(1);
			for (int i = 0; i < 6; i++) {
				if(dices[j][i] == next || dices[j][i] == dices[j][nextIdx[tmp]])
					continue;
				sums = Math.max(sums, dices[j][i]);
			}
			
			
			total += sums;
//			System.out.print("max : " + sums);
//			System.out.print(" pre : " + next);
			next = dices[j][nextIdx[tmp]];
//			System.out.println(" next : " + next);
			
		}
		
		return total;
		
		
	}

}
