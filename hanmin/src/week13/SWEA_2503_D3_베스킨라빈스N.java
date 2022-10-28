package hanmin.src.week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class SWEA_2503_D3_베스킨라빈스N {
	static int answer;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N=Integer.parseInt(br.readLine());

			// start
			// 1 5 9 13 17
			int flg = 0;
			if (N % 4 == 1)
				flg = 1;
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, flg);
		}
	}
}