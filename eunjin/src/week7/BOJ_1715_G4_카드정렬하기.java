package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_G4_카드정렬하기 {
	
	static int N;
	static long ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		} //read
		
		// 가장 작은 두 수를 더하고 그 더한 수를 다시 우선순위큐에 넣음
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			int c = a+b;
			ans += c;
			pq.add(c);
		}

		System.out.println(ans);
	}

}
