package com.ssafy.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static int[][] graph;
	static int[] dfsArr;
	static int[] bfsArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		dfsArr = new int[N + 1];
		bfsArr = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[r][c] = 1;
			graph[c][r] = 1;
		}

		dfs(V);
		System.out.println();
		bfs(V);
	}

	static void dfs(int start) {
		dfsArr[start] = 1;
		System.out.print(start + " ");
		for (int e = 1; e < N + 1; e++) {
			if (graph[start][e] == 1 && dfsArr[e] == 0) {
				dfs(e);
			}
		}

	}
	

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		bfsArr[start] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			int s = q.poll();
			System.out.print(s + " ");

			for (int e = 1; e < N + 1; e++) {
				if (graph[s][e] == 1 && bfsArr[e] == 0) {
					bfsArr[e] = 1;
					q.offer(e);
				}

			}
		}
	}
}
