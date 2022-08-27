import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구공 {
	
	static int N;
	static int[][] a;
	static int[] p = {0,1,2,3,4,5,6,7,8};
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 이닝 수
		a = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		// 2. 풀이
		do {
			if (p[3] != 0) continue;
			solve();
		} while (np(8));
		

		// 3. 출력
		System.out.println(ans);
	}
	

	private static void solve() {
	
		boolean[] base = new boolean[4];
		base[0] = true;
		
		int score = 0;
		int order = 0;
		int out;
		
		for (int i = 0; i < N; i++) {	// i : 이닝
			
			base[1] = base[2] = base[3] = false;
			out = 0;
			
			while (out < 3) {
				int swing = a[i][p[order]];
				
				if (swing == 0) out++;
				else
					for (int k = 3; k >= 0; k--)
						if (base[k]) {
							if (swing + k > 3) score++;
							else base[swing + k] = true;
							if (k != 0) base[k] = false;
						}

				order = (order + 1) % 9;
			}
		}
		
		ans = Math.max(ans, score);
	}
	

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] > p[i]) i--;
		if (i == 0) return false;
		
		int j = size;
		while(p[i - 1] > p[j]) j--;
		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;
		
		int k = size;
		while (i < k) {
			tmp = p[i];
			p[i] = p[k];
			p[k] = tmp;
			i++;
			k--;
		}
		return true;
	}
}