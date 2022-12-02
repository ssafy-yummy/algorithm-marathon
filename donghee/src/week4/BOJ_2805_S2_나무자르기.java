package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_S2_나무자르기 {
	
	static int N,M,trees[],head= Integer.MIN_VALUE,cur,tail;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			head= Math.max(head, trees[i]);
		}//end of reading
		
//		System.out.println(Arrays.toString(trees));
//		System.out.println(maxH)
		
		while(tail<head) {
			int mid = (tail+head)/2;
			long sum = 0;
			for(int height : trees) {
				if(height>mid) {
					sum +=(height-mid);
				}
			}
			
			if(sum<M) {
				head = mid;
			}else {
				tail = mid+1;
			}
		}
		
		System.out.println(tail-1);
		
	}

}
