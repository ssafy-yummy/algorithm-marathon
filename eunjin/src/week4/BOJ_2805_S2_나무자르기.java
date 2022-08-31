package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_S2_나무자르기 {

	static int N, M, ans;
	static int trees[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		int max = 0;
		int min = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		// read
		
		// 1. 중간을 자르면서 길이를 비교함
		binary(min, max);
		
		System.out.println(ans);

	}
	private static void binary(int min, int max) {
		while(min<max) {
			int mid = (min+max)/2;
			long tot = 0;
			for(int i=0; i<N; i++) {
				if(trees[i]-mid > 0) {
					tot += trees[i]-mid;
				}
			}
			
			if(tot<M) {
				max = mid;
			} else {
				min = mid+1;
			}
		}
		
		ans = min-1;
	}
}
