package week6;

import java.io.*;
import java.util.*;

public class BOJ_20115_S3_에너지드링크 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N =  Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순 정렬
		
		double sum = 0;
		for (int i = 0; i < N-1; i++) {
			sum += arr[i]/2.0; // 최댓값 제외하고 절반씩 더함
		}
		System.out.println((arr[N-1]+sum)); // 최댓값과 합침
	}
}
