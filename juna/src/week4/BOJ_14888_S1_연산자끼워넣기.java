import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_S1_연산자끼워넣기 {
	
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] n;		// 피연산자들
	static int[] op;	// 연산자들
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		n = new int[N];
		op = new int[4];
		
		// 피연산자 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			n[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		
		// 2. 풀이
		dfs(1, n[0]);
		
		
		// 3. 출력
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int cnt, int result) {
		
		// N - 1번의 연산을 모두 끝마치면 정답을 갱신하고 return한다.
		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return ;
		}
		
		for (int i = 0; i < 4; i++)
			// 연산자 개수가 남아 있을 경우에만 탐색을 진행한다.
			if (op[i] > 0) {
				int ret = result;
				
				switch (i) {
				case 0:	// 더하기
					ret += n[cnt];
					break;
				case 1:	// 빼기
					ret -= n[cnt];
					break;
				case 2:	// 곱하기
					ret *= n[cnt];
					break;
				case 3:	// 나누기
					ret /= n[cnt];
					break;
				}
				
				op[i]--;
				dfs(cnt + 1, ret);
				op[i]++;
			}
	}
}