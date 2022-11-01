package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2503_D3_베스킨라빈스 {
	static int T,N,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			N= Integer.parseInt(br.readLine());
			result =-1;
			if(N%4 ==1)result=1;
			else result=0;
			
			System.out.println("#"+testcase + " "+result);
		}
	}

}
