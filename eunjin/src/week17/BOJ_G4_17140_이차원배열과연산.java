package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_17140_이차원배열과연산 {
	
	static class Node implements Comparable<Node>{
		int number, count;
		public Node(int number, int count) {
			super();
			this.number = number;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			if(this.count == o.count) return this.number - o.number;
			return this.count - o.count;
		}
	}
	static int r, c, k, A[][], rIndex, cIndex, countNum[], ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		A = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		rIndex = 3;	// A[][] 배열의 행 수
		cIndex = 3;	// A[][] 배열의 열 수
		
		ans = 0;
		while(A[r][c]!=k && ans<=100) {	// 100초 안으로 A[r][c] 자리에 k가 들어갈 때까지 반복한다.
			
			if(rIndex >= cIndex) {
				R();	// 행의 개수 ≥ 열의 개수인 경우에 R 연산을 수행한다.
			} else {
				C();	// 행의 개수 < 열의 개수인 경우에 C 연산을 수행한다.
			}
			ans++;
		}
		
		System.out.println(ans==101?-1:ans);
	}

	private static void R() {
		int cMaxIndex = 0;	// 열의 수가 바뀔 수 있으므로
		for (int i = 0; i < rIndex; i++) {
			countNum = new int[101];	// countNum[] : 1~100 까지의 수의 개수를 세기 위한 배열
			for (int j = 0; j < cIndex; j++) {
				if(A[i][j]==0) continue;
				countNum[A[i][j]]++;	// 숫자가 몇 번 나왔는지 세고 저장한다.
			}
			
			// pq를 이용하여 숫자를 센다
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int j = 0; j < 101; j++) {
				if(countNum[j]==0) continue;
				pq.add(new Node(j, countNum[j]));
			}
			int n = pq.size();
			cMaxIndex = Math.max(cMaxIndex, n*2);
			
			// 정렬한 값을 A[][] 배열에 넣는다.
			Arrays.fill(A[i], 0);	// 해당 행을 먼저 0으로 초기화.
			for (int j = 0, idx = 0; j < n; j++) {
				Node nd = pq.poll();
				A[i][idx++] = nd.number;
				A[i][idx++] = nd.count;
			}
		}
		cIndex = cMaxIndex;
	}


	private static void C() {
		int rMaxIndex = 0;	// 행의 수가 바뀔 수 있으므로
		for (int i = 0; i < cIndex; i++) {
			countNum = new int[101];	// countNum[] : 1~100 까지의 수의 개수를 세기 위한 배열
			for (int j = 0; j < rIndex; j++) {
				if(A[j][i]==0) continue;
				countNum[A[j][i]]++;	// 숫자가 몇 번 나왔는지 세고 저장한다.
			}
			
			// pq를 이용하여 숫자를 센다
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int j = 0; j < 101; j++) {
				if(countNum[j]==0) continue;
				pq.add(new Node(j, countNum[j]));
			}
			int n = pq.size();
			rMaxIndex = Math.max(rMaxIndex, n*2);
			
			// 정렬한 값을 A[][] 배열에 넣는다.
			for (int j = 0; j < rIndex; j++) {
				A[j][i] = 0;	// 해당 열을 먼저 0으로 초기화.
			}
			for (int j = 0, idx = 0; j < n; j++) {
				Node nd = pq.poll();
				A[idx++][i] = nd.number;
				A[idx++][i] = nd.count;
			}
		}
		rIndex = rMaxIndex;
	}
}