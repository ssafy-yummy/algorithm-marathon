package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546_S5_기적의매매법 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int jhMoney = money; //준현돈
		int jhJu = 0; //준현 보유주
		int smMoney = money; //성민돈		
		int smJu = 0; //성민 보유주
		int upCount = 0; //연속 상승 일수
		int downCount = 0; //연속 하락 일수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[14];
		for(int i=0;i<14;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<14;i++) {
			if(jhMoney>=arr[i]) { //가능한 주식 구매
				jhJu += (Integer)(jhMoney/arr[i]);
				jhMoney -= (Integer)(jhMoney/arr[i])*arr[i];
			}
		}
		int jhResult = jhMoney + jhJu*arr[13];
		for(int i=1;i<14;i++) {
			if(arr[i-1]<arr[i]) { //전날보다 상승
				upCount++;
				downCount = 0;
			}
			else if(arr[i-1]>arr[i]) { //전날보다 하락
				downCount++;
				upCount = 0;
			}
			else { //전날과 동일
				upCount = 0;
				downCount = 0;
			}
			
			if(upCount>=3) { //3일 이상 상승세
				smMoney += smJu * arr[i]; //주식 처분
				smJu = 0;
			}
			else if(downCount>=3) { //3일 이상 하락세
				smJu += (Integer) (smMoney/arr[i]); //주식 구매
				smMoney -= (Integer) (smMoney/arr[i])*arr[i];
			}
		}
		int smResult = smMoney + smJu*arr[13];
		
		if(jhResult>smResult)
			System.out.println("BNP");
		else if(jhResult<smResult)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");
		
	}

}
