import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18352_S2_특정거리의도시찾기 {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, K, X;
	static int[] dp;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 도시 개수
		M = Integer.parseInt(st.nextToken());	// 도로 개수
		K = Integer.parseInt(st.nextToken());	// 거리 정보
		X = Integer.parseInt(st.nextToken());	// 출발 도시 번호
		
		adj = new ArrayList[N + 1];		// 도시간 연결 정보를 담는 인접리스트
		for (int i = 1; i < N + 1; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B);	// 방향 그래프
		}
		
		
		// 2. 문제 풀이
		dijstra(X);
		
		
		// 3. 정답 출력
		boolean idx = true;
		for (int i = 1; i < N + 1; i++)
			if (dp[i] == K) {
				bw.append(i + "\n");
				idx = false;
			}
		
		// 정답을 만족하는 것이 하나도 없다면 -1을 출력
		if (idx) bw.append("" + -1);	
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dijstra(int x) {
		
		boolean[] visited = new boolean[N + 1];
		dp = new int[N + 1];	// dp[y]의 의미 : x에서 y까지 갈 때의 최단거리
		Arrays.fill(dp, INF);
		dp[x] = 0;
		
		while (true) {
			
			// 1. 출발 노드 start 정하기 (방문한 적 없으면서, dp값이 최소인 것)
			int start = -1;
			int min = INF;
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > dp[i]) {
					min = dp[i];
					start = i;
				}
			}
			
			// 시간 단축을 위해서, 거리가 K를 초과하면 탐색 종료
			if (start == -1 || dp[start] > K) break;	
			visited[start] = true;
			
			// 2. start 도시와 연결된 도시들에 대하여, dp값을 갱신해주기
			for (int end : adj[start]) {
				if (visited[end]) continue;
				dp[end] = Math.min(dp[end], dp[start] + 1);
			}
		}
	}
}