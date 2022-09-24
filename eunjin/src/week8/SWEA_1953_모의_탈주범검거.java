package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_모의_탈주범검거 {

	static int N, M, R, C, L, map[][];
	static Queue<int[]> point;
	static boolean visited[][];

	static int[][] pipe = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};	// 터널 구조물 타입 (0,1,2,3=>상,하,좌,우)
	static int[][] dd = {{-1,0},{1,0},{0,-1},{0,1}};	// 상,하,좌,우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			visited = new boolean[N][M];
			visited[R][C] = true;	// 맨홀 뚜껑이 위치한 장소
			
			point = new LinkedList<>();
			point.offer(new int[] {R,C});	// 다음 터널로 이어지는 현재의 터널 끝 부분들
			
			int n = 1;
			for (int i = 1; i < L; i++) {
				n = point.size();
				if(n==0) break;
				for (int j = 0; j < n; j++) {
					move();
				}
			}
			
			System.out.println("#"+tc+" "+count());
			
		}
	}
	
	private static void move() {
		int loc[] = point.poll();	// 다음 터널로 이어지는 현재의 터널 끝 부분 위치(r,c)
		int r = loc[0];
		int c = loc[1];
		
		for(int d: pipe[map[r][c]]) {
			int nr = r+dd[d][0];
			int nc = c+dd[d][1];
			if(!check(nr,nc)) continue;
			if(visited[nr][nc]) continue;	// 이미 방문했으므로 넘어감
			if(map[nr][nc]==0) continue;	// 지하 터널이 없는 곳이므로 넘어감
			
			// 지하 터널이 이어질 수 있는 곳인지.. 즉, 탈주범이 다음 구역으로 이동할 수 있는지 확인
			for (int temp: pipe[map[nr][nc]]) {
				if(d%2==0) {	// d가 0,2라면.. 즉, 위쪽과 왼쪽 방향으로 뻗은 지하 터널일 경우
					if(d+1==temp) {	// temp가 1,3이라면.. 즉, 아래쪽과 오른쪽 방향으로 뻗은 지하 터널일 경우
						visited[nr][nc] = true;	// 다음 경로는 탈주범이 이동할 수 있는 구역이 된다.
						point.offer(new int[] {nr,nc});
						break;
					}
				} else {	// d가 1,3이라면.. 즉, 위쪽과 왼쪽 방향으로 뻗은 지하 터널일 경우
					if(d-1==temp) {	// temp가 0,2라면.. 즉, 아래쪽과 오른쪽 방향으로 뻗은 지하 터널일 경우
						visited[nr][nc] = true;	// 다음 경로는 탈주범이 이동할 수 있는 구역이 된다.
						point.offer(new int[] {nr,nc});
						break;
					}
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static int count() {
		int ans = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(visited[i][j])
					ans++;
		return ans;
	}

}
