import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {
		
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int W = Integer.parseInt(st.nextToken());
		int[] map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for (int i = 1; i < W - 1; i++) {
            int l = map[i];		// 왼쪽 벽 최대높이
            int r = map[i];		// 오른쪽 벽 최대높이
            
            // 왼쪽 최대벽 높이 탐색
            for (int k = i - 1; k >= 0; k--)
                if (map[k] > map[i])
                    l = Math.max(l, map[k]);
            
            // 오른쪽 최대벽 높이 탐색
            for (int k = i + 1; k < W; k++)
                if (map[k] > map[i])
                    r = Math.max(r, map[k]);
            
            // 현재 벽보다 높은 벽이 양쪽에 있는 경우
            if (Math.min(l, r) > map[i])
                ans += (Math.min(l, r) - map[i]);
            
        }
		
		System.out.println(ans);
	}
}