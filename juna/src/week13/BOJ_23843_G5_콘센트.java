import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843_G5_콘센트 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 전자기기 수
		int M = Integer.parseInt(st.nextToken());	// 콘센트 수
		
		// 각 전자 기기들의 충전 시간	: 충전 시간이 제일 큰 것부터 poll 된다.
		PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());
		// 각 콘센트들의 사용 시간		: 사용 시간이 제일 작은 것부터 poll 된다.
		PriorityQueue<Integer> charger = new PriorityQueue<>();
		
		// 콘센트들은 처음에는 모두 사용 시간이 0이다.
		for (int i = 0; i < M; i++)
			charger.add(0);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			time.add(Integer.parseInt(st.nextToken()));
		
		
		
		// 2. 문제 풀이
		while (!time.isEmpty()) {
			int t = time.poll();	// 충전 시간(t)이 제일 긴 전자기기부터
			int c = charger.poll();	// 사용 시간(c)이 제일 짧은 콘센트에
			charger.add(c + t);		// 꽂는다. (사용 시간이 t 늘어난 c + t가 되었다.)
		}
		
		
		
		// 3. 정답
		// 모든 콘센트들의 사용 시간들 중 제일 짧은 것(pq에서 제일 마지막으로 poll 되는 것)이 정답이다.
		while (charger.size() != 1)
			charger.poll();
		
		System.out.println(charger.poll());
	}

}
