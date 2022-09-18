package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] durability = new int[2][n];
		boolean[] robot = new boolean[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			durability[0][i]=Integer.parseInt(st.nextToken());
		}
		for(int i=n-1;i>=0;i--) {
			durability[1][i]=Integer.parseInt(st.nextToken());
		}
		//입력끝
		int answer = 1;
		int zeroCount=0;
		while(true) {
			//벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			int temp1 = durability[0][n-1];
			for(int i=n-1;i>=1;i--)
				durability[0][i]=durability[0][i-1];
			durability[0][0]=durability[1][0];
			for(int i=0;i<=n-2;i++)
				durability[1][i]=durability[1][i+1];
			durability[1][n-1]=temp1; //컨베이너 벨트의 내구성 값은 모든 칸에 대해서 회전한다.
			
			for(int i=n-1;i>=1;i--)
				robot[i]=robot[i-1];
			robot[0]=false;
			robot[n-1]=false; //로봇이 존재 유무 값은 1~N까지만 해당된다.
			
			//가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			//로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			for(int i=n-2;i>=0;i--) {
				if(robot[i]==true && robot[i+1]==false && durability[0][i+1]>=1) {
					robot[i+1]=true;
					robot[i]=false;
					durability[0][i+1]--;
					if(durability[0][i+1]==0)
						zeroCount++;
				}
			}
			
			//올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(durability[0][0]!=0) {
				durability[0][0]--;
				if(durability[0][0]==0)
					zeroCount++;
				robot[0]=true;
			}
			
			//내구도가 0인 칸의 개수가 m개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			if(zeroCount>=m)
				break;
			
			answer++;
		}
		System.out.println(answer);
	}
}
