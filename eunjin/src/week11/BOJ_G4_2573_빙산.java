package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2573_빙산 {

	static int R, C, map[][], minus[][], count;
	static boolean visit[][];
	static int dd[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		// 1. 얼음 녹이기
		int time = 0;
		do {
			melt(time++);
		} while (count()==1);	// 얼음을 녹인 후에도 얼음이 한 덩어리라면 다시 녹인다.
		
		System.out.println(count==0? 0: time);
		
	}

	private static void melt(int time) {
		minus = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==0) continue;
				
				// 2. 4방에 바닷물이 몇 군데 인접해있는지 확인한다.
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i+dd[d][0];
					int nc = j+dd[d][1];
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(map[nr][nc]==0) cnt++;
				}
				
				// 3. minus[][] 배열에 cnt변수를 저장한다.
				minus[i][j] = cnt;
			}
		}
		
		// 4. map[][] 배열에 녹은 빙하를 저장한다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = Math.max(0, map[i][j]-minus[i][j]);
			}
		}
	}

	private static int count() {
		// 5. 빙하가 몇 덩어리인지 확인한다.
		visit = new boolean[R][C];
		count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visit[i][j] || map[i][j]==0) continue;
				bfs2(i,j);
				count++;
			}
		}
		return count;
	}
	private static void bfs2(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i,j});
		visit[i][j] = true;
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = arr[0]+dd[d][0];
				int nc = arr[1]+dd[d][1];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(visit[nr][nc] || map[nr][nc]==0) continue;
				visit[nr][nc] = true;
				que.offer(new int[] {nr,nc});
			}
		}
	}
}
