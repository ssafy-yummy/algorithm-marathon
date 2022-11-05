import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2436_G5_공약수 {
	
	static List<Integer> prime;
	static boolean[] p;
	static int a, b, c;
	static int min = Integer.MAX_VALUE;
	static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();	// 최대공약수
		b = sc.nextInt();	// 최소공배수
		c = b / a;
		
		// c보다 작거나 같은 소수를 찾고, 그 중에서 c의 소인수 찾기
		boolean[] chk = new boolean[c + 1];
		prime = new ArrayList<>();
		
		
		for (int i = 2; i * i <= c; i++)
			if (!chk[i]) // i가 소수면
				for (int j = i * i; j <= c; j += i)
					chk[j] = true;	// i의 배수들은 소수가 아니다
		
		
		for (int i = 2; i <= c; i++)
			if (!chk[i] && c % i == 0) {
				int tmp = c;
				int tmp2 = 1;

				while (tmp % i == 0) {
					tmp /= i;
					tmp2 *= i;
				}
				prime.add(tmp2);
			}
		
		
		p = new boolean[prime.size()];
		subset(0);
		System.out.println(ans);
	}

	private static void subset(int cnt) {
		
		if (cnt == prime.size()) {
			int tmp = 1;
			for (int i = 0; i < prime.size(); i++)
				if (p[i]) 
					tmp *= prime.get(i);
			
			int A = a * tmp;
			int B = a * c / tmp;

			if (min > A + B) {
				
				min = A + B;
				ans = A < B ? A + " " + B : B + " " + A;
				 
			}
				
			return ;
		}
		
		p[cnt] = true;
		subset(cnt + 1);
		p[cnt] = false;
		subset(cnt + 1);
	}
}