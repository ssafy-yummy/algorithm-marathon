package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2116_주사위쌓기 {

	static int N, map[][], maxV, ans;
	static int pair[] = {5, 3, 4, 1, 2, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		// 1. 첫 번째 주사위의 여섯 면이 바닥에 오는 경우를 구함
		for (int i = 0; i < 6; i++) {
			// 2. 옆 면의 합이 최대가 될 수 있는 경우 : 6 * N(주사위 개수)
			// 처음에 최댓값을 maxV에 넣고, 옆 면에 최댓값인 6이 올 수 없다면 maxV 변수에 그 차이를 뺄 예정이다.
			maxV = 6*N;
			
			int bottom = map[0][i];		// 첫 번째 주사위 아랫면의 숫자
			int top = map[0][pair[i]];	// 첫 번째 주사위 윗면의 숫자
			
			go(1, bottom, top);
			
			// 5. maxV값 중에 최댓값을 ans에 저장한다.
			ans = Math.max(ans, maxV);
		}
		
		System.out.println(ans);
	}

	private static void go(int idx, int bottom, int top) {
		// 3. 주사위의 개수만큼 윗면과 아랫면을 검사한다.
		// 윗면과 아랫면 중에 6이 없다면, 옆 면의 최댓값 = 6
		// 윗면과 아랫면 중에 6이 있고 5가 없다면, 옆 면의 최댓값 = 5
		// 윗면과 아랫면에 5와 6이 있다면, 옆 면의 최댓값 = 4
		if((top==5 && bottom==6) || (top==6 && bottom==5)) maxV -= 2;	// 옆 면의 최댓값이 4인 경우
		else if(top==6 || bottom==6) maxV -= 1;	// 옆 면의 최댓값이 5인 경우
		
		// 4. 다음 주사위를 검사한다.
		if(idx==N) return;
		for (int i = 0; i < 6; i++) {
			// 현재 주사위의 윗 면에 적힌 숫자가 다음 주사위의 바닥이 된다.
			if(map[idx][i] == top) {
				int next = map[idx][pair[i]];
				go(idx+1, top, next);
				break;
			}
		}
	}
}
