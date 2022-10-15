package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {

	static int N, M, start, end;
	//static List<int[]>[] bus;
	static ArrayList<ArrayList<int[]>> bus;
	static int[] cost;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		bus = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			bus.add(new ArrayList<int[]>());
		} // 두 개의 도시를 이어주는 bus 리스트 초기화
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bus.get(a).add(new int[] {b, c});
		} // bus 리스트에 비용 값 할당
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		// read
		
		cost = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		bfs();

		System.out.println(cost[end]);
		
	}

	private static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		cost[start] = 0;
		for (int i = 0, n = bus.get(start).size(); i < n; i++) {
			pq.offer(bus.get(start).get(i));	// 처음 도시에서 갈 수 있는 도시를 추가 (비용 순으로 정렬)
		}
		while(!pq.isEmpty()) {
			int arr[] = pq.poll();
			int from = arr[0];
			int cos = arr[1];
			
			if(visited[from]) continue;
			visited[from] = true;
			
			cost[from] = cos;
			
			if(from == end) return;	// 목표한 도시에 도착하면 끝냄

			for (int i = 0; i < bus.get(from).size(); i++) {
				int arr2[] = bus.get(from).get(i);
				int from2 = arr2[0];
				int cos2 = arr2[1];
				
				pq.offer(new int[] {from2, cos + cos2});
			}
		}
	}

}
