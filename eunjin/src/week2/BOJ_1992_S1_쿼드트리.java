package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_S1_쿼드트리 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j<N; j++)
				map[i][j] = ch[j]-'0';
		} // read
		
		dfs(0,0,N);
		System.out.println(sb);
		
	}

	private static void dfs(int R, int C, int length) {
		if(isSame(R,C,length)) {	// 주어진 칸이 모두 동일한 숫자라면
			sb.append(map[R][C]);
		} else {
			int l = length/2;
			sb.append("(");
			dfs(R,C,l);
			dfs(R,C+l,l);
			dfs(R+l,C,l);
			dfs(R+l,C+l,l);
			sb.append(")");
		}
	}

	private static boolean isSame(int R, int C, int length) {
		if(length==1) return true;
		int temp = map[R][C];
		for(int i=R; i<R+length; i++)
			for(int j=C; j<C+length; j++)
				if(temp!=map[i][j]) return false;
		return true;
	}
}
