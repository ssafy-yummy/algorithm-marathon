package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dis = new long[n-1];
		long[] price = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n-1;i++) {
			dis[i]=Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			price[i]=Long.parseLong(st.nextToken());
		}
		long min = Long.MAX_VALUE;
		long answer=0;
		for(int i=0;i<n-1;i++) {
			if(min>price[i]) { //지나가다가 가장 싼 가격을 만나면 앞으로 여기서 산다. 
				min=price[i];
			}
			answer+=min*dis[i];
		}
		System.out.println(answer);
		
	}

}
