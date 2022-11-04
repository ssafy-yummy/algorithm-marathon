package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546_S5_기적의매매법 {
	
	static int money,money2,stocks[],cnt,cnt2;
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		money=money2 =Integer.parseInt(br.readLine());
		stocks = new int [14];
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 14; i++) {
			stocks[i]= Integer.parseInt(st.nextToken());
		}// end of reading
		
		bnp();
		int bnp = cnt*stocks[13]+ money;
		timing();
		int timing = cnt2*stocks[13]+ money2;
		result = bnp >timing? "BNP": bnp==timing?"SAMESAME" : "TIMING";
		System.out.println(result);
	}
	private static void timing() {
		for (int i = 3; i < stocks.length; i++) {
			//전량매수(3일연속 떨어졌을 때)
			if( money2>= stocks[i] && stocks[i]<stocks[i-1] && stocks[i-1]<stocks[i-2] && stocks[i-2]<stocks[i-3]  ) {
				int stockCnt = money2/stocks[i];
				money2 -= stockCnt*stocks[i];
				cnt2 +=stockCnt;
			}
			
			//전량 매도(3일연속 상승했을 때)
			if( money2>= stocks[i] && stocks[i]>stocks[i-1] && stocks[i-1]>stocks[i-2] && stocks[i-2]>stocks[i-3]  ) {
				money2 += cnt2*stocks[i];
				cnt2=0;
			}
		}
	}
	private static void bnp() {
		for (int i = 0; i < stocks.length; i++) {
			if(money>= stocks[i]) {
				int stockCnt = money/stocks[i];
				money -= stockCnt*stocks[i];
				cnt += stockCnt;
			}
		}
	}

}
