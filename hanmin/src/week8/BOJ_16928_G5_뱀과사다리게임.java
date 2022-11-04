package hanmin.src.week8;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16928_G5_뱀과사다리게임 {
	static int[] arr;
	static int[] visit;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[101];
		visit = new int[101];
		for (int i = 0; i < N; ++i) {
			int x, y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}
		for (int i = 0; i < M; ++i) {
			int x, y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}

		// start
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(visit, -1);
		q.offer(1);
		visit[1] = 0;
		//bfs로 갈 수 있는 위치 이동
		while (!q.isEmpty()) {
			int now = q.poll();
			//1부터 6까지 주사위만큼 이동
			for (int d = 1; d < 7; ++d) {
				int nx = now + d;
				if (nx > 100)
					continue;
				//사다리나 뱀이 있다면 이동
				if (arr[nx] != 0)
					nx = arr[nx];
				//방문한적있다면 컨티뉴
				if (visit[nx] != -1)
					continue;
				visit[nx] = visit[now] + 1;
				q.offer(nx);
				//도착
				if (nx == 100) {
					answer = visit[nx];
					break;
				}
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}
}
