package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843_G5_콘센트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;

		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -(a-b);
			}
		});
		for (int i = 0; i < n; i++) {
			pqueue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int[] temp = new int[m];
		
		while (!pqueue.isEmpty()) {
			if(pqueue.size()<m) {
				answer+=pqueue.peek();
				break;
			}
			for(int i=0;i<m;i++) {
				temp[i]=pqueue.poll();
			}
			for(int i=0;i<m;i++) {
				if(temp[i]-temp[m-1]>0) {
					pqueue.offer(temp[i]-temp[m-1]);
				}
			}
			answer+=temp[m-1];
		}
		System.out.println(answer);

	}
}
