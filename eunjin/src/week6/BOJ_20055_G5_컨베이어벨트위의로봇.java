package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {

	static int N, K, belt[], cnt, ans;
	static Queue<Integer> robot = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N+1];
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 2*N+1; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		} //read
		
		// 내구도가 0인 칸의 개수 구하기
		count();
		
		while(cnt<K) {
			start();
			ans++;	// 몇 번째 단계가 진행중인가
			count();
		}
		
		System.out.println(ans);
	}

	private static void count() {
		cnt = 0;
		for (int i = 1; i < 2*N+1; i++) {
			if(belt[i]==0) cnt++;
		}
	}

	private static void start() {
		// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
		// 내구도 회전
		belt[0] = belt[2*N];
		for (int i = 2*N; i > 0; i--)
			belt[i] = belt[i-1];
		
		// 로봇도 함께 회전하기
		int n = robot.size();
		for (int i = 0; i < n; i++) {
			int temp = robot.poll();
			if(++temp!=N)
				robot.offer(temp);	// 로봇이 내리는 위치에 오면 내린다. 그게 아니라면 내리지 않는다.
		}
		
		// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
		n = robot.size();
		int tmp = 0;	// 다음 로봇의 위치를 저장함
		for (int i = 0; i < n; i++) {
			int temp = robot.poll();
			if(belt[temp+1]==0 || (temp+1==tmp && tmp!=N)) {	// 다음 칸의 내구도가 0이거나 다음 칸에 로봇이 있는 경우
				robot.offer(temp);
				tmp = temp;	// 이전 로봇의 위치를 저장함
			} else if(temp+1<N) {	// 한 칸 이동할 수 있는 경우
				belt[temp+1]--;	// 내구도 감소
				robot.offer(temp+1);
				tmp = temp+1;
			} else if(temp+1==N) {	// 다음 칸이 내리는 위치인 경우
				belt[temp+1]--;	// 내구도 감소
				tmp = 0;
			}
		}
		
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		if(belt[1]>0) {
			robot.offer(1);	// 로봇 올리기
			belt[1]--;	// 내구도 감소
		}
		
	}

}
