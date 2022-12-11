package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20115_S3_에너지드링크 {
	
	static int N;
	static double[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr=  new double[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]= Double.parseDouble(st.nextToken());
		}//read of ending
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		for (int i = N-1; i >=1; i--) {
			arr[i-1]= arr[i]+arr[i-1]/2;
		}
		
		System.out.println(arr[0]);
	}

}
