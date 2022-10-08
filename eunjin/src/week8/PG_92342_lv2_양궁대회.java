package week8;

import java.util.Arrays;

public class PG_92342_lv2_양궁대회 {

	static int ans[] = {-1};
	static int diff;
	
	public static void main(String[] args) {
		int n = 5;
		int[] info = new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		
		int[] lion = new int[11];
		// 1. lion이 n개의 화살을 쏴서 과녁을 맞추는 경우 -> 중복조합
		dfs(info, n, 0, 0, lion);

		System.out.println(Arrays.toString(ans));
	}

	private static void dfs(int[] info, int n, int start, int cnt, int[] lion) {
		if (cnt == n) {
			// 2. 어피치와 라이언의 점수를 계산
			score(info, lion);
			return;
		}
		for (int i = start; i < 11; i++) {
			lion[i]++;
			dfs(info, n, i, cnt + 1, lion);
			lion[i]--;
		}
	}

	private static void score(int[] info, int[] lion) {
		int as = 0;	// 어피치 점수 초기화
		int bs = 0;	// 라이언 점수 초기화
		
		for (int i = 0; i < 11; i++) {
			if(info[i]==lion[i] && lion[i]==0) continue;	// 둘 다 단 하나의 화살도 맞히지 못한 경우
			else if(lion[i] > info[i]) {	// 라이언이 어피치보다 더 많이 맞힌 경우
				bs += (10-i);
			} else {	// 어피치가 라이언보다 더 많이 맞췄거나 라이언과 동일하게 맞힌 경우
				as += (10-i);
			}
		}
		
		// 3. 라이언이 이긴 경우, 그 중에서도 점수 차이가 가장 큰 경우, 그 중에서도 낮은 점수를 더 많이 맞힌 경우
		if(bs-as > diff) {	// 라이언이 이긴 경우, 그 중에서도 점수 차이가 큰 경우
			diff = bs-as;
			ans = Arrays.copyOf(lion, 11);
			
		} else if(bs-as == diff && ans.length > 1) {	// 가장 낮은 점수를 더 많이 맞힌 경우
            for (int i = 10; i>=0; i--) {
				if(ans[i] < lion[i]) {	// 라이언이 낮은 점수를 더 많이 맞힌 경우
					ans = Arrays.copyOf(lion, 11);
					break;
				} else if(ans[i] > lion[i]) {	// 어피치가 낮은 점수를 더 많이 맞힌 경우
					break;
				}
			}
		}
	}
}
