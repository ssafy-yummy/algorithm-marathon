package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_11048_이동하기 {

	static int N, M, map[][];
	static int dd[][] = {{-1,-1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		// 현재 좌표를 (r,c)하고 할 때,
		// (r-1,c-1), (r-1,c), (r,c-1) 3방향에 존재하는 값 중에서 가장 큰 값을 찾아 map[r][c]에 더한다.
		// 이 때, map의 범위를 벗어나는 것은 고려하지 않는다.
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int maxV = 0;	// (r,c) 좌표 기준 3방향의 최댓값
				for (int d = 0; d < 3; d++) {
					int nr = r+dd[d][0];
					int nc = c+dd[d][1];
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;	// map 범위를 벗어남
					maxV = Math.max(maxV, map[nr][nc]);
				}
				
				map[r][c] += maxV;
			}
		}
		
		System.out.println(map[N-1][M-1]);
	}
}
