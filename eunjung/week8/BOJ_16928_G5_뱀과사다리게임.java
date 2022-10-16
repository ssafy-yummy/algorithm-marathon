package week8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16928_G5_뱀과사다리게임 {
	static int N,M;
	static int min = Integer.MAX_VALUE;

	static int[] map, cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		M = scann.nextInt();

		map = new int[101];
		cnt = new int[101];
		visited = new boolean[101];
		
		// 사다리 입력받기
		for (int i = 0; i < N; i++) {
			int x = scann.nextInt();
			int y = scann.nextInt();
			map[x] = y;
		}
		
		// 뱀 입력받기
		for (int i = 0; i < M; i++) {
			int u = scann.nextInt();
			int v = scann.nextInt();
			map[u] = v;
		}
		
		move(1);
		System.out.println(min);
	}
	private static void move(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) {
				min = Math.min(min,cnt[cur]);
			}
			
			for (int i = 1; i <= 6; i++) {
				if(cur+i<=100 && !visited[cur+i]) {
					visited[cur+i] = true;
					if(map[cur+i]!=0) {
						if(!visited[map[cur+i]]) {
						q.offer(map[cur+i]);
						visited[map[cur+i]] = true;
						cnt[map[cur+i]] = cnt[cur]+1;
						}
					}
					else {
						q.offer(cur+i);
						cnt[cur+i] = cnt[cur]+1;
					}
				}
			}
			
		}
	}
}
