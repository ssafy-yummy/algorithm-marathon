import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_20922_S1_겹치는건싫어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		int N = Integer.parseInt(st.nextToken());	// 숫자 개수
		int K = Integer.parseInt(st.nextToken());	// 같은 것이 K개 이하
		int[] nums = new int[N];
		
		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		
		int s = 0;	// s : 배열 시작 인덱스
		int ans = 0;
		int[] cnt = new int[100001];
		
		// e : 배열 끝 인덱스
		for (int e = 0; e < N; e++) {
			
			// 배열에 숫자 n을 추가할 것임
			int n = nums[e];	
			
			// 숫자 n이 K개 이하라면
			if (cnt[n] < K)
				cnt[n]++;
			
			// 숫자 n이 이미 K개 있다면
			// 배열의 시작(s)을 배열에서 처음으로 n이 등장하는 곳 다음으로 이동시켜주기
			else {
				while (nums[s] != n)
					cnt[nums[s++]]--;
				s++;
			}
			
			ans = Math.max(ans, e - s + 1);
		}
		
		System.out.println(ans);
	}

}
