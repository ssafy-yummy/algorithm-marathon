package week12;

import java.io.*;
import java.util.*;

public class BOJ_20546_S5_기적의매매법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int money = Integer.parseInt(st.nextToken());
		int[] arr = new int[14];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int total = money;
		for (int i = 0; i < arr.length; i++) {
			int cur = total/arr[i];
			if(cur>0) {
				cnt += cur;
				total -= cur*arr[i];
			}
		}
		int n1 = total+arr[13]*cnt;
		// 여기까지가 준현이
		
		cnt = 0;
		total = money;
		for (int i = 0; i < arr.length; i++) {
			if(i>=3) {
				int cur = total/arr[i];
				if(arr[i-3]<arr[i-2] && arr[i-2]<arr[i-1] && cnt!=0) {
					total = arr[i]*cnt;
					cnt = 0;
				}
				if (arr[i-3]>arr[i-2] && arr[i-2]>arr[i-1]) {
					cnt += cur;
					total -= cur*arr[i];
				}
			}
//			System.out.println(total+" "+cnt);
		}
		int n2 = total+arr[13]*cnt;
		// 여기까지가 성민이
		
		
		if(n1>n2) System.out.println("BNP");
		else if(n1<n2) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	}
}