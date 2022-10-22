package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_모의_5653_줄기세포배양 {

	static class Node implements Comparable<Node> {
		int row, col, life, time;

		public Node(int row, int col, int life, int time) {
			super();
			this.row = row;	// 행위치
			this.col = col;	// 열위치
			this.life = life;	// 생명력 수치
			this.time = time;	// 0부터 시작해서 life+1일때 활성화 상태로 변환, life*2일때는 죽은 세포로 체크한다.
		}

		@Override
		public int compareTo(Node o) {
			return o.life - this.life;	// 하나의 셀에 동시에 번식하려고 하는 경우에, 생명력 수치가 더 높은 줄기 세포를 저장한다.
		}
	}
	static int N, M, K;
	static PriorityQueue<Node> pq;
	static List<Node> plus;
	static boolean visit[][];
	static int dd[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue();
			visit = new boolean[350][350];	// 최대 N,M의 크기가 50, 최대 배양 시간이 300이다. 2시간마다 1만큼 크기가 증감한다. (150+50+150=350)
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int x = Integer.parseInt(st.nextToken());
					if(x==0) continue;	// 0은 비어있는 공간이므로 pass
					
					pq.offer(new Node(r+150,c+150,x,0));	// 살아있는 세포를 que에 넣을 것임
					visit[r+150][c+150] = true;
				}
			} //read
			
			// 1. K 시간이 흐른다
			for (int i = 0; i < K; i++) {
				move();
			}
			
			sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void move() {
		plus = new LinkedList<>();	// 해당 시간에서 살아있는 세포를 저장.
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			node.time++;	// 한 시간 경과
			
			// 2. 세포가 활성화된 경우, 4방으로 퍼진다.
			if(node.time == node.life+1) {
				spread(node);
			}
			
			// 3. 비활성화 세포가 죽은 경우
			if(node.time == node.life*2) continue;
			
			// 4. 세포가 살아있는 경우
			plus.add(node);	// time+1 한 후 저장

		}
		
		// 5. 번식하는 세포(plus)를 살아있는 세포(pq) 변수에 저장한다.
		int n = plus.size();
		for (int i = 0; i < n; i++) {
			pq.offer(plus.get(i));
		}
		
	}

	private static void spread(Node node) {
		for (int d = 0; d < 4; d++) {
			int nr = node.row+dd[d][0];
			int nc = node.col+dd[d][1];
			if(visit[nr][nc]) continue;	// 이미 있는 경우에 pass
			visit[nr][nc] = true;
			plus.add(new Node(nr,nc,node.life,0));
		}
	}

}
