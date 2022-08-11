package week1;

import java.io.*;
import java.util.*;

public class BOJ_1920_S4_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mid = N/2; // 중간 index
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] result = new int[M];
        for (int i = 0; i < M; i++) {
        	int k = Integer.parseInt(st.nextToken());
            // 이분탐색을 실행하여 실행시간을 단축시킴
            if(k<=arr[mid]) {
            	for (int j = mid; j >=0; j--) {
					if(k==arr[j]) {
						result[i] = 1;
						break;
					}
				}
            } else {
            	for (int j = mid+1; j < N; j++) {
            		if(k==arr[j]) {
            			result[i] = 1;
						break;
					}
				}
            }
        }
        for(int i: result) {
        	System.out.println(i);
        }
    }
}