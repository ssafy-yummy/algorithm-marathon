import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2503_D3_베스킨라빈스_N {
		
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			// N % 4 == 1이면 항상 후공이 이길 수 있고, 그렇지 않으면 항상 선공이 이길 수 있다.
			int N = Integer.parseInt(br.readLine());
			int ans = N % 4 == 1 ? 1 : 0;
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.println(sb);
	}

}
