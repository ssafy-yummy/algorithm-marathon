package Study;

import java.io.*;
import java.util.*;

public class BOJ_1992_S1_쿼드트리 {
	static int N;
	static int[][] map;
	static int flag;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char ch[] = str.toCharArray();
			for (int j = 0; j < ch.length; j++) {
				map[i][j] = ch[j]-'0'; // int형으로 값 저장
			}
		}
		tree(0,0,N);
		System.out.println(sb); // 출력
	}
	private static void tree(int x, int y, int n) {
		if(n==0) return; // 기저조건
		
		for (int i = 0; i < n; i++) {
			flag = 0;
			for (int j = 0; j < n; j++) {
				if(map[i+x][j+y]==map[x][y]) continue;
				else {
					flag = 1; // 4개의 영역중 하나라도 다를 경우
					break;
				}
			}
			if(flag == 1) break;
		}
		
		//4개 영역이 하나라도 다를 경우
		if(flag == 1) {
			sb.append('(');
			tree(x,y,n/2);
			tree(x,y+n/2,n/2);
			tree(x+n/2,y,n/2);
			tree(x+n/2,y+n/2,n/2); // 분할정복법
			sb.append(')');
		}
		// 4개 영역이 같을 경우 stringbuilder에 값 추가
		else {
			if(map[x][y] == 0) {
				sb.append(0); 
			}
			else {
				sb.append(1);
			}
		}
	}
}
