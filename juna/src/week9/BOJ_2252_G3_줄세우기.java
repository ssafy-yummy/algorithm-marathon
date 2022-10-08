import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_G3_줄세우기 {

	public static void main(String[] args) throws Exception {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(st.nextToken());    // 학생 수
	    int M = Integer.parseInt(st.nextToken());    // 키를 비교한 횟수
	    
	    // indegree[x] : x노드로 진입하는 간선의 개수
	    int[] indegree = new int[N + 1];
	    
	    // LinkedNode[x] : x노드에서 갈 수 있는 노드들 모음
	    List<Integer>[] LinkedNode = new ArrayList[N + 1];
	    
	    for (int i = 0; i < N + 1; i++)
			LinkedNode[i] = new ArrayList<>();
	    
	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        LinkedNode[x].add(y);
	        indegree[y]++;
	    }
	    
	    
	    // 진입차수가 0개인 노드를 큐에 담는다.
	    Queue<Integer> q = new LinkedList<Integer>();
	    for (int i = 1; i < N + 1; i++)
			if (indegree[i] == 0) q.offer(i);

	    while (!q.isEmpty()) {
	    	// 1. 진입차수가 0인 노드를 꺼내어 삭제한다.
		    int node = q.poll();
		    sb.append(node + " ");
		    
		    // 2. 다른 노드들의 진입차수를 갱신한다.
		    for (int i : LinkedNode[node])
				if (--indegree[i] == 0) q.offer(i);
	    }
	    
	    System.out.println(sb);
	}

}
