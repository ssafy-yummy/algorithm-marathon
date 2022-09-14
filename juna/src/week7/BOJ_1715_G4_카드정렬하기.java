import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_G4_카드정렬하기 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> card = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++)
			card.offer(Integer.parseInt(br.readLine()));
		
		
		// 2. 문제 풀이
		// 가지고 있는 카드 묶음들 중에서 제일 양이 적은 것 2개를 골라서 합치면 된다.
		// 카드 묶음들을 PriorityQueue에 넣어 저장하면, 항상 제일 양이 적은 것 2개를 뽑을 수 있다.
		int ans = 0;
		
		while (card.size() > 1) {
			int a = card.poll();
			int b = card.poll();
			ans += a + b;
			card.offer(a + b);
		}
		
		
		// 3. 출력
		System.out.println(ans);
	}
}
