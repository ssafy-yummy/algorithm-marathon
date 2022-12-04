package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_S1_연산자끼워넣기 {

	static int N,arr[],min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	static int[] opp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		opp = new int[N-1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		int tmp =0;
		for (int i = 0; i < 4; i++) {
			int oppCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < oppCnt; j++) {
				if(i==0)opp[tmp++] = 1;
				else if(i==1)opp[tmp ++] = 2; 
				else if(i==2)opp[tmp ++] = 3; 
				else if(i==3)opp[tmp ++] = 4; 
			}
		}//end of reading
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(opp));
//		System.out.println("----------------------------------");
//		
		do {
			go();
		}while(np(opp.length-1));
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	//연산시작
	private static void go() {
		int sum = arr[0];
		for (int i = 0; i < opp.length; i++) {
			if(opp[i] == 1)sum +=arr[i+1];
			else if(opp[i]==2) sum -= arr[i+1];
			else if(opp[i]==3) sum *= arr[i+1];
			else if(opp[i]==4) sum /= arr[i+1];
		}
		
		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}
	
	//next permutation
	private static boolean np(int size) {
		int i = size;
		while(i>0 && opp[i-1]>=opp[i])i--;
		if(i==0)return false;
		int j = size;
		while(opp[i-1]>=opp[j])j--;
		
		int temp = opp[i-1];
		opp[i-1] = opp[j];
		opp[j] = temp;
		
		int k = size;
		while(i<k) {
			temp = opp[i];
			opp[i] = opp [k];
			opp[k]= temp;
			
			i++;
			k--;
		}
		
		return true;
	}

}
