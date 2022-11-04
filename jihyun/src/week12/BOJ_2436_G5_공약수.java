package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2436_G5_공약수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = b/a;
		int answer = Integer.MAX_VALUE;
		int answer_c=-1;
		int answer_d=-1;
		
		for(int i=1;i<=Math.sqrt(n);i++) { //약수 구하기
			if(n%i==0) {
				int c = i; //약수1
				int d = n/i; //약수2
				
				if(check(c,d)) //서로소가 아니라면
					continue;
				
				c*=a; //최대공약수 구해주기 
				d*=a;
				
				if(c+d<answer) { //합이 작은 쌍을 답으로 한다
					answer = c+d;
					answer_c = c;
					answer_d = d;
				}
				
			}
		}
		System.out.println(answer_c+" "+answer_d);
		
	}

	private static boolean check(int c, int d) { //최대공약수 구하기
		int n;
		
		while(c!=0) { //유클리드 호제
			n = d%c;
			d = c;
			c = n;
		}
		if(d==1) //최대공약수가 1이라면 서로소 이다
			return false;
		return true; 
		
	}

}