package boj;

import java.io.*;
import java.util.*;

public class BOJ_21608_G5_상어초등학교 {
	static int N, result;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer>[] l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		l = new ArrayList[N*N+1];
		
		for (int i = 1; i <= N*N; i++) {
			l[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 4; j++) {
				l[num].add(Integer.parseInt(st.nextToken()));
			} // 해당 학생의 좋아하는 학생들 정보를 인접리스트로 저장
			
			gosit(num);
		}
		
		score();
		System.out.println(result);
	}

	private static void gosit(int num) {
		int nearMax = -1;
		int emptyMax = -1;
		int ir = 0;
		int ic = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int nearLike = 0; // 근처에 좋아하는 학생일 경우
				int nearEmpty = 0; // 근처가 빈 칸일 경우
				
				if (map[i][j] != 0) continue; // 이미 자리가 차지되어 있을 경우
					
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d]; // 4방탐색
					if (!check(nr,nc)) continue;
					
					if (map[nr][nc] == 0) nearEmpty++; // 비어있을 경우
					else if (l[num].contains(map[nr][nc])) nearLike++; // 좋아하는 학생일 경우
				}
				// 좋아하는 학생의 수가 더 많을 경우
				if(nearMax < nearLike) {
					nearMax = nearLike; 
					emptyMax = nearEmpty;
					ir = i; ic = j; // 해당 인덱스 저장
				}
				// 좋아하는 학생이 같을 경우
				else if(nearMax == nearLike) {
					if(emptyMax > nearEmpty) continue;
					else if(emptyMax < nearEmpty) { // 빈 칸이 주변에 더 많을 경우
						emptyMax = nearEmpty;
						ir = i; ic = j; //  해당 인덱스 저장
					}
					else { // 빈 칸수도 같으면
						if(ir < i) continue;
						else if(ir > i) {
							ir = i; ic = j; // 행 비교
						}
						else { // 행도 같으면
							if(ic < j) continue;
							else if(ic > j) {
								ir = i; ic = j; // 열 비교
							}
						}
					}
				}
			}
		}
		map[ir][ic] = num; // 정해진 자리에 해당 학생 번호 넣어줌
	}
	
	private static void score() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (!check(nr,nc)) continue;
		
					if (l[map[i][j]].contains(map[nr][nc])) cnt++;
				}
				
				switch (cnt) {
				case 0: // 근처에 좋아하는 학생이 없을 경우
					result += 0;
					break;
				case 1: // 근처에 좋아하는 학생이 1명일 경우
					result += 1;
					break;
				case 2: // 근처에 좋아하는 학생이 2명일 경우
					result += 10;
					break;
				case 3: // 근처에 좋아하는 학생이 3명일 경우
					result += 100;
					break;
				case 4: // 근처에 좋아하는 학생이 4명일 경우
					result += 1000;
					break;
				}
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		return nr>=1 && nr<=N && nc>=1 && nc<=N ;
	}
}