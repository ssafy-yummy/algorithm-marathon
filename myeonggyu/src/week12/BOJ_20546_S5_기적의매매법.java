package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546_S5_기적의매매법 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cash = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = 14;
		int[] arr = new int[n];
		
		int jun = cash;
		int jCnt = 0;
		int sung = cash;
		int sCnt = 0;
		
		int state = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			//준현이
			while(jun-arr[i] >=0) {
				jun-= arr[i];
				jCnt++;
			}
			
			
			
			//성민이
			if(i >= 1) {
				
				
				if(state >= 0)
					if(arr[i] > arr[i-1])
						state++;
					else if(arr[i] == arr[i-1])
						state = 0;
					else
						state = -1;
				else{
					if(arr[i] > arr[i-1])
						state = 1;
					else if(arr[i] == arr[i-1])
						state = 0;
					else {
						state--;
					}
				}
			}
			//사야한다면
			if(state <= -3) {
				while(sung-arr[i] >=0) {
					sung-=arr[i];
					sCnt++;
				}
			}
			//팔아야하면
			else if(state >= 3) {
				while(sCnt != 0) {
					sung += arr[i];
					sCnt--;
				}
			}
		}
		
		int junTotal = jun+(jCnt*arr[n-1]);
		int sungTotal = sung+(sCnt*arr[n-1]);
		
//		System.out.println(junTotal +" " + sungTotal);
		
		if(junTotal == sungTotal)
			System.out.println("SAMESAME");
		else if(junTotal < sungTotal)
			System.out.println("TIMING");
		else
			System.out.println("BNP");
		
		
	}

}
