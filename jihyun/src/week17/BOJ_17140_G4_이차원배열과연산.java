package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140_G4_이차원배열과연산 {
	static class Count {
		int key, value;

		public Count(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int curR = 3;
		int curC = 3;
		int answer = -1;

		for (int t = 0; t <= 100; t++) {
			if (map[r][c] == k) {
				answer = t;
				break;
			}
			if (curR >= curC) { // R연산 - 모든 행
				for (int i = 0; i < curR; i++) {
					Map<Integer, Integer> hashMap = new HashMap<>();
					for (int j = 0; j < curC; j++) {
						if(map[i][j]==0)
							continue;
						if (hashMap.containsKey(map[i][j])) {
							hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
						} 
						else {
							hashMap.put(map[i][j], 1);
						}
					}
					PriorityQueue<Count> pqueue = new PriorityQueue<>(new Comparator<Count>() {
						@Override
						public int compare(Count a, Count b) {
							if (a.value == b.value)
								return a.key - b.key;
							return a.value - b.value;
						}
					});
					hashMap.forEach((key, value) -> {
						pqueue.offer(new Count(key, value));
					});				
					
					for (int j = 0; j < curC; j++) {
						map[i][j] = 0;
					}
					
					curC = Math.max(curC, pqueue.size()*2);

					for (int j = 0; j < 100; j += 2) {
						Count count = pqueue.poll();
						map[i][j] = count.key;
						map[i][j + 1] = count.value;

						if (pqueue.isEmpty()) {
							break;
						}
					}

				}
			} else { // C연산 - 모든 열
				for (int j = 0; j < curC; j++) {
					Map<Integer, Integer> hashMap = new HashMap<>();
					for (int i = 0; i < curR; i++) {
						if(map[i][j]==0)
							continue;
						if (hashMap.containsKey(map[i][j])) {
							hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
						} 
						else {
							hashMap.put(map[i][j], 1);
						}
					}
					PriorityQueue<Count> pqueue = new PriorityQueue<>(new Comparator<Count>() {
						@Override
						public int compare(Count a, Count b) {
							if (a.value == b.value)
								return a.key - b.key;
							return a.value - b.value;
						}
					});
					hashMap.forEach((key, value) -> {
						pqueue.offer(new Count(key, value));
					});				
					
					for (int i = 0; i < curR; i++) {
						map[i][j] = 0;
					}
					
					curR = Math.max(curR, pqueue.size()*2);

					for (int i = 0; i < 100; i += 2) {
						Count count = pqueue.poll();
						map[i][j] = count.key;
						map[i+1][j] = count.value;

						if (pqueue.isEmpty()) {
							break;
						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}
