package hanmin.src.week12;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20546_S5_기적의매매법 {
	static int[][] map;
	static int[] arr;
	static int N;
	static List<Point> list;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[14];
		list = new ArrayList<>();
		for (int i = 0; i < 14; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		int JComp = N;
		int SNow = N;
		int stockChangeM = 0;
		int stockChangeP = 0;
		int JAmount = 0;
		// 1일차 준현이 구매
		if (JComp >= arr[0]) {
			int tmp = N / arr[0];
			JComp -= tmp * arr[0];
			JAmount += tmp;
		}
		for (int i = 1; i < 14; ++i) {
			// 이전보다 크다면
			if (arr[i] > arr[i - 1]) {
				stockChangeP++;
				stockChangeM = 0;
			} else if (arr[i] < arr[i - 1]) {
				// 이전보다 작다면
				stockChangeM--;
				stockChangeP = 0;
			}
			// 3일이상 하락할 시 구매
			if (stockChangeM <= -3) {
				int num = SNow / arr[i];
				SNow -= arr[i] * num;
				list.add(new Point(i, num));
			} else if (stockChangeP >= 3 && list.size() > 0) {
				// 3일 이상 상승하고 샀다면
				for (Point p : list) {
					SNow += arr[i] * p.y;
				}
				list.clear();
			}
			// 준현이 구매
			if (JComp >= arr[i]) {
				int tmp = N / arr[i];
				JComp -= tmp * arr[i];
				JAmount += tmp;
			}
		}
		// 준현이 마지막날 금액
		JComp += arr[13] * JAmount;
		// 성현이 마지막날 금액
		for (Point p : list) {
			SNow += arr[13] * p.y;
		}

		if (SNow > JComp)
			answer = 1;
		else if (SNow == JComp)
			answer = 2;

		// end

		// 출력
		String[] ans = { "BNP", "TIMING", "SAMESAME" };
		System.out.println(ans[answer]);
	}
}
