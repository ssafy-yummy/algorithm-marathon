package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_G5_뱀과사다리게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		for(int i=1;i<=100;i++) {
			map[i]=Integer.MAX_VALUE; //최대값으로 초기화(최단거리 구하기 위함)
		}
		int[] ladder = new int[101];
		int[] snake = new int[101];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladder[from]=to; //사다리 배열
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			snake[from]=to; //뱀 배열
		}
		Queue<Integer> queue = new LinkedList<>();
		map[1]=0;
		queue.offer(1); //1부터 시작
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i=1;i<=6;i++) { //주사위는 1~6
				int nx = x+i; //다음 이동 칸
				if(nx>100) //100칸 초과는 무시
					continue;
				if(ladder[nx]!=0) { //사다리가 있는 칸이면
					nx=ladder[nx]; //사다리를 타고 올라간다
					if(map[x]+1<map[nx]) { //현재칸에서 이동하는것이 원래 최소값보다 작다면
						map[nx]=map[x]+1; //최소값을 갱신하고
						queue.offer(nx); //큐에 추가한다.
					}
				}
				else if(snake[nx]!=0) { //뱀이 있는 칸이면
					nx=snake[nx]; //뱀을 타고 내려간다
					if(map[x]+1<map[nx]) {
						map[nx]=map[x]+1;
						queue.offer(nx);
					}
				}
				else { //일반 칸이면
					if(map[x]+1<map[nx]) {
						map[nx]=map[x]+1;
						queue.offer(nx);
					}
				}
			}
		}
		System.out.println(map[100]);
		
	}

}
