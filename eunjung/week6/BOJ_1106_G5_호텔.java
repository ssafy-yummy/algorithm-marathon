package week6;

import java.io.*;
import java.util.*;

public class BOJ_1106_G5_호텔 {
	static int C, N; 
	static int[] arr; 
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		C = scann.nextInt(); // 늘려야 하는 고객수
		N = scann.nextInt(); // 홍보할 수 있는 도시
		arr = new int[C+101]; // 적어도 늘려야 하는 고객수 + 홍보비용으로 얻을 수 있는 고객 최대 수
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		arr[0] = 0; 
		for(int i=0; i<N; i++){ 
			int cost = scann.nextInt(); // 홍보할 때 대는 비용
			int mer = scann.nextInt(); // 비용으로 얻을 수 있는 고객의 수
			
			for (int j = mer; j < C+101; j++) {
				int pv = arr[j-mer]; 
				if(pv != Integer.MAX_VALUE)
					arr[j] = Math.min(arr[j], cost+pv); 
			}
		} 
		
		
		int result = Integer.MAX_VALUE; 
		
		for(int i=C; i<C+101;i++){ 
			result = Math.min(result,arr[i]); // 최솟값 구함 
		} 
		System.out.println(result);
	}


}