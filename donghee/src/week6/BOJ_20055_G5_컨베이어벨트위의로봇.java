package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {

	static int N, K, belt[],result;
	static boolean[] onit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[2 * N];
		onit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i]= Integer.parseInt(st.nextToken());
		}//read of reading
		
		while(K>0) {
			result++;
			
			//1.회전
			spin();
//			System.out.println(Arrays.toString(belt));
//			System.out.println(Arrays.toString(onit));
//			System.out.println("-------------------------");
			
			//2.로봇이동
			move();
			
			//3.로봇놓기
			if(belt[0]>0) {
				belt[0]--;
				onit[0]=true;
				if(belt[0]==0)K--;
			}
		}
		System.out.println(result);
		
	}

	private static void move() {
		//한칸씩 이동
		for (int i = N-2; i >=0; i--) {
			if(onit[i]&& !onit[i+1] &&belt[i+1]>0) {
				onit[i+1]=true;
				onit[i]=false;
				belt[i+1] --;
				if(belt[i+1]==0)K--;
			}
		}
		
		//내리는 위치면 내림
		if(onit[N-1])onit[N-1]=false;
	}

	private static void spin() {
		//벨트 회전
		int tmp = belt[2*N-1];
		for (int i = 2*N-1; i >=1; i--) {
			belt[i]=belt[i-1];
		}
		belt[0]=tmp;
		
		//벨트위에 있는 로봇들도 회전(움직이는 것 X)
		for (int i = N-1; i >=1; i--) {
			onit[i]=onit[i-1];
		}
		onit[0]=false;
		
		//내리는 위치에 로봇 있으면 내림
		if(onit[N-1])onit[N-1]=false;
	}

}
