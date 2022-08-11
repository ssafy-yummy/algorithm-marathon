package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_S1_트리순회 {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][3];	// 1 인덱스 부터 시작 (1:A)
		for(int i=1; i<=N; i++) {
			map[i][0] = i;
		}
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int st0 = st.nextToken().charAt(0)-64;
			int st1 = st.nextToken().charAt(0)-64;
			int st2 = st.nextToken().charAt(0)-64;
			if(st1!=-18) map[st0][1] = st1;
			if(st2!=-18) map[st0][2] = st2;
		} // read

		dfsByPreOrder(1);
		System.out.println(); 
		dfsByInOrder(1);
		System.out.println();
		dfsByPostOrder(1);
		System.out.println();
		
	}
	private static void dfsByPreOrder(int n) {
		if(n==0) return;
		System.out.print((char)(map[n][0]+64));
		dfsByPreOrder(map[n][1]);
		dfsByPreOrder(map[n][2]);
	}
	private static void dfsByInOrder(int n) {
		if(n==0) return;
		dfsByInOrder(map[n][1]);
		System.out.print((char)(map[n][0]+64));
		dfsByInOrder(map[n][2]);
		}
	private static void dfsByPostOrder(int n) {
		if(n==0) return;
		dfsByPostOrder(map[n][1]);
		dfsByPostOrder(map[n][2]);
		System.out.print((char)(map[n][0]+64));
	}
}
