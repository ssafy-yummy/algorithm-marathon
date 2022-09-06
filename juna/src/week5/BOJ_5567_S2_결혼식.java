import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5567_S2_결혼식 {
	
	static int N, M, cnt;
	static List<Integer>[] friend;
	static int[] chk;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 사람 수
		M = Integer.parseInt(br.readLine());	// 관계 수
		
		// dfs 탐색 시 방문체크를 위한 배열
		chk = new int[N + 1];
		Arrays.fill(chk, Integer.MAX_VALUE);
		
		// 친구 관계를 저장할 자료구조
		friend = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			friend[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		
		
		// 2. 풀이
		chk[1] = -1;	// 상근이는 재방문하면 안되므로 -1 값을 넣어주고 시작
		dfs(1, 0);
		
		
		// 3. 정답 출력
		System.out.println(cnt);
	}

	private static void dfs(int i, int depth) {
		
		// 친구의 친구까지만 카운트해야하므로, 깊이 2까지만 탐색해야한다.
		if (depth == 2)
			return ;
		
		
		// i의 친구 j에 대하여
		for (Integer j : friend[i])
			// 이전에 j를 방문한 적 있더라도, 더 낮은 깊이로 방문할 수 있다면 또 탐색을 진행한다.
			if (chk[j] > depth) {
				// j를 최초로 방문할 때에만 정답(cnt)을 하나 늘린다.
				if (chk[j] == Integer.MAX_VALUE) cnt++;
				chk[j] = depth;
				dfs(j, depth + 1);
			}
		
	}

}
