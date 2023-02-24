package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {
	static int H,W;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		int num;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			num = Integer.parseInt(st.nextToken());
			for (int j = H-1; j >= H-num; j--) {
				map[j][i] = 1;
			}
		}
		
		int result = 0;
		
		for (int i = H-1; i >= 0; i--) {
			boolean go = false;
			int j = 1;
			int cnt = 0;
			while(j<W) {
				if(map[i][j]==1) {
					if(go) {
						go = false;
						result+=cnt;
						cnt = 0;
					}
				}
				// 비어있을 경우
				else if(map[i][j-1]==1) {
					go = true;
					cnt++;
				}
				// 비어있으면서 진행일 겨웅
				else if(go) {
					cnt++;
				}
				j++;
			}
		}
		System.out.println(result);
	}
}
