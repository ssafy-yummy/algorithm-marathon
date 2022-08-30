package week4;

import java.io.*;
import java.util.*;

public class BOJ_2805_S2_나무자르기 {
	static int N,M,result;
	static long sum;
	static int max = Integer.MIN_VALUE;
	// 다 같은 높이의 나무가 들어올 경우, 중간값을 구해도 그 높이가 되기때문에
	// min 값을 0으로 초기화 해야한다.
	static int min = 0;
	static int[] arr;
	static int mid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무길이
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int j = 0; j < N; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[j]); // 제일 높은 나무 찾음
		} //입력끝
		
		// 이분탐색 (시간초과방지)
		while(min<=max) {
			mid = (max+min)/2; // 중간값
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(arr[i]>mid) sum+=arr[i]-mid;
			}
			if(sum>=M) {
				min = mid+1;
			}
			else{
				max = mid-1;
			}
		}
		System.out.println(max);
	}
}
