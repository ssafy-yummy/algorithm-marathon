package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_2503_베스킨라빈스N {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// N이 1일 때 항상 후공이 이기고, N이 2,3,4일 때 항상 선공이 이긴다. 이것이 4 주기로 계속된다.
			sb.append("#").append(tc).append(" ").append(N%4==1?1:0).append("\n");
		}
		System.out.println(sb.toString());
	}
}
