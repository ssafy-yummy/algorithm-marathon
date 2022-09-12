package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] km = new int[N-1];
		int[] cost = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			km[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		} //read
		
		int temp = cost[0];
		long val = 0L;

		for(int i=0; i<N-1; i++) {
			val += (long)temp*(long)km[i];
			if(temp > cost[i+1])
				temp = cost[i+1];
		}
		System.out.println(val);
	}
}
