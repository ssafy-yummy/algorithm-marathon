package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_15685_드래곤커브 {

	static int N, ans;
	static int[] point;	// 끝 점을 저장
	static boolean[][] map;
	static int dd[][] = {{0,1},{-1,0},{0,-1},{1,0}};	// 시작 방향 (우상좌하)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new boolean[101][101];
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());	// 시작 점 y좌표 (열)
			int x = Integer.parseInt(st.nextToken());	// 시작 점 x좌표 (행)
			int d = Integer.parseInt(st.nextToken());	// 시작 방향
			int g = Integer.parseInt(st.nextToken());	// 세대
			
			dragon(x, y, d, g);	// 드래곤 커브 시작
		}
		
		count();
		System.out.println(ans);
	}

	private static void dragon(int x, int y, int d, int g) {
		ArrayList<int[]> points = new ArrayList<>();
		
		int start[] = {x, y};
		int end[] = new int[] {x+dd[d][0], y+dd[d][1]};	// 0세대
		
		points.add(start);	// 드래곤 커브의 시작 좌표를 저장
		points.add(end);
		
		for (int i = 0; i < g; i++) {
			int mid[] = Arrays.copyOf(end, 2);	// 회전 중점
			
			for (int j = 0, n = points.size(); j < n; j++) {
				if(points.get(j)[0]==mid[0] && points.get(j)[1]==mid[1]) continue;	// 중점인 경우는 회전하지 않는다.
				
				int nx = points.get(j)[1]-mid[1]+mid[0];
				int ny = -points.get(j)[0]+mid[0]+mid[1];
				points.add(new int[] {nx, ny});
				
				if(points.get(j)[0]==start[0] && points.get(j)[1]==start[1]) {
					end = new int[] {nx, ny};	// 시작점은 끝점(중점)으로 바꾼다.
				}
			}
		}
		
		// 드래곤 커브가 지나가는 자리를 true로 저장.
		for (int i = 0, n = points.size(); i < n; i++) {
			int px = points.get(i)[0];
			int py = points.get(i)[1];
			map[px][py] = true;
		}
	}

	private static void count() {
		// 네 꼭짓점으로 이루어진 사각형 갯수 구하기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					ans++;
				}
			}
		}
	}
}
