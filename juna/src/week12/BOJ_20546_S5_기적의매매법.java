import java.util.Scanner;

public class BOJ_20546_S5_기적의매매법 {

	public static void main(String[] args) {
		
		// 1. 입력 받기
		Scanner sc = new Scanner(System.in);
		int[] price = new int[14];
		int cach1, stock1 = 0;
		int cach2, stock2 = 0;
		cach1 = cach2 = sc.nextInt();
		
		for (int i = 0; i < 14; i++)
			price[i] = sc.nextInt();
		
		
		// 2. 문제 풀이
		int dday = 0;	// 주식이 연속으로 며칠 하락했는지
		int uday = 0;	// 주식이 연속으로 며칠 상승했는지
		
		for (int i = 0; i < 14; i++) {
			// ------------------준현이
			// 살 수 있는 모든 주식을 바로 산다.
			if (cach1 >= price[i]) {
				int cnt = cach1 / price[i];	// 살 수 있는 최대 주식 수
				cach1 -= cnt * price[i];
				stock1 += cnt;
			}
			
			// ------------------성민이
			if (i == 0) continue;
			
			if (price[i - 1] < price[i]) {
				uday++;
				dday = 0;
			}
			else if (price[i - 1] > price[i]) {
				dday++;
				uday = 0;
			}
			else {
				uday = 0;
				dday = 0;
			}
			
			// 매수하기
			if (dday >= 3) {
				int cnt = cach2 / price[i];
				cach2 -= cnt * price[i];
				stock2 += cnt;
			}
			// 매도하기
			else if (uday >= 3) {
				cach2 += price[i] * stock2;
				stock2 = 0;
			}
		}
		
		
		// 3. 출력
		int tot1 = cach1 + stock1 * price[13];	// 준현이의 최종 자산
		int tot2 = cach2 + stock2 * price[13];	// 성민이의 최종 자산
		
		System.out.println(tot1 > tot2 ? "BNP" : tot1 < tot2 ? "TIMING" : "SAMESAME");
	}

}
