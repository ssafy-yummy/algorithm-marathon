package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구 {
	static int N,score;
	static int result = Integer.MIN_VALUE;
	static int[][] game; //전체 게임 (이닝x9명)
	static int[] seq;
	static int[] team;
	static int[] roo;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		long start= System.nanoTime();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		game= new int[N][9];
		visited= new boolean[9];
		seq= new int[8];
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				game[i][j]= Integer.parseInt(st.nextToken());
			}
			
		}//end of reading
		
		//1번타자 빼고 나머지 순서 만들기
		makeTeam(0);
		System.out.println(result);
//		long end= System.nanoTime();
//		System.out.println((end-start)/1000000000.0);
	}
	private static void makeTeam(int cnt) {
		if( cnt==8) {
			start();//정해진 순서로 게임시작
			return;
		}
		
		
		for (int i = 1; i <= 8; i++) {
			if(visited[i])continue;
			visited[i]=true;
			seq[cnt]=i;
			makeTeam(cnt+1);
			seq[cnt]=0;
			visited[i]=false;
		}
		
	}
	private static void start() {
		// 1번 선수 4번타자 고정한 스쿼드 다시 만들기
		team= new int[9];
		int idx=0;
		for (int i = 0; i < 9; i++) {
			if(i==3)continue;
			team[i]=seq[idx++];
		}
		
		
		//점수 로직
		score();
		result= Math.max(result, score);
	}
	
	private static void score() {
		score=0;
		int j=0;
		for (int i = 0; i < N; i++) {
			roo=new int[] {0,0,0,0}; //초기
			int outCnt=0;
			while(outCnt<3) {
				//타석에 선수 추가
				roo[0]=1;
				switch (game[i][team[j%9]]) { 
				case 0:
					outCnt++;
					break;
				case 1:
					move(1);
					break;
				case 2:
					move(2); 
					break;
				case 3:
					move(3);
					break;
				case 4://홈런
					for (int k = 0; k < roo.length; k++) {
						if(roo[k]==1) {
							score++;
							roo[k]=0;
						}
					}
					break;
				}
				j++;
			}
		}
	}
	private static void move(int cnt) {
		//cnt만큼 한번씩 움직이기
		for (int j = 0; j < cnt; j++) {
			//선수들 한칸씩 옮기기
			for (int i = roo.length-1; i >=0 ; i--) {
				if(roo[i]==1) {
					roo[i]=0;
					if(i==3) {
						score++;
					}else {
						roo[i+1]=1;
					}
				}
			}
		}
	}

}