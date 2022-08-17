package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_G4_뱀 {
	static class Move {
		int s;
		char c;
		public Move(int s, char c) { //s초까지 움직인 후 c방향 전환
			this.s = s;
			this.c = c;
		}
	}
	static class Snake{
		int x;
		int y;
		public Snake(int x, int y) { //뱀의 몸통 좌표 
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int a = Integer.parseInt(br.readLine());
		for (int i = 0; i < a; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			arr[x][y] = 1; //사과의 좌표는 1로 표시한다.
		}
		
		int[] dx = { 0, 1, 0, -1 }; // 우하좌상
		int[] dy = { 1, 0, -1, 0 };
		int x = 0, y = 0, z = 0; // 처음 뱀 위치
		int time = 0;
		
		int m = Integer.parseInt(br.readLine());
		Queue<Move> queue = new LinkedList<>(); //방향 지시 정보 큐
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			queue.offer(new Move(s, c));
		}
		queue.offer(new Move(n,'X')); //박치기 전까지 계속 진행하기 위함
		
		Queue<Snake> snake = new LinkedList<>(); //뱀의 몸통 좌표 저장 큐
		snake.offer(new Snake(x,y));
		arr[x][y]=2; //뱀의 몸통 좌표는 2로 표시한다.
		
		loop: while (true) {
			Move move = queue.poll();
			while (time !=move.s) {
				time++;
				int nx = x + dx[z];
				int ny = y + dy[z];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny]==2) { 
					System.out.println(time);
					break loop; //벽이나 자기 꼬리에 박치기 하면 종료
				}
				//머리 꼬리 관리 
				if(arr[nx][ny]==1) { //사과이면
					snake.offer(new Snake(nx,ny));
					arr[nx][ny]=2; //전진
				}
				else { //빈 곳이면
					snake.offer(new Snake(nx,ny));
					arr[nx][ny]=2; //전진
					Snake sn = snake.poll(); //꼬리를 줄인다
					arr[sn.x][sn.y]=0;
				}
				x=nx;
				y=ny; //뱀 머리 갱신			
			}
			if(move.c=='L') { //왼쪽
				z=(z-1+4)%4;
			}
			if(move.c=='D') { //오른쪽
				z=(z+1)%4;
			}
		}
		

	}
}
