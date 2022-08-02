package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_G4_뱀 {
	
	static int N, K, L, timer, y, x, k;
	static int[] X;
	static String[] C;
	static int[][] board;
	static Queue<int[]> tail;
	
	// 오른쪽, 아래, 왼쪽, 위
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];	// 1-based
		
		for (int i = 1; i < N + 1; i++)
			Arrays.fill(board[i], 0);	// 0으로 초기화
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			board[y][x] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		X = new int[L];
		C = new String[L];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			C[i] = st.nextToken();
		}
		
		// 2. 문제 풀이
		solve();
		
		// 3. 출력
		System.out.print(timer);
	}

	private static void solve() {
		
		y = 1;							// 머리의 처음 y좌표
		x = 1;							// 머리의 처음 x좌표
		k = 0;							// 처음에는 오른쪽을 향함 (k = 0 ~ 3)
		timer = 0;
		tail = new LinkedList<>();		// q는 뱀이 지나가고 있는 좌표들 (FIFO이므로 Queue로 구현)
		tail.offer(new int[] {1, 1});	// 뱀의 처음 좌표는 (1, 1)
		
		for (int i = 0; i <= L; i++) {
			while (true) {
				timer++;
				y += dy[k];
				x += dx[k];
				
				if (y < 1 || y > N || x < 1 || x > N)	// 뱀이 보드를 벗어나면 GameOver
					return ;
				
				for (int[] j : tail)					// 뱀이 자신의 꼬리를 밟는다면 GameOver
					if (j[0] == y && j[1] == x)
						return ;
				
				tail.offer(new int[] {y, x});			// 새로운 좌표를 꼬리에 추가
				
				if (board[y][x] == 1) 					// 사과를 만났다면 -> 사과는 사라짐
					board[y][x] = 0;
				else									// 사과를 만나지 않았다면 -> 꼬리가 이동함
					tail.poll();
				
				if (i < L && X[i] == timer) {
					if (C[i].equals("L"))				// 좌회전
						k = (k + 3) % 4;
					else if (C[i].equals("D"))			// 우회전
						k = (k + 1) % 4;
					break;
				}
			}
		}
	}
}