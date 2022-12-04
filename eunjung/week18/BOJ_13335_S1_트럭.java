package week18;

import java.io.*;
import java.util.*;

public class BOJ_13335_S1_트럭 {
	static int n,w,L;
	static int result;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 트럭의 수 
		w = Integer.parseInt(st.nextToken()); // 다리의 길이 
		L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken())); // 큐에 트럭 무게를 넣어줌 
		}
		
		moving(); // 호출 
		System.out.println(result+w); // 결과값 출력 
	}
	
	private static void moving() {
		Queue<Integer> nq = new LinkedList<>();
		int sum = 0;
		int cur = q.poll();
		nq.offer(cur);
		sum+=cur; // 첫번째 트럭의 무게를 더해줌 
		result++; // 시간 증
		
		while(!q.isEmpty()) {
			if(nq.size()>=w) { // 다리에 트럭이 다 찼을 때 
				sum -= nq.poll(); // 가장 먼저 건너기 시작한 트럭 빼줌 
			}
			if(sum+q.peek()>L) { // 그 다음 트럭이 들어오면 최대하중을 넘는지 체크 
				nq.offer(0); // 넘을 경우, 트럭이 없음을 나타내는 0을 nq에 넣음 
			}
			else { // 안 넘을 경우,
				cur = q.poll();
				nq.offer(cur); // q에서 poll하여 nq에 넣음 
				sum+=cur; // 트럭 무게를 더해
			}
			result++; // 시간 증가 
		}
	}
}
