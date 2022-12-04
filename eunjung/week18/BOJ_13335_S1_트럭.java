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
		
		n = Integer.parseInt(st.nextToken()); 
		w = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		moving();
		System.out.println(result+w);
	}
	
	private static void moving() {
		Queue<Integer> nq = new LinkedList<>();
		int sum = 0;
		int cur = q.poll();
		nq.offer(cur);
		sum+=cur;
		result++;
		
		while(!q.isEmpty()) {
			if(nq.size()>=w) {
				sum -= nq.poll();
			}
			if(sum+q.peek()>L) {
				nq.offer(0);
			}
			else {
				cur = q.poll();
				nq.offer(cur);
				sum+=cur;
			}
			result++;
		}
	}
}
