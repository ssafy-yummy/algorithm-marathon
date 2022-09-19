package week3;

import java.util.*;

public class BOJ_14889_S2_스타트와링크 {
	static int N,R;
	static int[][] map;
	static int cnt, min = Integer.MAX_VALUE;
	static int gap;
	static int[] nums,nums2;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		R = N/2;
		map = new int[N][N];
		nums = new int[R];
		nums2 = new int[R]; // 두 개의 무리로 나눔
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scann.nextInt();
			}
		}
		ncr(0,0); // 조합
		System.out.println(min); // 차이 최솟값 출력
	}
	private static void ncr(int start, int cnt) {
		if(cnt == R) {
			int ccnt = 0, sum = 0, sum2 = 0;
			for (int i = 0; i < N; i++) {
				int flag = 0;
				for (int j: nums) {
					if(i==j) {
						flag = 1;
						break;
					}
				}
				// 절반 뽑힌 사람을 제외하고 나머지 절반은 따로 저장
				if(flag == 0) nums2[ccnt++]=i;
			}
			for (int i: nums) {
				for (int j: nums) {
					sum += map[i][j];
				}
			} // 그룹 1 능력치 합
			for (int i: nums2) {
				for (int j: nums2) {
					sum2 += map[i][j];
				}
			} // 그룹 2 능력치 합
			gap = Math.abs(sum-sum2); // 능력치 차이 계산
			min = Math.min(min, gap); // 최솟값
			
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = i;
			ncr(i+1, cnt+1);
			// nums[cnt] = 0;
		}
	}
}
