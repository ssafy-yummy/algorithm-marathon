import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1182_G4_카드정렬하기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> card = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++)
			card.offer(Integer.parseInt(br.readLine()));
		
		int ans = 0;
		while (card.size() > 1) {
			int a = card.poll();	// 가장 적은 카드 묶음
			int b = card.poll();	// 그 다음으로 가장 적은 카드 묶음
			ans += a + b;
			card.offer(a + b);
		}
		System.out.println(ans);
	}
}