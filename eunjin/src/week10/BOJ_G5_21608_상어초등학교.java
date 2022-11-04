package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_21608_상어초등학교 {

	static class Student implements Comparable<Student>{
		int row, col, like, blank;

		public Student(int row, int col, int like, int blank) {
			super();
			this.row = row;
			this.col = col;
			this.like = like;
			this.blank = blank;
		}

		@Override
		public int compareTo(Student o) {
			if(this.like==o.like) {	// 인접한 칸에 좋아하는 학생 수가 많은 순
				if(this.blank==o.blank) {	// 인접한 칸에 빈칸이 많은 순
					if(this.row==o.row) {	// 해당 행 번호가 작은 순
						return this.col - o.col;	// 해당 열 번호가 작은 순
					} return this.row - o.row;
				} return o.blank - this.blank;
			} return o.like - this.like;
		}
	}
	static int N, students[][], map[][], ans;
	static List<Student> list;
	static int[][] likeArr;
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		students = new int[N*N][5];
		likeArr = new int[N*N+1][4];
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			students[i][0] = a;
			for (int j = 1; j < 5; j++) {
				int b = Integer.parseInt(st.nextToken());
				students[i][j] = b;		// input 데이터를 그대로 저장
				likeArr[a][j-1] = b;	// input 데이터의 0열을 인덱스로 한 배열을 저장
			}
		} //read
		
		map = new int[N][N];	// 교실
		for (int i = 0; i < N*N; i++) {
			list = new ArrayList<>();
			
			// 1. 탐색 시작
			find(i);
			
			// 2. list를 정렬한 후 나오는 첫 번째 자리에 해당 학생을 앉힘
			list.sort(null);
			map[list.get(0).row][list.get(0).col] = students[i][0];
		}
		
		// 3. 학생의 만족도 구하기
		count();
		
		System.out.println(ans);
	}

	private static void find(int idx) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] != 0) continue;	// 이미 자리에 앉은 학생이 있는 경우
				
				int cntLike = 0;
				int cntBlank = 0;
				// 4방 탐색
				for (int d = 0; d < 4; d++) {
					int nr = r+dd[d][0];
					int nc = c+dd[d][1];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					
					for (int i = 1; i < 5; i++) {
						if(map[nr][nc] == students[idx][i]) {	// 인접한 칸에 좋아하는 학생이 앉은 경우
							cntLike++;
							break;
						}
					}
					if(map[nr][nc] == 0) cntBlank++;	// 인접한 칸이 빈칸인 경우
				}
				
				list.add(new Student(r, c, cntLike, cntBlank));
			}
		}
	}

	private static void count() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;	// 인접한 칸에 앉은 좋아하는 학생의 수
				// 4방 탐색
				for (int d = 0; d < 4; d++) {
					int nr = r+dd[d][0];
					int nc = c+dd[d][1];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					
					for (int i = 0; i < 4; i++) {
						if(map[nr][nc] == likeArr[map[r][c]][i]) {
							cnt++;
							break;
						}
					}
				}
				
				// 만족도 계산
				if(cnt==0) continue;
				ans += Math.pow(10, cnt-1);
			}
		}
	}
}
