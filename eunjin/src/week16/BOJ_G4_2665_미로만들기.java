package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G4_2665_미로만들기 {

	static int N, map[][][];
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// map[0][N][N] : 흰 방인지 검은 방인지 확인
		// map[1][N][N] : 해당 위치에 도달하기 위해 흰 방으로 바꾼 검은 방의 최소 개수
		map = new int[2][N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] ca = s.toCharArray();
			for (int j = 0; j < N; j++) {
				map[0][i][j] = ca[j]-'0';	// 흰 방 : 1, 검은 방 : 0
			}
		} //read
		
		clear();	// map[1][N][N] 배열 초기화
		bfs();		// bfs 탐색 시작
		
		System.out.println(map[1][N-1][N-1]);
	}

	private static void clear() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[1][i], Integer.MAX_VALUE);
		}
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		map[1][0][0] = 0;	// 0행 0열에 도달하기 위해서, 흰 방으로 바꾼 검은 방의 최소 개수는 0이다.
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			int r = arr[0];
			int c = arr[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+dd[d][0];
				int nc = c+dd[d][1];
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(map[0][nr][nc]==0) {	// 1) 다음 블록이 검은 방이라면
					if(map[1][nr][nc] <= map[1][r][c]+1) continue;	// 이미 최솟값을 가진 경우
					map[1][nr][nc] = map[1][r][c]+1;
				} else {	// 2) 다음 블록이 흰 방이라면
					if(map[1][nr][nc] <= map[1][r][c]) continue;	// 이미 최솟값을 가진 경우
					map[1][nr][nc] = map[1][r][c];
				}
				que.offer(new int[] {nr,nc});
			}
		}
	}
}
