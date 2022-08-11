package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667_S1_단지번호붙이기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] countArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++)
				map[i][j] = s.charAt(j)-'0';
		} // 입력 끝
		
		visited = new boolean[N][N];
		countArr = new int[N*N/2+2];	// cnt의 최대 개수가 N*N/2+1 이다.
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(check1(i,j)&&check2(i,j))
					dfs(i,j,++count);
		
		System.out.println(count);
		Arrays.sort(countArr);
		for(int i=countArr.length-count; i<countArr.length; i++)
			System.out.println(countArr[i]);
	}

	private static void dfs(int i, int j, int cnt) {
		if(!check1(i,j)) return;
		if(!check2(i,j)) return;
		
		map[i][j] = cnt;
		++countArr[cnt];
		visited[i][j] = true;
		dfs(i,j+1,cnt);
		dfs(i+1,j,cnt);
		dfs(i,j-1,cnt);
		dfs(i-1,j,cnt);
	}
	private static boolean check1(int i, int j) {	// 범위 내의 인덱스인지
		return i>=0 && i<N && j>=0 && j<N;
	}
	private static boolean check2(int i, int j) {	// 방문한 적 없는 유효 노드
		return map[i][j]!=0 && !visited[i][j];
	}

}