package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1079_G2_마피아 {
	static int answer = -1;
	static int n;
	static int[] point;
	static int mafia;
	static boolean[] dead;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		point = new int[n];
		dead = new boolean[n];
		for (int i = 0; i < n; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mafia = Integer.parseInt(br.readLine());


		dfs(0, n);

		System.out.println(answer);
	}

	private static void dfs(int nightCount, int liveCount) {
		//마피아 사망 or 마피아만 생존
		if(dead[mafia]==true || liveCount==1) {
			answer = Math.max(answer, nightCount);
			return;
		}
		
		if (liveCount%2 == 0) { // 현재 밤
			for (int i = 0; i < n; i++) {
				if (dead[i] == true || i == mafia) // 이미 사망자 or 나
					continue;				
				// 포인트 맵에 대한 값으로 갱신하고
				for (int j = 0; j < n; j++) {
					point[j] += map[i][j];
				}
				dead[i] = true; // 죽이고
				dfs(nightCount + 1, liveCount-1); // 다음날로
				// 포인트 맵에 대한 값으로 갱신하고
				for (int j = 0; j < n; j++) {
					point[j] -= map[i][j];
				}
				dead[i] = false; // 살리기
			}
		} else { // 현재 낮
			int maxValue = Integer.MIN_VALUE;
			int maxIndex = -1;
			// 포인트가 가장 높은 사람을 죽인다. 가장 높은 사람이 둘 이라면 순번이 먼저인 사람을 죽인다
			for (int i = 0; i < n; i++) {
				if (dead[i] == true)
					continue;
				if (point[i] > maxValue) {
					maxValue = point[i];
					maxIndex = i;
				}
			}

			dead[maxIndex] = true;
			dfs(nightCount, liveCount-1); // 다음날로
			dead[maxIndex] = false;
		}
	}
}
