package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843_G5_콘센트 {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] tmp = br.readLine().split(" ");
		
		Integer[] arr = new Integer[tmp.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		Arrays.sort(arr, Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			pq.offer(0);
		}
		
		int cnt = 0;
		
		while(cnt != arr.length) {

			
			int cur = pq.poll();
			pq.offer(cur+arr[cnt]);
			cnt++;
		}
		
		int maxs = 0;
		int s = pq.size();
		for (int i = 0; i < s; i++) {
			maxs = Math.max(pq.poll(),maxs);
		}
		System.out.println(maxs);
	}

}
