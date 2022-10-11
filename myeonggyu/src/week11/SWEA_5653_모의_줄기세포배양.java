package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_모의_줄기세포배양 {
	
	
	static int n;
	static int m;
	static int k;
	static HashMap<Integer, int[]> cells;
	static HashMap<Integer, Integer> spreadCells;
	static HashSet<Integer> deadCell;
	
	static int row;
	static int col;
	
	static int[][] diff = {{0,1},{1,0},{-1,0},{0,-1}};
	

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			cells = new HashMap<>();
			spreadCells = new HashMap<>();
			deadCell = new HashSet<>();
			
			row = 351;
			col = 351;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					
					int v = Integer.parseInt(st.nextToken());
					if(v==0)
						continue;
					cells.put((150+i)*351+(j+150), new int[] {v,v});
				}
			}
			
			for (int nn = 0; nn < k; nn++) {
				
				activate();
				spread();
//				System.out.println(cells.size());
				
				
			}
			System.out.println("#" + t + " " + cells.size());
			
		}
		
	}

	private static void spread() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		for (Integer key : cells.keySet()) {
			
			int[] v = cells.get(key);
			
			//만약 활성화 된 셀이라면 퍼트리고 죽여
			if(v[1] == -1) {
				
				int r = key/col;
				int c = key%col;
				
				for (int[] d: diff) {
					
					int nr = r + d[0];
					int nc = c + d[1];
					int nkey = nr*col + nc;
					
					//죽은셀이면 컨티뉴
					if(deadCell.contains(nkey))
						continue;
					
					//이미 들어있는 셀이면 컨티뉴
					if(cells.containsKey(nkey))
						continue;
					
					//이번턴에 퍼진셀과 겹치면
					if(spreadCells.containsKey(nkey)) {
						//그 퍼진 셀이 지금 퍼질 셀보다 크면 컨티뉴
						if(spreadCells.get(nkey) > v[0])
							continue;
						
							
					}
					
					//죽은셀 아니고 이미 배치된 셀 아니거나 이번턴에 퍼진 셀보다 지금 셀이 더 크면 업데이트
					spreadCells.put(nkey, v[0]);
					
				}
				
				
				
				
			}
			
			if(v[1]*-1 == v[0]) {
				deadCell.add(key);
				queue.offer(key);					
			}
			
		}
		
		for (Integer key : queue) {
			cells.remove(key);
		}
		
		for (Integer key : spreadCells.keySet()) {
			cells.put(key, new int[] {spreadCells.get(key),spreadCells.get(key)});
		}
		
		spreadCells = new HashMap<>();
		
	}

	private static void activate() {
		
		int i = 0;
		for (Integer key : cells.keySet()) {
			
			cells.get(key)[1] -= 1;
		}
	}

}
