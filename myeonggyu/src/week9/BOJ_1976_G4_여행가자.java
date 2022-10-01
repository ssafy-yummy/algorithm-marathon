package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자 {
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		
		//n = 맵의 크기
		//m = 여행할 도시들의 갯수
		//map = n개의 줄로 받아올 map데이터. 인접행렬이 아닌 인접리스트를 사용해야함.
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		List<Integer>[] map = new ArrayList[n+1];
		
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new ArrayList<>();
			for (int j = 1; j < n+1; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v==0)
					continue;
				map[i].add(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		
		//첫 도시를 시작지점으로 저장하고, m-1번 순회하면서 다음도시를 next로 저장. 다음도시까지의 path가 있다면 다음도시를 root로 저장하고 다시 순회.
		int root = Integer.parseInt(st.nextToken());
		for (int i = 1; i < m; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			//만약 다음도시로 가는 길이 없다면 no를 출력하고 main함수를 종료
			if(!check(root,next,map)) {
				System.out.println("NO");
				return;
			}
			
			root = next;
		}
		
		//모든 경로탐색 과정동안 main함수가 종료되지 않았다면, 여행경로대로 여행하는것이 가능한 것이므로 yes를 출력
		System.out.println("YES");
		
		
	}

	private static boolean check(int root, int next, List<Integer>[] map) {
		
		
		//경로가 있는지를 탐색하기때문에 최소step탐색에 유리한 bfs가 아닌, 경로의 존재여부를 판별하는데 유리한 dfs를 사용함.
		Stack<Integer> stack = new Stack<>();
		stack.add(root);
		boolean[] visited = new boolean[n+1];
		
		while(!stack.isEmpty()) {
			
			int cur = stack.pop();
			if(cur == next)
				return true;
			visited[cur] = true;
			
			for (int i : map[cur]) {
				
				if(i == next)
					return true;
				
				if(visited[i])
					continue;
				
				stack.push(i);
			}
			
		}
		
		return false;
		
		
		
	}

}
