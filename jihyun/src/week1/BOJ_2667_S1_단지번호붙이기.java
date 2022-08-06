package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_S1_단지번호붙이기 {
	static List<Integer> list = new ArrayList<>();
	static int[][] arr;
	static int n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		List<Integer> answer = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					Queue<Pos> pos = new LinkedList<>();
					pos.offer(new Pos(i,j));
					arr[i][j]=0;
					int cnt=1;
					while(!pos.isEmpty()) {
						Pos p = pos.poll();
						int x = p.x;
						int y = p.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx<0 || nx>=n || ny<0 || ny>=n)
								continue;
							if(arr[nx][ny]==1) {
								pos.offer(new Pos(nx,ny));
								arr[nx][ny]=0;
								cnt++;
							}
						}
					}
					answer.add(cnt);
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for(Integer x : answer)
			System.out.println(x);
	}



}