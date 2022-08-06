package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	
	static int N,M;
	static int[] A;
	static int[] B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A= new int[N];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i]= Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		B= new int[M];
		st =new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i]= Integer.parseInt(st.nextToken());
		}//end of reading
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < M; i++) {
			int cnt=0;
			for (int j = 0; j <= N/2; j++) {
				if(B[i]==A[N-j-1]) {
					sb.append("1\n");
					break;
				}else if (B[i]==A[j]) {
					sb.append("1\n");
					break;
				}else {
					cnt ++;
				}
			}
			if(cnt==N/2+1) {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
		
		
	}


}
