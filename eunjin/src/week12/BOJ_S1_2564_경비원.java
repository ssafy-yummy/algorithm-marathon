package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {

	static int W, H, N, map[], ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int round = W+W+H+H;	// 둘레의 길이
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				// dir 1은 블록의 북쪽 -> 원점(좌측상단)에서부터 x만큼 떨어져있다. -> x
				break;
			case 2:
				// dir 2는 블록의 남쪽 -> (둘레)-(높이+x)
				x = round-(H+x);
				break;
			case 3:
				// dir 3은 블록의 서쪽 -> (둘레)-x
				x = round-x;
				break;
			case 4:
				// dir 4는 블록의 동쪽 -> 너비+x
				x = W+x;
				break;
			}
			map[i] = x;
		}
		
		// 거리를 비교한다. 동근이의 위치는 map[N]에 있음.
		for (int i = 0; i < N; i++) {
			int a = Math.abs(map[N] - map[i]);
			int b = round-a;
			ans += Math.min(a, b);
		}
		
		System.out.println(ans);
	}

}