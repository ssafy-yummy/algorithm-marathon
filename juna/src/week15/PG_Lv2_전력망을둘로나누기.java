import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG_Lv2_전력망을둘로나누기 {

	public static void main(String[] args) {
		int ans = 0;
		ans = solution(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
		System.out.println(ans);
	}
	
	static List<Integer>[] tree;
	
	public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        tree = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) 
        	tree[i] = new ArrayList<>();
		
        for (int[] cur : wires) {
        	int a = cur[0];
        	int b = cur[1];
			tree[a].add(b);
			tree[b].add(a);
		}
        
        for (int[] cur : wires) {
        	int a = cur[0];
        	int b = cur[1];
        	
        	// a와 b를 끊기 (트리는 연결 1개만 끊어도 정확히 둘로 나눠진다.)
        	int tmp1 = bfs(n, a, b);	// a와 연결된 트리의 노드 개수
        	int tmp2 = bfs(n, b, a);    // b와 연결된 트리의 노드 개수
        	
        	answer = Math.min(answer, Math.abs(tmp1 - tmp2));
		}
        
        
        return answer;
    }
	
	// a와 연결된 노드들을 탐색 (단 b는 탐색하면 안 된다)
	private static int bfs(int n, int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		
		q.offer(a);
		visited[a] = true;
		visited[b] = true;	// b가 탐색되지 않기 위해서 visited true 해준다.
		
		int ret = 1;
		
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : tree[x]) {
				if (visited[y]) continue;
				q.offer(y);
				visited[y] = true;
				ret++;
			}
		}
		
		return ret;
	}
}
