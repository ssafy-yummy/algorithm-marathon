import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20115_S3_에너지드링크 {

	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Double> drink = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			drink.offer((double) Integer.parseInt(st.nextToken()));
		
		
		// 2. 문제 풀이
		double ans = 0;
		
		while (drink.size() > 1)
			ans += drink.poll() / 2;	// 항상 제일 최솟값인 것을 절반 흘린다.
		
		ans += drink.peek();	// 마지막에 남아 있는 값(최댓값)은 절반 흘리지 않는다.
		
		
		// 3. 출력
		System.out.println(ans);
	}

}
