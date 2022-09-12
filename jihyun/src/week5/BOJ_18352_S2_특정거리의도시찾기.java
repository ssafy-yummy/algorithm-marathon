package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_S2_특정거리의도시찾기 {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		
		List<Integer>[] adjList = new ArrayList[N];
		for(int i=0;i<N;i++) {
			adjList[i] = new ArrayList<>();
		}		
		for(int i=0;i<M;i++) { //인접리스트에서 도시에 대한 정보를 저장한다.
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjList[from].add(to);
		}
		Queue<Integer> queue = new LinkedList<>(); //최단거리를 구하기 위해 BFS 사용
		int D = 1;
		boolean[] visit = new boolean[N];
		queue.offer(X); //출발지 등록
		visit[X]=true;
	
		while(!queue.isEmpty() && D<=K) {
			int size = queue.size(); //거리 D에 해당하는 도시들만 관리하기 위함.
			for(int i=0;i<size;i++) {
				int q = queue.poll();
				
				for(int j=0;j<adjList[q].size();j++) { //지금까지 방문하지 않았던도시, 즉 최단거리를 만족하는 도시들임.
					if(!visit[adjList[q].get(j)]) {
						visit[adjList[q].get(j)]=true;
						queue.offer(adjList[q].get(j));
					}
				}
			}
			D++;
		}

		if(queue.isEmpty()) //거리 K에 해당하는 도시가 없다.
			System.out.println(-1);
		else { //거리 K에 해당하는 도시가 존재 할 경우
			int[] arr=  new int[queue.size()]; //오름차순으로 정렬하여 출력한다.
			int i =0;
			while(!queue.isEmpty())
				arr[i++]=queue.poll()+1;
			Arrays.sort(arr);
			for(i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
			
		}

	}

}