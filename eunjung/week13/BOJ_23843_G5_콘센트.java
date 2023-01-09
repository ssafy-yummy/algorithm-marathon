package week13;

import java.io.*;
import java.util.*;

public class BOJ_23843_G5_콘센트 {
	static int N,M,result;
	static int[] elec;
	static class Charge implements Comparable<Charge>{
		int val;
		public Charge(int val) {
			this.val = val;
		}
		@Override
		public int compareTo(Charge o) {
			return Integer.compare(o.val, this.val);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Charge> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(new Charge(Integer.parseInt(st.nextToken())));
		}
		
		Queue<Charge> q = new LinkedList<>();
		
		
		for (int i = 0; i < M; i++) {
            if(pq.size()==0) break;
			q.offer(pq.poll());
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Charge ch = q.poll();
				ch.val--;
				
				if(ch.val==0) {
					if(pq.isEmpty()) continue;
					else q.offer(pq.poll());
				}
				else q.offer(ch);
			}
			result++;
		}
		
		System.out.println(result);
	}
}
