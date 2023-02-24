package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13164_G5_행복유치원 {
	
	static class Node implements Comparable<Node>{
		
		int idx;
		int w;
		public Node(int idx, int w) {
			super();
			this.idx = idx;
			this.w = w;
		}
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.w, this.w);
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] students = new int[n];
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n-1; i++) {
			pq.offer(new Node(i,students[i+1]-students[i]));
		}
		
		int[] idx = new int[k-1];
		int i = 0;
		while(k != 1) {
			
			idx[i++] = pq.poll().idx;
			k--;
			
		}
		
		Arrays.sort(idx);		
		
		int left = -1;
		int sums = 0;
		for (int j = 0; j < idx.length; j++) {
			sums += (students[idx[j]] - students[left+1]);
			left = idx[j];
		}

		sums += students[n-1] - students[left+1];
		
		
		System.out.println(sums);
	}

}
