package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class BOJ_2573_G4_빙산 {

	static int n;
	static int m;
	static int[][][] map;
	static ArrayList<Integer> glace;
	static int[][] diff = {{1,0},{0,1},{-1,0},{0,-1}};
	static int step;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		glace = new ArrayList<>();
		step = 0;
		count = 0;
		map = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j][1] = map[i][j][0];
				if(map[i][j][0] != 0)
					glace.add(i*m+j);
			}
		}

		
		while(true) {


			unfreeze();
			count++;

			if(glace.size() == 0) {
				count = 0;
				break;
			}
			if(!check_map())
				break;
		}
		
		System.out.println(count);
		
	}

	private static boolean check_map() {
		
		int v = glace.get(0);
		HashSet<Integer> set = new HashSet<>();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		set.add(v);
		
		while(!queue.isEmpty()) {
			
			v = queue.poll();
			int r = v/m;
			int c = v%m;
			
			for (int[] d : diff) {
				
				int nr = r + d[0];
				int nc = c + d[1];
				
				if(!check(nr,nc))
					continue;
				
				if(map[nr][nc][step] == 0)
					continue;
				
				int x = nr*m+nc;
				if(set.contains(x))
					continue;
				
				queue.offer(x);
				set.add(x);
				
			}
			
		}
		
		
		if(set.size() != glace.size())
			return false;
		else
			return true;
		
		
	}

	private static void unfreeze() {
		
		int next_step = (step+1)%2;
		int k = glace.size();
		for (int i = 0; i < k; i++) {
			
			int v = glace.get(i);
			int r = v/m;
			int c = v%m;
			
			int cnt = 0;
			for (int[] d : diff) {
				
				int nr = r+d[0];
				int nc = c+d[1];
				
				if(!check(nr,nc))
					continue;
				
				if(map[nr][nc][step] != 0)
					continue;
				
				cnt++;
				
			}
			
			map[r][c][next_step] = Math.max(map[r][c][step] - cnt,0);			
			
			
		}
		
		
		for (int i = 0; i < k; i++) {
			int v = glace.get(i);
			int r = v/m;
			int c = v%m;
			if(map[r][c][next_step] == 0) {
				map[r][c][step] = 0;
				glace.remove(i--);
				k--;
				continue;
			}
		}

		step = next_step;
		
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < m;
	}

	

}
