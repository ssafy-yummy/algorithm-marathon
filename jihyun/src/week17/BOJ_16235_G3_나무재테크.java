package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16235_G3_나무재테크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //땅 크기
		int m = Integer.parseInt(st.nextToken()); //나무 개수
		int k = Integer.parseInt(st.nextToken()); //몇년후
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		List<Integer>[][] trees = new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				trees[i][j] = new ArrayList<Integer>();
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			trees[x][y].add(t);
			
		}
		int[][] curFood = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				curFood[i][j] = 5;
			}
		}
		int[][] deadFood = new int[n][n];
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int c=0;c<k;c++) {
			//봄
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					trees[i][j].sort(Comparator.reverseOrder());
					for(int l=trees[i][j].size()-1;l>=0;l--) {
						if(curFood[i][j]>=trees[i][j].get(l)) {
							curFood[i][j]-=trees[i][j].get(l);
							trees[i][j].set(l,trees[i][j].get(l)+1);
						}
						else {
							deadFood[i][j]+=(int)(trees[i][j].get(l)/2);
							trees[i][j].remove(l);						
						}
					}
				}
			}
			
			//여름
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					curFood[i][j]+=deadFood[i][j];
					deadFood[i][j]=0;
				}
			}
			
			//가을
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int l=trees[i][j].size()-1;l>=0;l--) {
						if(trees[i][j].get(l)%5!=0)
							continue;
						for(int d=0;d<8;d++) {
							int nx = i+dx[d];
							int ny = j+dy[d];
							
							if(nx<0 || nx>=n || ny<0 || ny>=n)
								continue;
							
							trees[nx][ny].add(1);
						}
					}
					
				}
			}
			
			//겨울
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					curFood[i][j]+=a[i][j];
				}
			}
		}
		int answer = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				answer+=trees[i][j].size();
			}
		}
		System.out.println(answer);
	}
}
