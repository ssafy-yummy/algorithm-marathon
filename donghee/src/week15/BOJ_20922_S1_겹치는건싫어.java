package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BOJ_20922_S1_겹치는건싫어 {
	
	static int N,K,tail,head,result=Integer.MIN_VALUE;
	static int[] nums,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		nums =new int[N];
		cnt = new int[100001];
		st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i]= Integer.parseInt(st.nextToken());
		}// end of reading
		
		while(head !=N) {
			if(N-tail<result)break;
			cnt[nums[head]]++;
			if(cnt[nums[head]]>K) {
				for (int i = tail; i < N; i++) {
					cnt[nums[i]]--;
					if(nums[i]==nums[head]) {
						tail = i+1;
						break;
					}
				}
			}
			head++;
			result = Math.max(result, head-tail);
		}
		
		System.out.println(result);
		
	}

}
