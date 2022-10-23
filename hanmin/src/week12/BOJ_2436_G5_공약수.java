package hanmin.src.week12;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2436_G5_공약수 {
	static int[] arr;
	static long N;
	static long M;
	static long answer;
	static long mx;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());

		// start
		// a*b=N*M
		long sum = N * M;
		answer = N;
		mx = Long.MAX_VALUE;
		for (long i = N; i < sum; i += N) {
			long scd = sum / i;
			if (gcd(i, scd) != N)
				continue;
			if (i * scd / N != M)
				continue;
			if (scd <= i)
				break;
			long tmp = i + scd;
			if (mx > tmp) {
				answer = i;
				mx = tmp;
			}
		}

		// end

		// 출력
		System.out.println(answer + " " + sum / answer);
	}

	private static long gcd(long a, long b) {
		long tmp, n;
		if (a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		while (b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}
}
