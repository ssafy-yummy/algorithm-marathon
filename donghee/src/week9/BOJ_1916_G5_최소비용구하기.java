package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {
	
	
	static int N,M,map[][],start,end,d[];
	static boolean[] visited;
	static int inf = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		M= Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		d= new int[N];
		visited= new boolean[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], inf);
			map[i][i]=0;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken())-1;
			int c= Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			if(d<map[r][c]) {
				map[r][c]=d;
			}
		}
		
//		for(int[]m:map) {
//			System.out.println(Arrays.toString(m));
//		}
		StringTokenizer st= new StringTokenizer(br.readLine());
		start= Integer.parseInt(st.nextToken())-1;
		
		end= Integer.parseInt(st.nextToken())-1;
		
		dijkstra(start);
		System.out.println(d[end]);
	}
	
	private static int getSmallIndex() {
		int min = inf;
		int index = 0;
		for (int i = 0; i < N; i++) {
			if(d[i]<min && !visited[i]) {
				min=d[i];
				index= i;
			}
		}
		return index; 
	}
	
	private static void dijkstra(int start) {
		for (int i = 0; i < N; i++) {
			d[i]= map[start][i];
		}
		visited[start]=true;
		for (int i = 0; i < N-2; i++) {
			int current = getSmallIndex();
			visited[current]=true;
			
			for (int j = 0; j < N; j++) {
				if(!visited[j]) {
					if(d[current]+ map[current][j] <d[j]) {
						d[j]=d[current]+ map[current][j];
					}
				}
			}
		}
	}

}
