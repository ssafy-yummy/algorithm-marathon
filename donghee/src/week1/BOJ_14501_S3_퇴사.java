package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class BOJ_14501_S3_퇴사 {
	
	static int N;
	static int[] pays;
	static int[] times;
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		pays= new int[N];
		times= new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			times[i]=a;
			pays[i]=b;
		} // end of reading
		
		for (int i = 0; i < N; i++) {
			if(max(i)>=max) {
				max=max(i);
			}
		}
		
		System.out.println(max);
		
	}

	private static int max(int cnt) {
		int sum=0;
		int count =0;
		for (int i = 0; i <N; i++) {
			if(count ==0 && times[i] <= N-i) {
				sum +=pays[i];
				count = times[i];
			}
			count --;
			
		}
		
		return sum;
	}

}
