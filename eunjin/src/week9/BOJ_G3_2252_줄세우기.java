package week9;
// 위상정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2252_줄세우기 {

	static int N, M;
	static List<List<Integer>> list;	// 각 노드에 대한 진입 정점들을 저장
	static int[] nodesCount;	// 각 노드에 대한 진입 정점의 개수를 저장
	static Queue<Integer> que;	// 집입 차수가 0인 정점들을 넣을 예정
	static StringBuilder sb;	// 출력
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>(N+1);
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		} // list 초기화
		nodesCount = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//list.get(b).add(a);	// list[b]에 a를 추가한다. (위상정렬을 위해 진입 정점을 추가함)
			list.get(a).add(b);	// list[a]에 b를 추가한다. (위상정렬을 위해 진입 정점에 정점을 추가함)
			nodesCount[b]++;	// 진입 차수를 센다.
		} //read
		
		
		que = new LinkedList<>();
		sb = new StringBuilder();
		
		// 1. 진입 차수가 0인 정점들을 큐에 넣는다.
		put();
		while(!que.isEmpty()) {
			// 2. 큐에 있는 정점을 하나씩 빼면서 진입 차수도 새로 업데이트한다.
			update();
			
			// 3. 진입 차수가 0인 정점들을 큐에 넣는다.
			put();
		}
		
		System.out.println(sb.toString());
	}

	private static void put() {
		for (int i = 1; i < N+1; i++) {
			if(nodesCount[i] == 0) {	// 집입 차수가 0인 경우
				que.offer(i);
				nodesCount[i]--;	// 끝난 정점은 진입 차수를 -1로 만듦
			}
		}
	}

	private static void update() {
		if(que.isEmpty()) return;	// 큐가 비어있다면 pass
		
		int q = que.poll();
		sb.append(q).append(" ");
		
		int n = list.get(q).size();
		for (int i = 0; i < n; i++) {
			nodesCount[list.get(q).get(i)]--;	// 진입 차수를 -1 한다.
		}
		list.get(q).clear();	// 진입 정점을 제거
	}
}
