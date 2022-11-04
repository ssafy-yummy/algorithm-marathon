package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_1405_미친로봇 {

	static int N, per[], go[][];
	static int dd[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visit[][];
	static double ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		per = new int[4];
		for (int i = 0; i < 4; i++) {
			per[i] = Integer.parseInt(st.nextToken());
		} //read
		
		// 1. 움직이기 시작
		go = new int[N][3];
		visit = new boolean[29][29];
		int r = 14; int c = 14;
		visit[r][c] = true;
		move(r, c, 0);
		
		System.out.println(ans);
	}

	private static void move(int row, int col, int cnt) {
		if(cnt==N) {
			// 2. 이동 확률 계산
			double dd = 1.0;
			for (int i = 0; i < N; i++) {
				dd *= (double)per[go[i][2]]/100.0;
			}
			ans += (double)dd;
			return;
		}
		for (int d = 0; d < 4; d++) {
			if(per[d]==0) continue;	// 0퍼센트인 경우는 pass
			int nr = row+dd[d][0];
			int nc = col+dd[d][1];
			if(visit[nr][nc]) continue;
			visit[nr][nc] = true;
			go[cnt][0] = nr;
			go[cnt][1] = nc;
			go[cnt][2] = d;
			move(nr, nc, cnt+1);
			visit[nr][nc] = false;
		}
	}

}
