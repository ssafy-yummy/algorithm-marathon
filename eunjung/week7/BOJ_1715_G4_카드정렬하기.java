package week7;

import java.util.*;

public class BOJ_1715_G4_카드정렬하기 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			pq.offer(scann.nextInt());
		}
		
		// 카드 묶음 수가 1일 경우 비교가 필요없으므로 0출력
		if(pq.size()==1) System.out.println(0);
		
		else {
			int tmp = 0;
			int result = 0;
			while(pq.size()>=2) {
				tmp = pq.poll()+pq.poll(); // 카드 두 묶음 카드 수 연산
				result += tmp; // 결과값에 더함
				pq.offer(tmp); // 두 묶음 연산값을 다시 pq에 offer
				tmp = 0;
			}
		
			System.out.println(result); // 출력
		}
	}
}
