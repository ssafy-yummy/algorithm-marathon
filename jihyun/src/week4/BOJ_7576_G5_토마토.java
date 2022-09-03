package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_G5_토마토 {
	static class Pos {
		int x, y;

		private Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		Queue<Pos> tomatos = new LinkedList<>();
		int not_red = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { //익은 토마토를 큐에 넣는다.
					tomatos.offer(new Pos(i, j));
				} 
				else if(map[i][j]==0) //안익은 토마토 개수를 센다
					not_red++;
			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int answer=0;
		while (!tomatos.isEmpty()) { //더이상 퍼질 수 없을 때까지
			int size = tomatos.size(); //1일 간 퍼지는 토마토 양 조절
			for (int i = 0; i < size; i++) {
				Pos p = tomatos.poll();
				int x = p.x;
				int y = p.y;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (map[nx][ny] == 1 || map[nx][ny]==-1)
						continue;

					//익힐 수 있는 토마토 발견
					map[nx][ny]=1; //토마토 익히기
					tomatos.offer(new Pos(nx, ny)); //큐에 추가시켜서 다음날에 옆에 옮게 하기
					not_red--; //안 익은 토마토 개수 감소

				}
			}
			answer++;

		}
		if(not_red!=0) //안익은 토마토가 있다
			System.out.println(-1);
		else //토마토가 모두 익었다
			System.out.println(answer-1);

	}

}
