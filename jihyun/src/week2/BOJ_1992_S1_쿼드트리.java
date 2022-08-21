package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_S1_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		recursion(0, 0, n);

		System.out.println(sb.toString());
	}

	private static void recursion(int x, int y, int n) {
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(arr[x][y] != arr[i][j]) { //큰 조각의 원소들이 일치 하지 않는다면
					sb.append('(');
					recursion(x, y, n / 2); //큰 조각을 4조각으로 쪼갠다.
					recursion(x, y + n / 2, n / 2);
					recursion(x + n / 2, y, n / 2);
					recursion(x + n / 2, y + n / 2, n / 2);
					sb.append(')');
					return;
				}
			}
		}
		sb.append(arr[x][y]); //작은 조각의 원소들이 일치한다면 쪼개지 않고 압축을 진행한다.
	}

}
