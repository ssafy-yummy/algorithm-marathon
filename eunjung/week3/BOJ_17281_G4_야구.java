package week3;

import java.util.*;

public class BOJ_17281_G4_야구 {
	static int N, max = 0;
	static int[] player = new int[10];
	static boolean[] visited = new boolean[10];
	static int[][] scoreT;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		
		scoreT = new int[N + 1][10];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				scoreT[i][j] = scann.nextInt(); // 이닝 별 각 선수 기록
			}
		}
		player[4] = 1; // 4번 선수가 1번 타자
		visited[4] = true;

		nextPerm(2); // 2번 타자부터 정하기
		System.out.println(max); // 최대 점수
	}

	private static void nextPerm(int turnnum) {
		// 타자번호 끝나면 (순열완성)
		if (turnnum == 10) {
			max = Math.max(max, calc());
			return;
		}
		for (int i = 1; i <= 9; i++) {
			// 뽑히지 않은 선수인 경우
			if (!visited[i]) {
				visited[i] = true;
				player[i] = turnnum; // 몇 번 타자인지 지정
				nextPerm(turnnum + 1);  
				visited[i] = false;
			}
		}
	}
	
	private static int calc() {
		int start = 1, sum = 0;
		
		for (int i = 1; i <= N; i++) {
			int[] hit = new int[5]; // 점수별 배열
			// 삼진아웃 전까지
			while (hit[0] < 3) {
				run(hit, scoreT[i][player[start]]);
				// 다 끝나면 다시 1로 만듦
				if (start == 9) start = 1; 
				else start++;
			}
			sum += hit[4]; // 각 이닝 결과값 저장
		}
		return sum;
	}
	// nun 이 그 타자선수가 
	private static void run(int[] hit, int num) {
		for (int n = 0; n < num; n++) {
			hit[4] += hit[3];
			hit[3] = hit[2];
			hit[2] = hit[1];
			hit[1] = 0;
		} // 그동안 있는 주자들 달리기
		hit[num]++; // 지금 친 타자 위치
	}
}