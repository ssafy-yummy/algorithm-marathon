package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_5567_S2_결혼식 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int friends: list.get(1)) {
			set.add(friends);
			for(int friend: list.get(friends)) {
				set.add(friend);
			}
		}
		
		set.remove(1);	// 상근이를 제외
		
		System.out.println(set.size());
	}
}
