import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_S3_퇴사 {
	// N 15
	// T 5
	// P 1000
	// dp활용 dp[t+i]= dp[i]+pi
	// 총 시간복잡도 O(N)
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] t = new int[N + 2];
		int[] p = new int[N + 2];
		// 각각 배열에 저장
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		// N+T+1만큼 배열 생성
		int[] dp = new int[N + 6];
		for (int i = 1; i <= N+1; ++i) {
			// i-1일 까지 번 금액과 i일까지 번 금액 비교
			dp[i] = Math.max(dp[i], dp[i - 1]);
			// i+T일 후 i까지 번 금액 + P만큼 벌 수 있다.
			dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
		}
		// N일까지 이므로 N+1일의 수익 계산
		System.out.println(dp[N + 1]);
		br.close();
	}
}
