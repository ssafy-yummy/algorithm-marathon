package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_모의_2115_벌꿀채취 {

	static int N, M, C, map[][], maxMap[][], pick1[], pick2[], ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			// maxMap[][] : 최대로 채취할 수 있는 벌꿀의 양을 저장한다.
			maxMap = new int[N][N];
			go1();

			// pick1[] : 첫 번째 일꾼이 고른 벌통의 좌측 인덱스
			// pick2[] : 두 번째 일꾼이 고른 벌통의 좌측 인덱스
			pick1 = new int[2];
			pick2 = new int[2];
			ans = 0;
			go2();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static void go1() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N-M+1; c++) {	// 한 행에서 연속되도록 M개를 선택할 수 있으므로, (N-M)~(N-1)열 범위에 있는 벌통을 고른다.
				subset(r, c, 0, 0, 0);
			}
		}
	}

	private static void subset(int row, int col, int cnt, int tot, int c) {
		if(c > C) return;
		if(cnt==M) {
			maxMap[row][col] = Math.max(maxMap[row][col], tot);	// 최대로 채취할 수 있는 벌꿀 수
			return;
		}
		subset(row, col, cnt+1, tot, c);
		subset(row, col, cnt+1, tot+(map[row][col+cnt])*(map[row][col+cnt]), c+map[row][col+cnt]);
	}

	private static void go2() {
		// 두 명의 일꾼이 각각 하나의 벌통을 선택한다.
		// 먼저 한 일꾼이 벌통을 고르고, 그 다음으로 남은 공간에서 한 일꾼이 벌통을 선택하도록 한다.
		
		// 먼저 첫 번째 일꾼이 벌통을 고르는 경우이다.	=> pick1[r][c] : 첫 번째 일꾼이 고른 벌통의 좌측 인덱스
		for (int r = 0; r < N; r++) {
			pick1[0] = r;
			for (int c = 0; c < N-M+1; c++) {	// 한 행에서 연속되도록 M개를 선택할 수 있으므로, (N-M)~(N-1)열 범위에 있는 벌통을 고른다.
				pick1[1] = c;
				go3();	// 두 번째 일꾼이 벌통을 고른다.
			}
		}
	}

	private static void go3() {
		// 두 번째 일꾼이 벌통을 고르는 경우이다.	=> pick2[r][c] : 두 번째 일꾼이 고른 벌통의 좌측 인덱스
		pick2[0] = pick1[0];
		for (int c = pick1[1]+M; c < N-M+1; c++) {	// 첫 번째 일꾼과 같은 행에서 두 번째 일꾼이 벌통을 추출하는 경우
			pick2[1] = c;
			ans = Math.max(ans, maxMap[pick1[0]][pick1[1]]+maxMap[pick2[0]][pick2[1]]);
		}
		for (int r = pick1[0]+1; r < N; r++) {	// 첫 번째 일꾼과 다른 행에서 두 번째 일꾼이 벌통을 추출하는 경우
			pick2[0] = r;
			for (int c = 0; c < N-M+1; c++) {
				pick2[1] = c;
				ans = Math.max(ans, maxMap[pick1[0]][pick1[1]]+maxMap[pick2[0]][pick2[1]]);
			}
		}
	}
}

