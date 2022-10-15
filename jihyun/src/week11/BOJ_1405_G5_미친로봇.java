package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_G5_미친로봇 {
	static int n;
	static double[] pc;
	static double answer;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		pc = new double[4];
		for(int i=0;i<4;i++) {
			pc[i]=Integer.parseInt(st.nextToken())/100.0;
		}
		answer = 0.0;
		visit = new boolean[29][29]; //최대 14번 이동하므로
		visit[14][14]=true; //시작지는 정 중앙
		dfs(0,14,14,1.0);
		
		System.out.println(answer);

	}

	private static void dfs(int end, int x, int y, double p) {
		if(end==n) { //n번까지 도달, 간곳을 다시 간적이 없는 경우 
			answer+=p;
			return;
		}

		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			//갔던 길일 경우
			if(visit[nx][ny]==true) {
				continue;
			}
			//갔던 길이 아닐 경우
			visit[nx][ny]=true;
			dfs(end+1, nx, ny, p*pc[i]);
			visit[nx][ny]=false;
			
		}
		
	}
}


