import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dist = new long[N - 1];
		long[] oil = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			dist[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			oil[i] = Integer.parseInt(st.nextToken());
		
		// 2. 풀이
		long min = oil[0];
		long cost = 0;
		for (int i = 0; i < N - 1; i++) {
			min = Math.min(min, oil[i]);
			cost += min * dist[i];
		}
		
		// 3. 출력
		System.out.println(cost);
	}
}
