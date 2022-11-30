package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_P5_23291_어항정리 {

	static int N, K, map[][], idx1, idx2, h, ans;
	static int dd[][] = {{1,0},{0,-1},{-1,0},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[N-1][i] = Integer.parseInt(st.nextToken());
		} //read
		
		// 0. 물고기가 가장 많이 들어있는 어항과 가장 적게 들어있는 어항의 물고기 수 차이가 K 이하인지 확인한다.
		while (!check1()) {	// K개 이하가 아니라면 어항 정리 시작
			// 어항 정리
			for (int i = 0; i < N-1; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = 0;
				}
			}
			ans ++;	// 어항 정리하는 횟수
			
			go1();	// 1. 물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣는다.
			go2();	// 2. 어항을 쌓는다.
			go3();	// 3. 물고기의 수를 조절한다.
			go4();	// 4. 다시 어항을 바닥에 일렬로 놓는다.
			go5();	// 5. 다시 공중 부양 작업을 한다.
			go3();	// 6. 물고기의 수를 조절한다.
			go4();	// 7. 다시 어항을 바닥에 일렬로 놓는다.
		}
		System.out.println(ans);
	}

	private static boolean check1() {
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			a = Math.min(a, map[N-1][i]);
			b = Math.max(b, map[N-1][i]);
		}
		return b-a <= K;
	}

	private static void go1() {
		int a = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			a = Math.min(a, map[N-1][i]);	// 물고기가 가장 적은 어항 찾기
		}
		
		for (int i = 0; i < N; i++) {
			if(map[N-1][i] == a) {
				map[N-1][i] ++;	// 가장 적은 어항에 물고기 한 마리 넣기
			}
		}
	}

	private static void go2() {
		// 2-1. 가장 왼쪽에 있는 어항을 그 어항의 오른쪽 위에 올려 놓는다.
		map[N-2][1] = map[N-1][0];
		map[N-1][0] = 0;
		
		idx1 = 1;	// idx1 : 가장 왼쪽에 있는 어항의 인덱스
		idx2 = 2;	// idx2 : 위에 하나도 쌓이지 않은 어항의 인덱스 중 가장 작은 값
		h = 0;	// h : 가장 왼쪽에 있는 어항 위에 쌓인 어항의 개수(높이)
		while(true) {
			// 2-2. 공중 부양시킨 어항 중 가장 오른쪽에 있는 어항의 아래에 바닥에 있는 어항이 있을때까지 반복한다.
			for (int i = N-1; i >= 0; i--) {
				if(map[i][idx1]==0) {
					h = N-i-1;
					break;
				}
			}
			int w = N-idx2;	// w : 위에 하나도 쌓이지 않은 어항의 개수(너비)
			if(h>w) break;	// (2-2)조건을 만족하지 않는 경우 while문을 빠져나온다.
			
			// 2-3. 2개 이상 쌓여있는 어항을 모두 공중 부양시키고, 시계방향으로 90도 회전시킨다.
			// 공중 부양시킨 어항을 바닥에 있는 어항의 위에 올려놓는다.
			for (int i = idx2-1; i >= idx1; i--) {
				int h2 = idx2-i+1;
				for (int j = 0; j < h; j++) {
					map[N-h2][idx2+j] = map[N-1-j][i];
				}
			}
			idx1 = idx2;
			idx2 += h;
		}
	}

	private static void go3() {
		int temp[][] = new int[N][N];	// temp : 물고기의 이동을 위한 2차원 배열
		
		for (int i = N-1; i > N-1-h; i--) {
			for (int j = idx1; j < N; j++) {
				if(map[i][j]==0) continue;
				for (int d = 0; d < 4; d++) {
					int nr = i+dd[d][0];
					int nc = j+dd[d][1];
					// 물고기 이동을 위한 map의 범위를 벗어난 경우 continue
					if(nr<=N-1-h || nr>=N || nc<idx1 || nc>=N) continue;
					// 물고기가 없는 경우 continue
					if(map[nr][nc]==0) continue;
					
					// 인접한 두 어항의 물고기 수 차이를 비교
					int dis = (map[nr][nc]-map[i][j])/5;
					if(dis==0) continue;
					temp[i][j] += dis;
				}
			}
		}

		for (int i = N-1; i > N-1-h; i--) {
			for (int j = idx1; j < N; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	private static void go4() {
		for (int i = 0; i < idx2; i++) {
			map[N-1][i] = map[N-1-(i%h)][idx1+(i/h)];
		}
	}

	private static void go5() {
		// 가운데를 중심으로 왼쪽 N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개의 위에 놓는다.
		int n2 = N/2;
		for (int i = 0; i < n2; i++) {
			map[N-2][i+n2] = map[N-1][n2-1-i];
		}
		
		// 한번 더 반복한다.
		int n4 = N/4;
		for (int i = 0; i < n4; i++) {
			map[N-3][i+n2+n4] = map[N-2][n2+n4-1-i];
			map[N-4][i+n2+n4] = map[N-1][n2+n4-1-i];
		}
		
		idx1 = n2+n4;
		idx2 = N;
		h = 4;
	}
}
