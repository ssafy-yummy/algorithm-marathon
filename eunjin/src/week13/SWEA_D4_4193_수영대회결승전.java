package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_4193_수영대회결승전 {

	static int N, map[][], start[], end[], visit[][], ans;
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, sts, ste;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			start = new int[3];	// 시작점 [행위치, 열위치, 시간(0으로 초기화)]
			end = new int[3];	// 도착점
			sts = new StringTokenizer(br.readLine());
			ste = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				start[i] = Integer.parseInt(sts.nextToken());
				end[i] = Integer.parseInt(ste.nextToken());
			} //read
			
			ans = -1;
			bfs();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(start);
		visit = new int[N][N];
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = arr[0]+dd[d][0];
				int nc = arr[1]+dd[d][1];
				int nt = arr[2]+1;	// 1초후
				if(nr==end[0] && nc==end[1]) {	// 도착지에 도착한 경우
					ans = nt;
					return;
				}
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;	// 범위 밖을 벗어난다면 pass
				if(visit[nr][nc]>0) continue;	// 이미 방문한 경우 pass
				if(map[nr][nc]==1) continue;	// 섬과 같은 장애물이 있다면 갈 수 없다.
				if(map[nr][nc]==2) {	// 소용돌이 같은 장애물이 있는 경우
					if(nt%3!=0) {	// 소용돌이가 활동중이라면 갈 수 없다.
						que.offer(new int[] {arr[0], arr[1], nt});
						continue;
					}
				}
				visit[nr][nc] = nt;
				que.offer(new int[] {nr, nc, nt});
			}
		}
	}

}
