package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1916_G5_최소비용구하기 {
	
	
	//버스 클래스, 
//	d는 도착지점
//	w는 경로의 비용값
	
	static class Bus{
		
		int d;
		int w;
		
		public Bus() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Bus( int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Bus [d=" + d + ", w=" + w + "]";
		}
				
	}
	
	//현재 상태를 저장하기위한 클래스
//	idx는 현재 위치한 도시
//	w는 도시까지의 총 비용
	
	static class State implements Comparable<State>{
		int idx;
		int w;
		public State() {
			super();
			// TODO Auto-generated constructor stub
		}
		public State(int idx, int w) {
			super();
			this.idx = idx;
			this.w = w;
		}
		@Override
		public String toString() {
			return "State [idx=" + idx + ", w=" + w + "]";
		}
		@Override
		public int compareTo(State o) {
			return Integer.compare(this.w, o.w);
		}
				
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		
		//출발지에서 idx로 표현되는 각 도시까지의 최소비용을 저장하는 배열. 초기값을 큰 값으로 저장해야함.
		int[] citys = new int[n+1];
		for (int i = 0; i < citys.length; i++) {
			citys[i] = Integer.MAX_VALUE;
		}
		List<Bus>[] buses = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			buses[i] = new ArrayList<>();
		}
		
		
		
		//n+1크기의 버스배열을 만들고 m번 순회하여 모든 경로를 저장. 
		
		for (int i = 0; i < m; i++) {
			String[] tmp = br.readLine().split(" ");
			buses[Integer.parseInt(tmp[0])].add(new Bus(
					Integer.parseInt(tmp[1]),
					Integer.parseInt(tmp[2])
					));
		}

		
		
		//시작지점과 도착지점을 저장하고
		String[] tmp = br.readLine().split(" ");
		int start = Integer.parseInt(tmp[0]);
		int desti = Integer.parseInt(tmp[1]);
		
		
		//다익스트라로 계산한 최소경로를 출력
		System.out.println(dijkstra(citys, buses, start,desti));
	}

	private static int dijkstra(int[] citys, List<Bus>[] buses, int start, int desti) {
		
		
		
		//다익스트라는 갈 수 있는 도시들중에서 가장 비용이 최소인 도시를 먼저 방문하기 떄문에 priorityqueue를 사용함.
//		class를 타입으로 가지는pq는 class에 compareto를 오버라이딩 해 사용하는것이 간편함.
		
		
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.offer(new State(start,0));
		
		while(!pq.isEmpty()) {
			State cur = pq.poll();
			
			//만약 현재위치가 목적지라면 리턴, bfs나 dfs에선 다음위치를 탐색하는 지점에서 도착지인지 검사하는게
//			보편적으로 불필요한 계산량을 줄이기 때문에 권장됨. 하지만 만약 시작지점 == 도착지점이라면 for문
//			안에서의 도착지 판단으로는 정확한 계산이 불가능함.따라서 queue.poll로 최근지점을 가져올 때에도 도착지인지 검사해야함.
			if(cur.idx == desti) {
				return cur.w;
			}
			
			//도시의 최소비용값을 업데이트. cur.w가 최소비용이라는건 for문 아래의 탐색부분에서의 조건으로 보장.
			citys[cur.idx] = cur.w;
			
			for (Bus bus : buses[cur.idx]) {
				
				
				//만약 현재위치에서 탐색가능한 다음도시까지의 최소비용, bus.w+cur.w가 그 도시까지의 최소비용값보다 크거나 같으면 
//				탐색을 종료
				if(bus.w+cur.w >= citys[bus.d])
					continue;
				
				pq.offer(new State(bus.d, bus.w+cur.w));
				
			}
			
		}
		
		//도착지점의 최소비용값을 return
		return citys[desti];
		
		
		
	}

}