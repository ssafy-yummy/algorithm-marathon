package week8;

import java.util.Arrays;

public class PG_92342_LV2_양궁대회 {

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 })));
		System.out.println(Arrays.toString(s.solution(1, new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 })));
		System.out.println(Arrays.toString(s.solution(9, new int[] { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 })));
		System.out.println(Arrays.toString(s.solution(10, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 })));
	}

	static class Solution {

		static int diffMax;
		static int[] arr, ans;

		public int[] solution(int n, int[] info) {
			diffMax = 0;
			arr = new int[11];
			ans = new int[11];

			dfs(0, 0, n, info);

			if (diffMax == 0) {
				return new int[] { -1 };
			} else
				return ans;
		}

		private void dfs(int start, int cnt, int n, int[] info) {
			if (cnt == n) {

				int as = 0;
				int bs = 0;

				for (int i = 0; i < 11; i++) {
					if (info[i] == 0 && arr[i] == 0)
						continue;

					if (info[i] >= arr[i])
						as += 10 - i;
					else
						bs += 10 - i;
				}
				if (bs > as) {
					int diff = bs - as;
					if (diff > diffMax) {
						diffMax = diff;
						System.arraycopy(arr, 0, ans, 0, 11);
					} else if (diff == diffMax) {
						for (int i = 10; i >= 0; i--) {
							if (arr[i] > ans[i]) {
								System.arraycopy(arr, 0, ans, 0, 11);
								break;
							} else if (arr[i] < ans[i])
								break;
						}
					}
				}

				return;
			}

			// 라이언이 맞춘 횟수
			for (int i = start; i < 11; i++) {
				arr[i]++;
				dfs(i, cnt + 1, n, info);
				arr[i]--;
			}
		}
	}

}
