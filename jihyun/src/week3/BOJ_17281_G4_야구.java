package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구 {
	static int[] order;
	static boolean[] visit;
	static int n;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order = new int[9];
		order[3] = 0; //4번째는 1번째 선수가 무조건 친다. 
		visit = new boolean[9];
		visit[0] = true; //1번째 선수는 이미 선택되었다.
		select(0);

		System.out.println(answer);
	}

	private static void select(int end) {
		if (end == 9) { // 한번 순서가 정해지면 n이닝이 끝날때까지 안바뀐다.
			int score = play(); //경기 시작
			answer = Math.max(answer, score);
			return;
		}
		if (end == 3) { //4번째 자리는 이미 1번째 선수가 치기로 정했으므로 다음 자리로 넘긴다.
			select(end + 1);
			return;
		}
		for (int i = 0; i < 9; i++) { //선수들의 순열을 구한다.
			if (visit[i] == false) {
				visit[i] = true;
				order[end] = i;
				select(end + 1);
				visit[i] = false;
			}
		}

	}

	private static int play() {
		int score = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) { // n회의 이닝에 대해서
			/*
			 * 홈(시작) 00000
			 * 1루 00010
			 * 2루 00100
			 * 3루 01000
			 * 홈(완주) 10000
			 */
			int base = 0; 
			int goal = 1<<4;
			int out = 0; // 아웃 횟수
			while (out < 3) {
				int r = map[i][order[cur % 9]]; //0~4중 현재 타자의 실력

				if (r == 0) { //0일 경우 아웃
					out++;
				} 
				else { //1~4일 경우
					base=(base|1); //홈에 타자를 세운다.
					for(int j=0;j<r;j++) { //총 r번 이동하기
						base = base<<1; //모두 한 칸씩 이동
						if((base&goal)>0) //완주자 발생
							score++;
					}
				}
				cur++; //다음타자
			}

		}
		return score;
	}

}
