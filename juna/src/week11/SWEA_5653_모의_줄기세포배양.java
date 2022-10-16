import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cell {
	int y;
	int x;
	int status;		// 0 사망, 1 활성, 2 비활성
	int created;	// 생성된 시각
	int life;		// 생명력 수치
	
	public Cell(int y, int x, int status, int created, int life) {
		this.y = y;
		this.x = x;
		this.status = status;
		this.created = created;
		this.life = life;
	}
}

public class SWEA_5653_모의_줄기세포배양 {
	
	static int Y;	// 행 수
	static int X;	// 열 수
	static int K;	// 배양 시간
	static Cell[][] map;
	
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[] dx = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			// 1. 입력 받기
			st = new StringTokenizer(br.readLine());	
			int N = Integer.parseInt(st.nextToken());	// 초기 상태에서 줄기 세포가 분포된 영역의 세로 크기
			int M = Integer.parseInt(st.nextToken());	// 초기 상태에서 줄기 세포가 분포된 영역의 가로 크기
			K = Integer.parseInt(st.nextToken());
			
			Y = 2 * K + N;
			X = 2 * K + M;
			map = new Cell[Y][X];
			Queue<Cell> cells = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						map[K + i][K + j] = new Cell(K + i, K + j, 2, 0, life);
						cells.offer(map[K + i][K + j]);
					}
				}
			}
			
			
			// 2. 문제 풀이
			int time = 0;
			while (++time <= K) {
				
				int size = cells.size();
				for (int i = 0; i < size; i++) {
					
					Cell cell = cells.poll();
					if (map[cell.y][cell.x].life != cell.life) continue;
					
					// 활성 상태라면 -> 죽을 차례인지 체크
					if (cell.status == 1 && cell.created + cell.life * 2 < time) {
						cell.status = 0;
						continue;
					}
					
					// 활성 상태라면 -> 번식 시키기
					else if (cell.status == 1) {
						for (int k = 0; k < 4; k++) {
							int ny = cell.y + dy[k];
							int nx = cell.x + dx[k];
							
							// 비어 있다.
							if (map[ny][nx] == null) {
								map[ny][nx] = new Cell(ny, nx, 2, time, cell.life);
								cells.offer(map[ny][nx]);
							}
							
							
							// 동시에 번식한 다른 세포가 이미 있다. 
							else if (map[ny][nx].status == 2 && map[ny][nx].created == time) {
								if (map[ny][nx].life < cell.life) {
									map[ny][nx] = new Cell(ny, nx, 2, time, cell.life);
									cells.offer(map[ny][nx]);
								}
							}
						}
					}
					
					
					// 비활성 상태라면 -> 활성될 차례인지 체크
					else if (cell.status == 2 && cell.created + cell.life == time)
						cell.status = 1;
					
					cells.offer(cell);
				}
			}
			
			int ans = 0;
			for (Cell cell : cells) {
				if (map[cell.y][cell.x].life != cell.life) continue;
				
				// 마지막으로 죽일 세포들 전부 죽이기
				if (cell.status == 1 && cell.created + cell.life * 2 < time)
					cell.status = 0;
				
				// 살아있는 세포 개수 세기
				else if (cell.status != 0)
					ans++;
			}
			
			
			// 3. 출력
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}
}
