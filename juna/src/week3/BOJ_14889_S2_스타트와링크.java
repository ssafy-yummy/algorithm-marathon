import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_S2_스타트와링크 {
	
	static int N;
	static int ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 풀이
		combination(0, 0, N / 2);
		
		// 3. 출력
		System.out.println(ans);
	}

	private static void combination(int start, int idx, int size) {
		
		if (idx == N / 2) {
			int team1 = 0, team2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ( selected[i] &&  selected[j]) team1 += arr[i][j];
					if (!selected[i] && !selected[j]) team2 += arr[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(team1 - team2));
			return ;
		}
		
		// 맨 처음에만 for문 범위를 N / 2까지로 하고, 그 이후에는 N까지로 한다. 그럴 경우 탐색 범위를 절반으로 줄일 수 있다.
		// 즉, (true, true, false, false)와 (false, false, true, true)를 같은 것으로 보고, 나머지 하나는 굳이 탐색하지 않는다.
		for (int i = start; i < size; i++) {
			selected[i] = true;
			combination(i + 1, idx + 1, N);
			selected[i] = false;
		}
	}
}
