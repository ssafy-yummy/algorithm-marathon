package hanmin.src.week10;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20207_S1_달력 {
	static int[][] map;
	static int[] arr;
	static int N;
	static int answer;

	static class point {
		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시작날이 작고 종료날이 큰 순으로 정렬
		PriorityQueue<point> pq = new PriorityQueue<>((point a, point b) -> {
			if (a.x != b.x)
				return Integer.compare(a.x, b.x);
			return Integer.compare(b.y, a.y);
		});
		N = Integer.parseInt(br.readLine());
		arr = new int[366];
		map = new int[366][1001];
		int s = 365, e = 1;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new point(a, b));
			if (a < s)
				s = a;
			if (b > e)
				e = b;
		}

		// start
		//pq에서 순서대로 꺼냄
		while (!pq.isEmpty()) {
			point now = pq.poll();
			int st = now.x;
			int ed = now.y;
			//크기만큼 공간이 있는지 체크
			for (int j = 0; j < 1000; ++j) {
				int flg = 1;
				for (int i = st; i < ed + 1; ++i) {
					if (map[i][j] != 0) {
						flg = 0;
						break;
					}
				}
				//공간이 있다면 추가
				if (flg == 1) {
					for (int i = st; i < ed + 1; ++i) {
						map[i][j] = 1;
						arr[i] = Math.max(arr[i], j + 1);
					}
					break;
				}
			}
		}

		int mx = 0;
		int pre = s;
		//연속된 날짜의 최대크기를 구해서 사각형의 크기 구함
		for (int i = s; i < e + 1; ++i) {
			if (arr[i] == 0) {
				answer += mx * (i - pre);
				mx = 0;
				pre = i + 1;
			} else {
				mx = Math.max(mx, arr[i]);
			}
		}
		answer += mx * (e + 1 - pre);
		// end

		// 출력
		System.out.println(answer);
	}
}
