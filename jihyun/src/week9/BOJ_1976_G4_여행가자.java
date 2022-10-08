package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_G4_여행가자 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n]; //n개의 도시 길
		
		parents = new int[n]; //도시의 부모 
		for(int i=0;i<n;i++) {
			parents[i]=i;
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					union(i,j); //union find
			}
		}
		int[] order = new int[m]; //m개의 도시의 순서 계획
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<m;i++) {
			order[i]=Integer.parseInt(st.nextToken())-1;
		}
		for(int i=1;i<m;i++) {
			if(parents[order[0]]!=parents[order[i]]) { //계획의 모든 도시들끼 연결되어있지 않다.
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}

	private static void union(int a, int b) {
		int aRoot = find(a); //도시1의 부모
		int bRoot = find(b); //도시2의 부모
		
		if(aRoot == bRoot) { //도시 1과 2는 이미 합쳐져있다.
			return;
		}
		
		if(aRoot>bRoot) //도시 1과 2를 합친다
			parents[aRoot] = bRoot;
		else
			parents[bRoot] = aRoot;
		
	}

	private static int find(int a) {
		if(parents[a]==a) //도시의 root index를 찾는다
			return a;
		else
			return parents[a]=find(parents[a]);
	}

}
