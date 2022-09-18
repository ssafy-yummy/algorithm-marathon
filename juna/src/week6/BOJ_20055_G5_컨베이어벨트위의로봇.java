import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {
	
	static int N, K, cnt, ans;
	static int[] A;	// 내구도
	static boolean[] robot;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[2 * N + 1];
		robot = new boolean[2 * N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 2 * N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			robot[i] = false;
			if (A[i] == 0) cnt++;
		}
		
		
		// 2. 문제 풀이
		int start = 1;	// 올리는 위치
		int end = N;	// 내리는 위치
		
		while (cnt < K) {
			ans++;
			
			// 1단계) 벨트가 로봇과 함께 이동한다.
			// 벨트와 로봇을 직접 하나하나 이동시킬 필요 없이 start 인덱스와 end 인덱스만 하나 줄여주면 된다.
			start 	= 	start == 1 	 ?	 2 * N 	:	 start - 1;
			end 	= 	end   == 1 	 ?	 2 * N 	:	 end - 1;
			
			// 새로운 end 인덱스에 로봇이 있다면 그 로봇을 삭제시킨다.
			if (robot[end]) robot[end] = false;
			
			
			// 2단계) 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동한다.
			// 가장 먼저 벨트에 올라간 로봇은 end 인덱스에 제일 가까이 도달했을 것이므로, end-1번째 벨트부터 뒤로 탐색한다.
			int idx = end == 1 ? 2 * N : end - 1;
			
			do {
				// next는 idx 바로 다음 번째 인덱스
				int next = idx == 2 * N ? 1 : idx + 1;	
				
				// 현재 위치에 로봇이 있고, 다음 위치에 로봇이 없으며, 다음 위치의 내구도가 0 이상이라면 -> 로봇 이동
				if (robot[idx] && !robot[next] && A[next] > 0) {
					
					if (--A[next] == 0) cnt++;				// 이동한 위치의 벨트 내구도가 1개 감소한다.
					if (next != end) robot[next] = true;	// 이동한 위치의 벨트가 end 인덱스라면 로봇은 제거된다. (true 시켜줄 필요가 없다)
					robot[idx] = false;						// 원래 로봇이 있던 자리는 로봇이 비워지므로 false가 된다.
					
				}
				
				// idx 뒤에 있는 인덱스를 탐색한다.
				idx = idx == 1 ? 2 * N : idx - 1;
			}
			while (idx != end);	// 한 바퀴를 돌면 반복문이 종료된다.
			
			
			// 3단계) 올리는 위치의 칸에 로봇을 올린다.
			if (A[start] > 0) {
				robot[start] = true;
				if (--A[start] == 0) cnt++;
			}	
		}
		
		
		// 3. 출력
		bw.write("" + ans);
		bw.flush();
		br.close();
		bw.close();
	}
}
