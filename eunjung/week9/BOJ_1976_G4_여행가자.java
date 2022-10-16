package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자 {
	static int N,M,result;
	static int[][] map;
	static boolean[] visited;
	static int[] travel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		travel = new int[M];
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==j) map[i][j] = 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(travel[0]);
		
		boolean result = true;
		for (int i = 0; i < M; i++) {
			if(!visited[travel[i]]) {
				result = false;
				break;
			}
		}
		
		if(result) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void dfs(int idx) {
		visited[idx] = true;

		for (int i = 1; i < N+1; i++) {
			if(map[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
}