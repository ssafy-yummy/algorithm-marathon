package algo0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {
	static int N,cities[],roads[];
	static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		cities= new int[N];
		roads= new int[N-1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			roads[i]= Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cities[i]= Integer.parseInt(st.nextToken());
		}
		
		long cur=cities[0];
		
		for (int i = 0; i < N-1; i++) {
			if(cur>cities[i]) {
				cur=cities[i];
			}
			result += cur*roads[i];
		}
		
		
		System.out.println(result);
		
	}

}
