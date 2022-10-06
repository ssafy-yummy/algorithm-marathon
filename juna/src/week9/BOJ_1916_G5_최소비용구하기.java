import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {
	
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge {
		int vertex;
		int weight;
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 도시 개수
		int M = Integer.parseInt(br.readLine());	// 버스 개수
		
		List<Edge>[] edges = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			edges[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[x].add(new Edge(y, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N + 1];
		
		// dp[x] : startCity에서부터 x까지 가는데 걸리는 비용의 최솟값 
		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[startCity] = 0;
		
		while (true) {
			// 1. 시작 도시 정하기 (방문한 적 없고, dp값이 최소인 것)
			int start = -1;
			int min = INF;
			for (int i = 1; i < N + 1; i++)
				if (!visited[i] && dp[i] < min) {
					min = dp[i];
					start = i;
				}
			
			if (start == -1) break;
			visited[start] = true;
			
			
			// 2. 시작 도시를 기준으로, 시작 도시와 연결된 도시들(+ 방문한 적 없는)의 dp값 갱신하기
			for (Edge edge : edges[start]) {
				
				int vertex = edge.vertex;
				int weight = edge.weight;
				
				if (!visited[vertex])
					dp[vertex] = Math.min(dp[vertex], dp[start] + weight);
			}
		}
		
		System.out.println(dp[endCity]);
	}

}
