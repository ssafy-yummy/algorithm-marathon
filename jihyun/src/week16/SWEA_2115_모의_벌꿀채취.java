package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_모의_벌꿀채취 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int m,c;
	static int[] person1;
	static int[] person2;
	static int p1,p2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int answer = -1;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //맵 크기
			m = Integer.parseInt(st.nextToken()); //채취할 칸 길이
			c = Integer.parseInt(st.nextToken()); //최대 채취 양
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Pos[] start = new Pos[n*(n-m+1)]; //가능한 시작점들
			int index = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-m+1;j++) {
					start[index++] = new Pos(i,j);
				}
			}
			person1 = new int[m];
			person2 = new int[m];
			for(int i=0;i<n*(n-m+1);i++) {
				for(int j=i+1;j<n*(n-m+1);j++) {
					if(start[i].x == start[j].x && start[i].y+m>start[j].y)
						continue;

					for(int k=0;k<m;k++) {
						person1[k] = map[start[i].x][start[i].y+k];
						person2[k] = map[start[j].x][start[j].y+k];
					}
					p1 = p2 = 0;
					
					subset();
					
					int result = p1+p2;
					answer = Math.max(answer, result);
					
					//System.out.printf("(%d,%d)=>%d (%d,%d)=>%d\n",start[i].x,start[i].y,p1,start[j].x,start[j].y,p2);
				}
			}
			
			System.out.printf("#%d %d\n",tc,answer);
		}
	}

	private static void subset() {
		for(int i=1;i<=m;i++) {
			dfs1(0,0,i,0,0);
			dfs2(0,0,i,0,0);
		}
	}

	private static void dfs1(int end, int start, int size, int honeySum, int honeyLimit) {
		if(end==size) {
			p1 = Math.max(p1, honeySum);
			return;
		}
		for(int i=start;i<m;i++) {
			if(honeyLimit+person1[i]<=c) {
				dfs1(end+1,i+1,size,honeySum+person1[i]*person1[i],honeyLimit+person1[i]);
			}
		}
		
	}
	private static void dfs2(int end, int start, int size, int honeySum, int honeyLimit) {
		if(end==size) {
			p2 = Math.max(p2, honeySum);
			return;
		}
		for(int i=start;i<m;i++) {
			if(honeyLimit+person2[i]<=c) {
				dfs2(end+1,i+1,size,honeySum+person2[i]*person2[i],honeyLimit+person2[i]);
			}
		}
		
	}


}
