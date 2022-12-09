package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_13335_트럭 {

	static int N, W, L, input[], sum, ans;
	static Queue<int[]> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 다리를 건너는 트럭의 수
		W = Integer.parseInt(st.nextToken());	// 다리의 길이
		L = Integer.parseInt(st.nextToken());	// 다리의 최대하중
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} //read
		
		ans = 0;	// 다리를 모두 건너는 데에 걸리는 시간
		go();
		
		System.out.println(ans);
	}

	private static void go() {
		que = new LinkedList<>();	// 다리 위에 있는 트럭들을 que에 저장한다.
		sum = 0;
		for (int i = 0; i < N; i++) {
			go2();
			while(sum+input[i] > L) {
				// (새로운 트럭의 무게) + (다리 위 트럭의 총 무게) > 최대하중(L)인 경우, 새로운 트럭은 다리에 오를 수 없다.
				go2();	// 트럭이 한 칸씩 옮겨진다.
			}
			que.offer(new int[] {input[i], W});
			sum += input[i];
		}
		
		// 마지막 트럭까지 다리에 오른 후, 마지막 트럭의 위치(W)만큼 ans에 더한다.
		ans += W;
	}

	private static void go2() {
		ans++;
		for (int j = 0, n = que.size(); j < n; j++) {
			// 다리 위 트럭들의 위치를 1씩 줄이고, 0이 되면 다리를 건넌 것이다.
			int[] arr = que.poll();
			if(arr[1]==1) {	// 다리를 건넌 것이므로 que에 저장하지 않는다.
				sum -= arr[0];
			} else {
				que.offer(new int[] {arr[0], arr[1]-1});
			}
		}
	}

}
