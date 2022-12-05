package week18;

import java.io.*;
import java.util.*;

public class BOJ_2792_S2_보석상자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 아이들 수와 색상의 수를 입력받음 
		int[] arr = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 정
		
		
		int left = 1; // 최솟값으로 설정 
		int right = arr[M-1]; // 보석의 개수가 제일 많은 것이 최댓값으로 설정 
		int result = 0;
		
		while(left<=right){
			int cnt = 0;
			int mid = (left+right)/2; // 중간값 설정(이 값을 질투심의 최솟값이라고 가정) 
			for (int i = 0; i < M; i++) {
				cnt+=arr[i]/mid; // 설정한 값으로 각 종류의 보석의 개수들을 나눈몫을 더해줌 
				if(arr[i]%mid>0) cnt++; // 나머지가 있을 경우 cnt 증가 
			}
			
			// cnt의 값이 주어진 학생들의 수보다 많을 경우 = 설정한 질투심의 최솟값이 너무 작음 
			if(cnt>N) {
				left = mid+1; // 이분탐색으로 범위의 최솟값을 mid+1로 변경 
			}
			// cnt의 값이 주어진 학생들의 수보다 적거나 같을 경우 = 더 작은 질투심의 최솟값이 가능할 경우가 있을 수 있음 
			else { 
				right = mid-1; // 범위의 최댓값을 mid-1로 변경 
				result = mid; // 질투심의 최솟값 변경 
			}
		}
		
		System.out.println(result); // 질투심의 최솟값 출력 
	}
}
