package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12100_G2_2048Easy {
	static int[] dir = new int[5];
	static int n;
	static int[][] map;
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] copy;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		
		System.out.println(answer);

	}

	private static void dfs(int end) {
		if(end==5) { //5번 회전을 완료하면
			copy = arrayCopy(); //방향으로 몰때마다 배열값 변경이 일어나므로 copy배열 사용
			for(int k=0;k<5;k++) {
				int d=dir[k]; //방향
				if(d==0) 
					goUp(); //위로 몰기
				else if(d==1)
					goDown(); //아래로 몰기
				else if(d==2)
					goLeft(); //왼쪽으로 몰기
				else if(d==3)
					goRight(); //오른쪽으로 몰기
			}
			findMax(); //최대값 블럭 찾기
			return;
		}
		for(int i=0;i<4;i++) { //상 하 좌 우 4가지
			dir[end]=i; //방향 저장
			dfs(end+1); //다음 방향 구하러 간다
		}
		
	}

	private static void goRight() {
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=0;j--) {
				if(copy[i][j]!=0) {
					int next = j-1;
					while(true) {
						if(next>=0 && copy[i][next]==0) {
							next--;
							continue;
						}
						else if(next>=0 && copy[i][j]==copy[i][next]) {
							queue.offer(copy[i][j]*2);
							j=next;
							break;
						}
						else {
							queue.offer(copy[i][j]);
							break;
						}
					}				
				}
			}
			for(int j=n-1;j>=0;j--) {
				if(!queue.isEmpty())
					copy[i][j]=queue.poll();
				else
					copy[i][j]=0;
			}
		}
		
	}

	private static void goLeft() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(copy[i][j]!=0) {
					int next = j+1;
					while(true) {
						if(next<n && copy[i][next]==0) {
							next++;
							continue;
						}
						else if(next<n && copy[i][j]==copy[i][next]) {
							queue.offer(copy[i][j]*2);
							j=next;
							break;
						}
						else {
							queue.offer(copy[i][j]);
							break;
						}
					}				
				}
			}
			for(int j=0;j<n;j++) {
				if(!queue.isEmpty())
					copy[i][j]=queue.poll();
				else
					copy[i][j]=0;
			}
		}
		
	}

	private static void goDown() {
		for(int j=0;j<n;j++) {
			for(int i=n-1;i>=0;i--) {
				if(copy[i][j]!=0) {
					int next = i-1;
					while(true) {
						if(next>=0 && copy[next][j]==0) {
							next--;
							continue;
						}
						else if(next>=0 && copy[i][j]==copy[next][j]) {
							queue.offer(copy[i][j]*2);
							i=next;
							break;
						}
						else {
							queue.offer(copy[i][j]);
							break;
						}
					}				
				}			
			}
			for(int i=n-1;i>=0;i--) {
				if(!queue.isEmpty())
					copy[i][j]=queue.poll();
				else
					copy[i][j]=0;
			}
		}	
	}

	private static void goUp() {
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				if(copy[i][j]!=0) {
					int next = i+1;
					while(true) {
						if(next<n && copy[next][j]==0) {
							next++;
							continue;
						}
						else if(next<n && copy[i][j]==copy[next][j]) {
							queue.offer(copy[i][j]*2);
							i=next;
							break;
						}
						else {
							queue.offer(copy[i][j]);
							break;
						}
					}				
				}
			}
			for(int i=0;i<n;i++) {
				if(!queue.isEmpty())
					copy[i][j]=queue.poll();
				else
					copy[i][j]=0;
			}
		}
	}
	
	private static void findMax() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				answer = Math.max(answer, copy[i][j]); //nXn 배열에서 가장 큰 블럭값을 찾는다.
			}
		}
	}

	private static int[][] arrayCopy() {
		int[][] temp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				temp[i][j] = map[i][j]; //temp 배열에 map 배열을 깊은복사한다.
			}
		}
		return temp;
	}

}
