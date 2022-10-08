package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_G5_뱀과사다리게임 {

	static int N, M, ans;
	static List<int[]> ladders = new ArrayList<>();
	static List<int[]> snakes = new ArrayList<>();
	static boolean[] visited = new boolean[101];
	static Queue<Integer> qloc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladders.add(new int[] {a,b});
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			snakes.add(new int[] {a,b});
		} //read

		qloc = new LinkedList<>();
		qloc.offer(1);
		
		go(1);
		
		System.out.println(ans);
		
	}
	
	private static void go(int count) {	// count : 주사위 굴린 횟수
		
		int n = qloc.size();
		for (int i = 0; i < n; i++) {
			int temp = qloc.poll();	// 현재 말 위치
			// 현재 말부터 주사위를 굴려 1부터 6까지 더한 후 큐에 넣음
			for (int j = 1; j <= 6 && temp+j < 101; j++) {
				if(!visited[temp+j]) {
					qloc.offer(temp+j);
				}
			}
		}
		
		n = qloc.size();
		for (int i = 0; i < n; i++) {
			int temp = qloc.poll();
			
			if(temp == 100) {
				ans = count;
				break;
			}
			
			if(visited[temp]) continue;	// 방문한 적이 있다면 패스
			visited[temp] = true;
			
			int check = check(temp);	// 사다리나 뱀이 있는지 확인
			if(check != -1) {
				visited[check] = true;
				temp = check;
			}
			
			qloc.offer(temp);
		}
		
		if(ans == 0)
			go(count+1);
	}

	private static int check(int temp) {
		
		// 사다리인지 검사
		int n = ladders.size();
		for (int i = 0; i < n; i++) {
			int to = ladders.get(i)[0];
			int from = ladders.get(i)[1];
			if(temp == to) {	// 사다리를 만났다면, 사다리를 타고 올라감
				return from;
			}
		}
		
		// 뱀인지 검사
		n = snakes.size();
		for (int i = 0; i < n; i++) {
			int to = snakes.get(i)[0];
			int from = snakes.get(i)[1];
			if(temp == to) {	// 뱀을 만났다면, 뱀을 타고 내려감
				return from;
			}
		}
		
		return -1;	// 사다리도 뱀도 안 만난 경우
	}

}
