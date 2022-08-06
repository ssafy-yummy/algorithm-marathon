package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_S3_퇴사 {
	static info[] arr;
	static int n;
	static int answer = 0;

	static class info { //기간, 금액 정보 
		int day, money;

		public info(int day, int money) {
			this.day = day;
			this.money = money;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new info[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			arr[i] = new info(day, money);
		}
		recursion(0, 0); // 0원 0일 시작
		System.out.println(answer);
	}

	private static void recursion(int sum, int start) {
		for (int i = start; i < n; i++) { //가능한 경우의 수에 대해 탐색
			if (arr[i].day <= n - i) { //해야할 기간이 남은 기간 이내일 경우
				int nsum = sum + arr[i].money;
				int nday = i + arr[i].day;

				recursion(nsum, nday); //총 금액 갱신, 날짜 갱신
			}
		}

		answer = Math.max(answer, sum); //더 이상 남은 날이 없다
	}
}