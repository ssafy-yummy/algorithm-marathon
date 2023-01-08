package week12;

import java.io.*;
import java.util.*;

public class BOJ_2564_S1_경비원 {
	static int[][] arr;
	static int nd,std;
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		arr = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		nd = Integer.parseInt(st.nextToken());
		std = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int i = 0; i < num; i++) {
			ans+=distance(arr[i][0],arr[i][1]);
		}
		System.out.println(ans);
	}

	private static int distance(int dir, int n) {
		int dis = 0;
		
		switch(nd) {
		
		case 1: // 북쪽
			if(dir==1) { // 북
				dis = Math.abs(std-n);
			}
			if(dir==2) { // 남
				int n1 = std+n;
				int n2 = R-std+R-n;
				dis = Math.min(n1, n2) + C;
			}
			if(dir==3) { // 서
				dis = std+n;
			}
			if(dir==4) { // 동
				dis = R-std+n;
			}
			break;
			
		case 2: // 남쪽
			if(dir==1) { // 북
				int n1 = std+n;
				int n2 = R-std+R-n;
				dis = Math.min(n1, n2) + C;
			}
			if(dir==2) { // 남
				dis = Math.abs(std-n);
			}
			if(dir==3) { // 서
				dis = std+C-n;
			}
			if(dir==4) { // 동
				dis = R-std+C-n;
			}
			break;
		case 3: // 서쪽
			if(dir==1) { // 북
				dis = std+n;
			}
			if(dir==2) { // 남
				dis = C-std+n;
			}
			if(dir==3) { // 서
				dis = Math.abs(std-n);
			}
			if(dir==4) { // 동
				int n1 = std+n;
				int n2 = C-std+C-n;
				dis = Math.min(n1, n2) + R;
			}
			break;
		case 4: // 동쪽
			if(dir==1) { // 북
				dis = std+R-n;
			}
			if(dir==2) { // 남
				dis = C-std+R-n;
			}
			if(dir==3) { // 서
				int n1 = std+n;
				int n2 = C-std+C-n;
				dis = Math.min(n1, n2) + R;
			}
			if(dir==4) { // 동
				dis = Math.abs(std-n);
			}
			break;
		}
		
		return dis;
	}
}
