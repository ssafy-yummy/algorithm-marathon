import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ_2805_S2_나무자르기 {
	
	static int[] tree;
	
	public static void main(String[] args) throws Exception{
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(st.nextToken());
		
		
		// 2. 풀이
		int ans = 0;
		
		// 이분탐색 알고리즘
		// 절단기가 설정할 수 있는 높이는 [0(l) ~ tree의 최댓값(r)] 구간 내에 있다.
		int l = 0;					
		int r = tree[0];
		for (int t : tree) 
			r = Math.max(r, t);
		int m = (l + r) / 2;
		
		while (l <= r) {
			if (getAmout(m) >= M) {		// 가져가야할 나무의 양은 정확히 M일 필요없다. M보다 크기만 하면 된다.
				ans = m;				// while 문을 반복할 수록 ans값은 최종 정답에 점점 가까워진다.
				l = m + 1;
			}
			else
				r = m - 1;				// m 값이 짧아야 더 많은 나무를 가져갈 수 있다.(반비례)

			m = (l + r) / 2;
		}
		
		
		// 3. 정답 출력
		System.out.println(ans);
	}
	
	
	// 높이가 h일 때, 가져갈 수 있는 나무의 양을 반환하는 메서드
	private static long getAmout(int h) {
		
		long ret = 0;
		for (int t : tree)
			if (t > h)
				ret += t - h;
		
		return ret;
	}
}
