package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_모의_2105_디저트카페 {

	static int N, map[][], ans;
	static int dd[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static boolean visited[][], ate[];	// visited: 방문한 카페, ate: 먹은 디저트 종류
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			ans = -1;
			
			// 시작점에서부터 시계방향으로 직사각형을 그릴 것이다.
			// map 배열의 인덱스는 0~(N-1) 내에서 최소한 벽에 부딪히지 않으려면,
			// 시작점의 열 번호는 1~(N-2) 범위에 있어야 하고
			// 시작점의 행 번호는 0~(N-3) 범위에 있어야 한다.
			for (int sr = 0; sr <= N-3; sr++) {
				for (int sc = 1; sc <= N-2; sc++) {
					visited = new boolean [N][N];
					ate = new boolean [101];	// 총 100가지 종류의 디저트가 있다.
					visited[sr][sc] = true;
					ate[map[sr][sc]] = true;
					dfs(1, sr, sc, sr, sc, 0);	// 1: 먹은 디저트 개수, 시작점(sr, sc) 좌표, 처음 시작 방향을 (0,1,2,3 중에서) 0으로 설정
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int cnt, int sr, int sc, int r, int c, int dir) {
		for (int d = 0; d < 2; d++) {
			if((cnt==1 || dir==3) && d==1) break;	// 맨 처음 cnt==1인 경우와 마지막 방향으로 이동할 경우에는 당시의 그 방향으로만 진행해야 한다.
			
			int nr = r+dd[dir+d][0];
			int nc = c+dd[dir+d][1];
			if(!check1(nr,nc)) continue;	// map 범위를 벗어난 경우
			if(cnt!=1 && nr==sr && nc==sc) {	// 시작점으로 돌아온 경우
				ans=Math.max(ans, cnt);
			}
			if(visited[nr][nc] || ate[map[nr][nc]]) continue;	// 이미 방문했거나 이미 디저트를 먹은 경우
			visited[nr][nc] = true;
			ate[map[nr][nc]] = true;
			dfs(cnt+1, sr, sc, nr, nc, dir+d);
			visited[nr][nc] = false;
			ate[map[nr][nc]] = false;
		}
	}

	private static boolean check1(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}