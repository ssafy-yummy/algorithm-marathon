package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		int[][] temp = new int[n][n]; // 비교배열... 맵에서 연합국을 모두 정하고 인구이동을 시작 해야함.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
			
		for (int k = 0;; k++) {
			boolean flag = false; //k일차에 인구이동을 했는가		
			boolean[][] visit = new boolean[n][n]; //이미 연합된 국가인가
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j]==false) { // 연합되지 않은 지역이라면
						Queue<Pos> queue = new LinkedList<>(); //연합국에 추가한다 (국가연합용)
						Queue<Pos> queue2 = new LinkedList<>(); //연합국에 추가한다 (인구이동용)
						queue.offer(new Pos(i, j));
						queue2.offer(new Pos(i, j));
						visit[i][j]=true; //이 지역은 연합된 국가이다
						int count = 0;
						int sum = 0;
						while (!queue.isEmpty()) { //더 이상 연합국가가 없을때까지
							Pos p = queue.poll();
							int x = p.x;
							int y = p.y;
							count++; // 몇개의 국가
							sum += temp[x][y]; // 몇명의 사람

							for (int d = 0; d < 4; d++) { //4방향
								int nx = x + dx[d];
								int ny = y + dy[d];

								if (nx < 0 || nx >= n || ny < 0 || ny >= n) //map이탈
									continue;
								int chai = Math.abs(temp[nx][ny] - temp[x][y]);
								if (chai < l || chai > r) // l보다 작거나 r보다 크다
									continue;
								if (visit[nx][ny]==true) //이미 연합했었다
									continue;

								visit[nx][ny] = true; //연합시키고
								queue.offer(new Pos(nx, ny)); 
								queue2.offer(new Pos(nx, ny));
							}
						}
						if (queue2.size() > 1) // 연합한 국가가 존재한다
							flag = true; 
						while (!queue2.isEmpty()) { //인구이동 시작
							Pos p = queue2.poll();
							int x = p.x;
							int y = p.y;
							map[x][y] = (Integer) (sum / count); // 인구 이동 완료
							temp[x][y]=map[x][y];
						}
					}
				}
			}
			if (flag == false) { //이번 날에는 인구이동이 일어나지 않음
				System.out.println(k);
				break; //종료
			}
		}

	}

}
