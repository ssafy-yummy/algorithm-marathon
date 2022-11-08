import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2564_S1_경비원 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());	// 가로 길이
		int H = Integer.parseInt(st.nextToken());	// 세로 길이
		int N = Integer.parseInt(br.readLine());	// 상점 개수
		
		List<int[]> pos = new ArrayList<>();
		
		// 위치
		int ty = 0;
		int tx = 0;
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			switch (dir) {
			case 1:	// 북
				ty = 0;
				tx = dis;
				break;
			case 2:	// 남
				ty = H;
				tx = dis;
				break;
			case 3:	// 서
				ty = dis;
				tx = 0;
				break;
			case 4:	// 동
				ty = dis;
				tx = W;
				break;
			}
			
			if (i < N)	// 상점의 위치
				pos.add(new int[] {ty, tx});
			
			// 최종적으로 (ty, tx)에는 동근이의 좌표가 저장됨
		}
		
		
		
		// 2. 문제 풀이
		int ans = 0;
		for (int[] cur : pos) {
			int y = cur[0];
			int x = cur[1];

			// 정 반대편에 있다면
			if (ty + y == H && ty * y == 0) 
				ans += H + Math.min(tx + x, W - tx + W - x);
			
			else if (tx + x == W && tx * x == 0) 
				ans += W + Math.min(ty + y, H - ty + H - y);
			
			// 그 밖의 모든 경우 -> 맨해튼 거리 구하면 됨
			else
				ans += Math.abs(y - ty) + Math.abs(x - tx);
			
		}
		
		
		// 3. 출력
		System.out.println(ans);
	}

}
