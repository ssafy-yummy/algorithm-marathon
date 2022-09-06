package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18352_S2_특정거리의도시찾기 {

	static int N, M, K, X;
	static int disArr[];
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 도시 개수
		M = Integer.parseInt(st.nextToken());	// 도로 개수
		K = Integer.parseInt(st.nextToken());	// 거리 정보
		X = Integer.parseInt(st.nextToken());	// 출발 도시 정보
		list = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		} //read
		
		disArr = new int[N+1];	// X로부터 각 노드까지의 거리 정보
		Arrays.fill(disArr, -1);
		
		disArr[X] = 0;	// 출발 도시 = 0
		dfs(X);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			if(disArr[i]==K)
				sb.append(i+"\n");
		}
		System.out.println(sb.toString().length()>0?sb.toString():-1);
	}
	
	private static void dfs(int node) {
		if(disArr[node]==K) return;
		for (int n : list.get(node)) {
			if(disArr[n] == -1 || disArr[node]+1<disArr[n]) {
				disArr[n] = disArr[node]+1;
				dfs(n);
			}
		}
	}
}
