package hanmin.src.week10;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21608_G5_상어초등학교 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int[][] student;
	static int N;
	static int answer;
	static int[] ans = { 0, 1, 10, 100, 1000 };
	static Set<Integer>[] s;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 학생들의 정보 배열
		student = new int[N * N + 1][5];
		// 학생들의 앉은 자리
		map = new int[N][N];
		// 주위에 친한 친구가 있는지 확인할 HashSet
		s = new Set[N * N + 1];
		for (int i = 0; i < N * N + 1; ++i)
			s[i] = new HashSet<>();
		for (int i = 0; i < N * N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
			student[i][2] = Integer.parseInt(st.nextToken());
			student[i][3] = Integer.parseInt(st.nextToken());
			student[i][4] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < 5; ++j)
				s[student[i][0]].add(student[i][j]);
		}

		// start
		// 학생 순서대로 시작
		for (int i = 0; i < N * N; ++i) {
			func(student[i][0]);
		}
		// 학생의 만족도 계산
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int now = map[i][j];
				int cnt = 0;
				for (int dir = 0; dir < 4; ++dir) {
					int nx = j + dx[dir];
					int ny = i + dy[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (s[now].contains(map[ny][nx])) {
						cnt++;
					}
				}
				answer += ans[cnt];
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int idx) {
		Queue<Point> q = new LinkedList<>();

		// 친한친구 최대 갯수
		int mxFriendCnt = -1;
		// 빈칸 최대 갯수
		int mxBlankCnt = -1;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				// 자리가 차있다면 컨티뉴
				if (map[i][j] != 0)
					continue;
				// 친한친구 카운트
				int friendCnt = 0;
				// 비어있는칸 카운트
				int blankCnt = 0;
				// 사방을 탐색하며 친한친구와 빈칸 카운트
				for (int dir = 0; dir < 4; ++dir) {
					int nx = j + dx[dir];
					int ny = i + dy[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (map[ny][nx] == 0) {
						blankCnt++;
						continue;
					}
					if (s[idx].contains(map[ny][nx])) {
						friendCnt++;
					}
				}
				// queue에 첫번째 값에 조건에 맞는 자리가 놓임
				if (mxFriendCnt <= friendCnt) {
					// 조건2 좋아하는 학생이 같고 비어있는 칸이 많으면
					if (mxFriendCnt == friendCnt && mxBlankCnt < blankCnt) {
						mxBlankCnt = blankCnt;
						q.clear();
					}
					// 조건1 좋아하는 학생이 많으면
					if (mxFriendCnt < friendCnt) {
						mxFriendCnt = friendCnt;
						mxBlankCnt = blankCnt;
						q.clear();
					}

					q.offer(new Point(j, i));
				}
			}
		}
		// queue의 첫번째 값으로 자리선정
		Point loc = q.poll();
		map[loc.y][loc.x] = idx;
	}
}
