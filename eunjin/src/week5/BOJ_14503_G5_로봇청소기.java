package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_G5_로봇청소기 {

	static int N, M, map[][];
	static int row, col, dir, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());	// 로봇의 현재 행 위치
		col = Integer.parseInt(st.nextToken());	// 로봇의 현재 열 위치
		dir = Integer.parseInt(st.nextToken());	// 로봇의 현재 방향
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 로봇청소기 탐사
		go1(row,col,dir);
		
		System.out.println(ans);
	}
	
	private static void go1(int row, int col, int dir) {
		// 현재 위치를 청소함
		map[row][col] = 2;
		ans++;
		
		// 2. 현재 방향을 기준으로 왼쪽 방향 탐색 시작
		go2(row,col,dir);
	}

	// dir이 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라봄
	// 북쪽을 바라보는 기준으로 왼쪽 방향은 '서 남 동 북'
	// 동쪽을 바라보는 기준으로 왼쪽 방향은 '북 서 남 동'
	// 남쪽을 바라보는 기준으로 왼쪽 방향은 '동 북 서 남'
	// 서쪽을 바라보는 기준으로 왼쪽 방향은 '남 동 북 서'
	static int dd[][] = {{-1,0},{0,1},{1,0},{0,-1}};	// '북 동 남 서'
	
	private static void go2(int row, int col, int dir) {
		for (int d = 0; d < 4; d++) {
			// 왼쪽 방향 탐색
			dir = (dir+3)%4;
			int nr = row+dd[dir][0];
			int nc = col+dd[dir][1];
			if(map[nr][nc]==1 || map[nr][nc]==2) continue;	// 왼쪽 공간이 벽이거나 이미 청소한 공간인 경우 다시 회전
			// 왼쪽 공간이 청소가 안 된 구역이라면 그 방향으로 회전하고 1번으로 돌아감
			go1(nr,nc,dir);
			return;
		}
		// 네 방향 모두 청소할 수 없다면 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아감(go2())
		// 한 칸 후진을 할 수 없다면 작동을 멈춤(return)
		int nd = (dir+2)%4;	// 두 번 회전하는 것이 뒤를 도는 것과 같은 것임
		int nr = row+dd[nd][0];
		int nc = col+dd[nd][1];
		if(map[nr][nc]==1) return;
		// 뒤로 후진
		go2(nr,nc,dir);
	}
}
