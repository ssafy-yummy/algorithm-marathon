package week3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {
	static int N;
	static long[] city, road;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		road = new long[N-1]; // 도시
		city = new long[N]; // 도로
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		calc();
	}
	private static void calc() {
		long sum;
		int index;
		sum = city[0]*road[0]; // 처음엔 무조건 충전
		index = 0;
		for (int i = 1; i < N-1; i++) {
			if(city[index]>city[i]) index = i;
			sum += city[index]*road[i];
			// 주유소 값 비교후 적은 주유소로 충전
		}
		System.out.println(sum);
	}
}
