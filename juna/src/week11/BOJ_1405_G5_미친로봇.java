import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_G5_미친로봇 {
	
	static int n;	// 몇 번 움직이는지
	static double E;	// 동쪽으로 이동할 확률
	static double W;	// 서쪽으로 이동할 확률
	static double S;	// 남쪽으로 이동할 확률
	static double N;	// 북쪽으로 이동할 확률
	static double ans;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 몇 번 움직이는지
		E = Double.parseDouble(st.nextToken()) / 100;	// 동쪽으로 이동할 확률
		W = Double.parseDouble(st.nextToken()) / 100;	// 서쪽으로 이동할 확률
		S = Double.parseDouble(st.nextToken()) / 100;	// 남쪽으로 이동할 확률
		N = Double.parseDouble(st.nextToken()) / 100;	// 북쪽으로 이동할 확률
		
		visited = new boolean[2 * n + 1][2 * n + 1];
		dfs(0, n, n, 1);
		System.out.println(ans);
		
	}

	private static void dfs(int depth, int y, int x, double p) {

		if (visited[y][x])
			return ;

		if (depth == n) {
			ans += p;
			return ;
		}
		
		visited[y][x] = true;
		if (E > 0) dfs(depth + 1, y, x + 1, p * E);
		if (W > 0) dfs(depth + 1, y, x - 1, p * W);
		if (S > 0) dfs(depth + 1, y - 1, x, p * S);
		if (N > 0) dfs(depth + 1, y + 1, x, p * N);
		visited[y][x] = false;
		
	}

}
