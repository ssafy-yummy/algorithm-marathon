package week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {
	
	static int n;
	static int l;
	static int r;
	static int[][] map;
	static boolean[][] visited;
	static boolean t = false;
	static List<int[]> tmp;
	
	static int[][] diff = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
//		나라 배열의 크기 n
//		최소 차이값 l
//		최대 차이값 r
//		나라 map
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
//		맵을 받음
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		//몇번의 인구이동이 일어나는지를 저장하는 변수
		int count = 0;
		
		
		
		while(true) {
			
			
			//while 루프를 돌때마다 방문배열 초기화, 
			visited = new boolean[n][n];
			t = false;//모든 map을 방문하여 인구이동이 일어날 수 있는지 체크하는 변수
			tmp = new ArrayList<>();//인구이동이 가능한 지점과 인구 이동후 가지게 되는 평균인구값을 저장해놓는 리스트
			
			
			//한번 방문한 지역은 스킵하며 탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visited[i][j])
						continue;
					bfs(i,j);
				}
			}
			
			
			//탐색의 결과 단 한번의 인구이동도 발생하지 않는다면 while루프를 탈출
			if(!t)
				break;
			
			
			//인구이동이 발생했다면 tmp에서 하나씩 꺼내 map의 위치에 값을 저장.
//			tmp는 {i,j,v}의 형태로 row = i, col = j 인곳에 평균값 v를 넣기위해 저장
			for (int[] x : tmp) {
				map[x[0]][x[1]] = x[2];
			}
			
			//한번의 인구이동이 끝나면 count 숫자를 늘림
			count++;
			
		}
		
		System.out.println(count);
		
	}

	
	//순회하기 위한 메소드
	private static void bfs(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		
		
//		sums는 연결된 나라들의 총 인구수
//		cnt는 연결된 나라의 수
//		s는 tmp 순회를 마친 후, 추가된 나라들이 있다면, 그 추가된 나라들의 인덱스를 시작으로
//		값을 변경해야 하기 때문에 사전에 tmp.size()의 크기를 저장하여 시작인덱스를 구함
		
		
		int sums = 0;
		int cnt = 0;
		int s = tmp.size();
		
		
		
		while(!queue.isEmpty()) {
			
			//하나씩 빼서 tmp에 넣음.
			int[] cur = queue.poll();
			tmp.add(new int[] {cur[0], cur[1],0});
			sums += map[cur[0]][cur[1]];
			cnt++;
			
			for (int[] d : diff) {
				
				int nr = cur[0] + d[0];
				int nc = cur[1] + d[1];
				
				
				
				//다음위치를 찾고, 맵을 벗어나거나
				if(!check(nr,nc))
					continue;
				
				//두 구역의 인구수 차이가 r보다 크거나, l보다 작거나
				if(Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) < l ||
						Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) > r )
					continue;
				
				//이미 방문한 적이 있다면 스킵
				if(visited[nr][nc])
					continue;
				
				
				//그렇지 않다면 방문처리하고 queue에 삽입
				visited[nr][nc] = true;
				queue.offer(new int[] {nr,nc});
			}			
			
		}
		
		
		//모든 연합국가들의 평균인구수를 구하는 변수.
		int v = sums/cnt;
		
		for (int k = s; k < tmp.size(); k++) {
			tmp.get(k)[2] = v;
		}
		
		//만약 연합국가를 만들 수 없다면 flag 변수인 t의 값을 변경시키지 않고 탈출
		if(cnt == 1)
			return;
		
		//연합국가를 만들 수 있다면 t를 true로 바꾸고 탈출, 
		t = true;
		return;
	}

	//맵을 벗어나는지 확인하는 메소드
	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < n;
	}
		


}
