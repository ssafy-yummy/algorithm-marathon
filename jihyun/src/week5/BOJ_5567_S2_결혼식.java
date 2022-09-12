package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_S2_결혼식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] adjList = new ArrayList[N];
		for(int i=0;i<N;i++) {
			adjList[i] = new ArrayList<>();
		}		
		for(int i=0;i<M;i++) { //인접리스트에서 친구 대한 정보를 저장한다.
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjList[from].add(to);
			adjList[to].add(from);
		}

		//자신의 학번은 1이고 자신의 친구는 거리가 1, 친구의 친구는 거리가 2이다.
		Queue<Integer> queue = new LinkedList<>(); //최단거리를 구하기 위해 BFS 사용
		int D = 1;
		boolean[] visit = new boolean[N];
		queue.offer(0); //출발지 등록
		visit[0]=true;
		
		int answer = 0;
		while(!queue.isEmpty() && D<=2) {
			int size = queue.size(); //거리 D에 해당하는 친구들만 관리하기 위함.
			for(int i=0;i<size;i++) {
				int q = queue.poll();
				
				for(int j=0;j<adjList[q].size();j++) { //지금까지 방문하지 않았던친구, 즉 최단거리를 만족하는 친구들임.
					if(!visit[adjList[q].get(j)]) {
						visit[adjList[q].get(j)]=true;
						queue.offer(adjList[q].get(j));
						answer++;
					}
				}
			}
			D++;
		}
		System.out.println(answer);
		
	}

}
