package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_16234_인구이동 {

	static class Country {
		int row, col, people;
		
		public Country(int row, int col, int people) {
			super();
			this.row = row;
			this.col = col;
			this.people = people;
		}
	}
	static int N, L, R, count, ans;
	static int map[][];
	static ArrayList<Country> list;
	static boolean visit[][];
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		ans = -1;	// 인구 이동 횟수 (마지막 출력값)
		do {
			count = 0;	// 인구 이동을 할 나라 수
			
			// 1. 국경선을 공유하는 두 나라의 인구 차이를 비교한다.
			check();
			
			ans++;
		} while (count!=0);	// 인구 이동을 할 나라가 0개라면 while문 종료
		
		System.out.println(ans);
	}

	private static void check() {
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j]) continue;	// 이미 방문했다면 pass
				list = new ArrayList<>();	// 국경선을 열어 공유하는 나라들을 추가하기 위한 리스트 초기화
				check2(i,j);	// 2. 해당 위치의 4방을 탐색하러 감
				
				if(list.size()==1) continue;	// 국경선을 공유하는 나라가 아니라면 pass
				
				// 3. 인구 이동 시작
				count++;
				int n = list.size();
				int sum = 0;
				for (int k = 0; k < n; k++) {	// 총합 인구 수
					sum += list.get(k).people;
				}
				for (int k = 0; k < n; k++) {
					map[list.get(k).row][list.get(k).col] = sum/n;	// 평균 인구 수 (인구이동)
				}
			}
		}
		
		return;
	}

	private static void check2(int r, int c) {
		visit[r][c] = true;
		list.add(new Country(r,c,map[r][c]));	// 국경선을 공유할 나라를 리스트에 추가함
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dd[d][0];
			int nc = c+dd[d][1];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;	// 범위 밖이라면 pass
			if(visit[nr][nc]) continue;	// 이미 방문했다면 pass
			if(Math.abs(map[r][c]-map[nr][nc])>=L && Math.abs(map[r][c]-map[nr][nc])<=R)
				check2(nr,nc);	// 두 나라의 인구 차이가 L 이상 R 이하라면 check2 메소드 수행
		}
	}

}
