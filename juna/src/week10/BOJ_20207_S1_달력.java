import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207_S1_달력 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 일정 개수
		int[] calendar = new int[366];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 일정 길이만큼 calendar에 1을 더해준다.
			for (int j = start; j < end + 1; j++) calendar[j]++;
		}
		
		
		int ans = 0;
		int length = 0;	// 코팅지의 너비
		int height = 0;	// 코팅지의 높이
		
		for (int i = 1; i < 366; i++) {
			
			if (calendar[i] > 0) {
				// calendar 값이 0이 아니면, 코팅지의 너비는 1씩 증가
				length++;
				
				// 코팅지의 높이는 calendar에 저장된 값의 최댓값
				height = Math.max(height, calendar[i]);
			}
				
			if (calendar[i - 1] > 0 && calendar[i] == 0) {
				// calendar가 0을 만나면 코팅지가 끝났다는 의미이므로, 코팅지 넓이를 정답에 더해주기
				ans += length * height;
				length = 0;
				height = 0;
			}
		}
		
		ans += length * height;
		System.out.println(ans);
	}

}
