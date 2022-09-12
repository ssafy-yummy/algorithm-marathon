package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구 {

	static int N, inNum, ans;

	static int[] nums, innings[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[10];
		innings = new int[N][10];
		visited = new boolean[10];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				innings[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 4번 타자 1번 선수로 고정
		visited[4] = true;
		nums[4] = 1;

		// 풀이
		perm(1);

		// 출력
		System.out.println(ans);
	}

	// 순열 함수
	private static void perm(int cnt) {

		if (cnt == 9) {
			// 9명 타순이 정해지면 게임 시작
			int score = playBall(nums);

			ans = Math.max(ans, score);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[i] = cnt + 1;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static int playBall(int[] nums) {
		int score = 0; // 점수
		int outCnt = 0; // out 횟수
		int hitter = 1; // 타자 번호

		// 3아웃을 확인하기 위한 flag
		boolean outFlag = false;
		// N 이닝 게임 진행
		for (int i = 0; i < N; i++) {

			// 베이스 초기화
			boolean[] base = new boolean[4];

			for (; hitter <= 9; hitter++) {
				int shot = innings[i][nums[hitter]]; // 정해진 타자 결과

				switch (shot) {
				// 아웃
				case 0:
					outCnt++;
					if (outCnt == 3) {
						outFlag = true;
					}
					break;

				// 안타를 치면 해당 자리는 true, 3루를 넘어가면 해당자리는 비었으므로 false, 그리고 score 증가
				// 1루타
				case 1:
					for (int k = 3; k > 0; k--) {
						if (base[k]) {
							base[k] = false;
							if (k >= 3) {
								score++;
								continue;
							}
							base[k + 1] = true;
						}
					}
					base[1] = true;
					break;

				// 2루타
				case 2:
					for (int k = 3; k > 0; k--) {
						if (base[k]) {
							base[k] = false;
							if (k >= 2) {
								score++;
								continue;
							}
							base[k + 2] = true;
						}
					}

					base[2] = true;
					break;

				// 3루타
				case 3:
					for (int k = 3; k > 0; k--) {
						if (base[k]) {
							base[k] = false;
							score++;
						}
					}
					base[3] = true;
					break;

				// 홈런
				case 4:
					score++;
					for (int k = 3; k > 0; k--) {
						if (base[k]) {
							base[k] = false;
							score++;
						}
					}
					break;
				}

				// 3아웃 되면 다음 이닝
				if (outFlag) {
					outCnt = 0;
					outFlag = false;
					// 다음 이닝에 가도 다음 타자가 진행한다
					if (hitter == 9) {
						// 9번이라면 1로 바꿔줘야 한다. 
						// 0 으로 해주지 않는 이유:
						// 밑에서 break 호출 후 이닝이 바뀌면서 for을 처음 시작하므로 직접 1로 해줘야된다. 
						hitter = 1;
					} else {
						hitter++;
					}
					break;
				}

				// 9회 까지 3out이 안나면 1번 타자부터 다시 진행한다.
				if (hitter == 9) {
					// for문을 돌 때 0에서 1로 증가되므로 0으로 바꿔준다.
					hitter = 0;
				}
			}
		}

		return score;
	}
}
