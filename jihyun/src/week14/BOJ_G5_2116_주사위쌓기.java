package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2116_주사위쌓기 {
	static int n;
	static int[][] dice;
	static int nextTop;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dice = new int[n][6];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[] opposite = {5,3,4,1,2,0}; //0 1 2 3 4 5 주사위의 반대쪽 면
		int answer = 0;
		for(int k=1;k<=6;k++) { //기준이 되는 맨 아랫면
			int bottom = k;
			int sum = 0;
			for(int i=0;i<n;i++) { //몇개의 주사위
				int max = 0;
				int temp = -1;
				for(int j=0;j<6;j++) { 
					if(dice[i][j]==bottom) { //맨 아래 맞물려야 하거나
						continue;
					}
					else if(dice[i][opposite[j]]==bottom) { //나의 반대편이 맨 아래 맞물려야 한다
						temp = dice[i][j];
						continue;
					}
					else {
						max = Math.max(max, dice[i][j]); //옆면 4개 중 가장 큰 수 선택
					}
				}
				sum+=max;
				bottom = temp; //다음 아랫면 갱신
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
