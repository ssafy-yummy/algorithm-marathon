package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_20922_겹치는건싫어 {
	
	static int N, K, input[], nums[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} //read

		go();
		
		System.out.println(ans);
	}

	private static void go() {
		nums = new int[100001];	// 원소의 개수를 저장하는 배열
		int temp = 0;	// 수열의 길이를 측정하기 위해 필요한 변수
		
		for (int i = 0; i < N; i++) {
			int x = input[i];
			nums[x] ++;
			
			if(nums[x]>K) {	// 원소의 개수가 K개를 초과한 경우
				ans = Math.max(ans, i-temp);
				
				for (int j = temp; j < i; j++) {
					int y = input[j];
					nums[y] --;
					
					if(y==x) {
						temp = j+1;
						break;
					}
				}
			}
		}
		
		ans = Math.max(ans, N-temp);
		
	}
}
