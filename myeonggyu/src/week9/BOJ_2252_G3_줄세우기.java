package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_G3_줄세우기 {
	
	
	//위상정렬을 위한 클래스. next는 해당 사람보다 뒤에 서야하는 사람들의 리스트, dept는 현재 사람보다 앞에서야하는 사람들의 숫자.
	static class Node{
		
		List<Integer> next;
		int dept;
		public Node(List<Integer> next, int dept) {
			super();
			this.next = next;
			this.dept = dept;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n  = 사람의 숫자, m = 줄 세우는 기준의 숫자.
//		p = 번호가 i인 사람의 상태정보를 저장하는 리스트 배열.
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		Node[] p = new Node[n+1];
		for (int i = 0; i < n+1; i++) {
			p[i] = new Node(new ArrayList<>(), 0);
		}
		
		
		//m번 순회하면서 상태정보를 저장. a가 b보다 앞에 서야 하므로 a의 next에 b를 추가하고, b의 dept를 1 늘림.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			p[a].next.add(b);
			p[b].dept++;
		}
		
		
		//모든 경로정보를 저장한 후에 root들을 찾아서 정렬.
//		dept==0인 사람들을 저장하고 하나씩 꺼내 탐색하기 위해 queue 선언
		Queue<Integer> queue = new LinkedList<>();
		
		
//		모든 사람들을 탐색하며 dept==0인, 즉 누군가에 뒤에 설 필요가 없는 사람들을 찾음, queue에 offer.
		
		for (int i = 1; i < n+1; i++) {
			if(p[i].dept ==0) {
				queue.offer(i);
			}
		}
		
		//결과값을 출력하기 위한 stringbuilder
		StringBuilder sb = new StringBuilder();
		
		//queue에서 root인 사람들을 하나씩 빼서 st에 저장. 
		for (int i : queue) {
			
			//만약 root의 next가 존재한다면 ,그 사람들을 que에 넣고 하나씩 빼면서 정렬해야 하기 때문에 새로운 que변수 선언.
//			que에 현재 root인 i를 넣음.
			Queue<Integer> que = new LinkedList<>();
			que.offer(i);
			
			while(!que.isEmpty()) {
				
				//bfs탐색이기 때문에 빼면서 결과값 저장. 
				int cur = que.poll();
				sb.append(cur+" ");
				
				
				//현재 사람보다 뒤에서야 하는 사람들. p[cur].next에서 하나씩 빼오며 탐색. 
//				빼온 사람이 누군가의 뒤에서야하는 제약조건이 2개 이상이라면, 아직 정렬대상이 아니므로 스킵.그대신 현재의
//				제약조건을 탐색했기 때문에 dept를 하나 줄임.
//				제약조건이 1개라면, dept==1 이라면 현재 탐색중인 cur의 제약조건뿐이므로 정렬대상으로 추가
				for (int x : p[cur].next) {
					if(p[x].dept == 1) {
						que.offer(x);
					}
					
					p[x].dept--;
				}
			}
			
			
			
		}
		
		
		System.out.println(sb.toString());
			
			
			
			
	}
		
}
