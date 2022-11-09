package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_23843_콘센트 {

	static int N,  M, time[];
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		time = new int[M];	// M개의 콘센트 배열을 만들어서 0부터 순서대로 충전할 것이다. 충전에 필요한 최소 시간은 time[0] 값이 될 것임.
		pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));	// 충전 소요 시간이 큰 순서대로 pq에 값을 입력받는다.
		} //read
		
		while(!pq.isEmpty())	// 모든 충전이 끝날 때까지 로직을 수행한다.
			go();
		
		System.out.println(time[0]);
	}

	private static void go() {
		for (int i = 0; i < M; i++) {
			time[i] += pq.poll();
			if(pq.isEmpty()) return;
			while(time[i] < time[0]) {	// 가장 큰 시간(time[0])과 같은 경우, 다음 인덱스로 넘어가서 저장한다.
				time[i] += pq.poll();
				if(pq.isEmpty()) return;
			}
		}
	}

}
