package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_S2_스타크와링크 {
	static int n;
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[n];
		dfs(0,0);
		
		System.out.println(answer);

	}

	private static void dfs(int size, int start) {
		if(size==n/2) {
			int[] a= new int[n/2]; //true팀 멤버
			int a_index=0;
			int[] b= new int[n/2]; //false팀 멤버
			int b_index=0;
			for(int i=0;i<n;i++) { //true와 false팀의 멤버 구성하기
				if(visit[i]==true) {
					a[a_index++]=i;
				}
				else {
					b[b_index++]=i;
				}
			}
			int a_sum=0, b_sum=0;
			for(int i=0;i<n/2;i++) { //능력치를 계산한다. 같은 멤버는 제외  ex) (1,1) (1,2) (2,1) (2,2)
				for(int j=0;j<n/2;j++) {
					a_sum+=map[a[i]][a[j]];
					b_sum+=map[b[i]][b[j]];
				}
			}
			answer = Math.min(answer, Math.abs(a_sum-b_sum));
		}
		for(int i=start;i<n;i++) { //조합을 만든다. 팀은 true팀과 false팀으로 나눈다.
			visit[i]=true;
			dfs(size+1, i+1);
			visit[i]=false;
		}
		
	}

}
