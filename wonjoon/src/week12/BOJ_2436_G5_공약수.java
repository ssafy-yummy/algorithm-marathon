package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2436_G5_공약수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long gcd = Long.parseLong(st.nextToken());
		long lcm = Long.parseLong(st.nextToken());

		long mul = gcd * lcm;

		long a = gcd;
		long b = lcm;
		for (long i = gcd; i * i <= mul; i += gcd) { // 모든 약수 탐색할 필요 없음 -> i가 약수라면 n/i도 약수
			if (mul % i == 0 && eucd(i, mul / i) == gcd) { // 약수 확인 && 최대공약수 일치 확인
				if (i + (mul / i) < a + b) { // 차이 최소 저장
					a = i;
					b = (mul / i);
//					System.out.println(a + " " + b);
				}
			}
		}

		System.out.println(a + " " + b);

	}

	// a%b==0 ? gcd = b : gcd(b, a%b)
	private static long eucd(long a, long b) {
		long c = a % b;
		if (c == 0)
			return b;
		return eucd(b, c);
	}
}
