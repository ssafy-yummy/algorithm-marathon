package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207_S1_달력 {
	static int N, result;
	static int[] visited = new int[365+1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());// 시작 및 종료 날짜 입력받음
			
			for (int j = S; j <= E; j++) {
				visited[j]++; // 일정에 포함될 경우 시작부터 종료일까지 증가
			}
		}
		
		int rcnt = 0;
		int cmax = 0;
		for (int i = 1; i <= 365; i++) {
			// 
			if(visited[i]==0) {
				result += rcnt*cmax; // 일정이 끊길 경우 결과값에 현재까지의 면적을 더해줌
				rcnt = 0;
				cmax = 0;
				continue;
			}
			rcnt++; // 일정이 연이어 있을 경우 날짜 카운트
			if(cmax < visited[i]) cmax = visited[i]; // 일정 수가 가장 많은 날짜의 일정 수 값으로 바꿔줌
		}
		
		result += rcnt*cmax; // 맨 마지막 날짜까지 일정이 있을 수 있으므로 더해줌
		System.out.println(result);
	}
}
