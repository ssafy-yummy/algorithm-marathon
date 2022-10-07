package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {
	
	static class Vertex implements Comparator<Vertex>{

		int v, weight;
		
		public Vertex(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compare(Vertex a, Vertex b) {
			return a.weight-b.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		List<Vertex>[] adjList = new ArrayList[V];
		for(int i=0;i<V;i++) {
			adjList[i] = new ArrayList<>();
		}		
		for(int i=0;i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Vertex(to,weight));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		int[] D = new int[V];  //최소비용
		boolean[] visited = new boolean[V]; //정점에 방문했는가  
		
		Arrays.fill(D, Integer.MAX_VALUE); //모든 거리를 최대값으로 초기화
		D[start]=0; //출발지는 0
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex a, Vertex b) {
                return a.weight - b.weight;
            }
        });
		pQueue.offer(new Vertex(start,0));
		
		while(!pQueue.isEmpty()) {
			Vertex minVertex = pQueue.poll(); //pqueue에서 가중치가 가장 작은 정점 선택
			
			if(visited[minVertex.v]) //방문했던 정점이라면 continue
				continue;
			
			visited[minVertex.v]=true; //방문처리
			
			for(int j=0;j<adjList[minVertex.v].size();j++) { //정점의 간선들로 이어지는
				Vertex v = adjList[minVertex.v].get(j); //정점을 선택해서
				if(!visited[v.v] && D[v.v]>D[minVertex.v]+v.weight) { //그 정점을 방문한 적이 없고, 그 정점으로 가는 것이 더 유리하다면
					D[v.v]=D[minVertex.v]+v.weight; //최단거리를 갱신한다
					pQueue.offer(new Vertex(v.v, D[v.v]));
				}
			}
			
		}
		System.out.println(D[end]);
	}

}
