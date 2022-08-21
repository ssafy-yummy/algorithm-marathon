package Study;

import java.util.*;

public class BOJ_14502_G4_연구소 {
	static int N,M;
	static int[][] map, spreadMap;
	static int max,sum;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static ArrayList<L> empty = new ArrayList<L>();
	static ArrayList<L> virus = new ArrayList<L>();
	static class L {
		int x; int y;
		public L(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public L(){}
	}
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		map = new int[N][M];
		spreadMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scann.nextInt();
				if(map[i][j]==0) empty.add(new L(i,j)); // 빈 곳 위치
				if(map[i][j]==2) virus.add(new L(i,j)); // 바이러스 위치
			}
		}
		ncr(0,0); // 조합
		System.out.println(max);
	}
	private static void ncr(int start, int cnt) {
		if(cnt==3) { // 벽을 세울 곳 3개
			arrayCopy(); // 깊은 복사
			
			for(L l: virus) {
				spread(l.x, l.y); // virus 리스트 순회
			}
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(spreadMap[i][j]==0) sum++;
				}
			}
			max = Math.max(max, sum); // 안전영역 최대값
			return;
		}
		for (int i = start; i < empty.size(); i++) {
			int x = empty.get(i).x;
			int y = empty.get(i).y; // 비워있는 위치 인덱스 가져옴
			map[x][y] = 1;
			ncr(i+1, cnt+1);
			map[x][y] = 0;
		}
	}
	private static void arrayCopy() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				spreadMap[i][j] = map[i][j];
			}
		}
	}
	private static void spread(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d]; // 4방탐색
			
			// 인덱스 범위내에 있으면서 바이러스가 퍼질 수 있는 곳 확인
			if(check(nx,ny) && spreadMap[nx][ny]==0) {
				spreadMap[nx][ny] = 2;
				spread(nx,ny); // dfs
			}
		}
	}
	private static boolean check(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M ;
	}
}