import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자 {
	
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 도시들의 수
		int M = Integer.parseInt(br.readLine());	// 여행 계획에 속한 도시들의 수
		
		// p[x] : x 노드의 최종 부모 노드
		p = new int[N + 1];
		for (int i = 1; i < N + 1; i++) p[i] = i;
		
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				if (st.nextToken().equals("1"))
					// 연결된 도시들은 union(최종 부모 노드를 같게 해주기)
					union(i, j);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫 번째 여행 계획 도시의 최종 부모 노드(parent)를 기준으로 삼는다.
		int parent = find(Integer.parseInt(st.nextToken()));
		String ans = "YES";
		
		for (int i = 0; i < M - 1; i++) {
			int city = Integer.parseInt(st.nextToken());
			
			// city의 최종 부모 노드가 parent와 다르다면 (== 같은 그래프에 속해있지 않다면)
			if (find(city) != parent) {
				ans = "NO";
				break;
			}
		}
		
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a == b) return ;
		p[a] = b;
	}

	private static int find(int x) {
		if (p[x] == x) return p[x];
		return p[x] = find(p[x]);
	}

}
