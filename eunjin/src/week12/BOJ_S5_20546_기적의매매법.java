package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_20546_기적의매매법 {

	static int jun[], sung[], map[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		jun = new int[2];	// jun[0]:현금, jun[1]:매수한 주식 주
		sung = new int[3];	// sung[0]:현금, sung[1]:매수한 주식 주, sung[2]:연속적으로 주가가 증감한 주기
		int money = Integer.parseInt(br.readLine());
		jun[0] = sung[0] = money;
		map = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		} //read
		
		for (int i = 0; i < 14; i++) {
			// 1. jun은 무조건 살 수 있으면 산다. (매도하지 않고 매수하기만 한다.)
			if(jun[0] >= map[i]) {
				buy(jun, i);
			}
			
			// 2. sung의 증감 주기를 표시한다.
			if(i==0) continue;
			if(map[i-1]==map[i]) {	// 증감하지 않은 경우 : 0
				sung[2] = 0;
			} else if(map[i-1]<map[i]) {	// 증가한 경우 : 1,2,3,4.. 양수로 연속적인 주기를 표기한다.
				sung[2] = Math.max(1, sung[2]+1);
			} else if(map[i-1]>map[i]) {	// 감소한 경우 : -1,-2,-3,-4.. 음수로 연속적인 주기를 표기한다.
				sung[2] = Math.min(-1, sung[2]-1);
			}
			
			// 3. sung의 감소 주기가 -3이하일 때 매수한다.
			if(sung[2]<=-3) {
				buy(sung, i);
			}
			
			// 4. sung의 증가 주기가 3이상일 때 매도한다.
			else if(sung[2]>=3) {
				sell(sung, i);
			}

		}
		
		int ans1 = jun[0] + map[13]*jun[1];
		int ans2 = sung[0] + map[13]*sung[1];

		System.out.println(ans1>ans2?"BNP":ans1<ans2?"TIMING":"SAMESAME");
	}

	private static void buy(int[] person, int idx) {
		int week = person[0] / map[idx];
		person[1] += week;
		person[0] %= map[idx];
	}

	private static void sell(int[] person, int idx) {
		person[0] += person[1] * map[idx];
		person[1] = 0;
	}
}