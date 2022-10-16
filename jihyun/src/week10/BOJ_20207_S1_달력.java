package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20207_S1_달력 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] days = new int[366]; //1일~356일 사용
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j=s;j<=e;j++) {
				days[j]++;
			}
		}
		/*
		달력은 시작일이 가장 앞선 일정부터 차례대로 채워진다, 시작일이 같은 경우 일정의 기간이 긴 것이 먼저 채워진다는 규칙을 따른다.
		따라서 이어진 부분의 최대 길이와 최대 높이를 이용해서 넓이를 구하는 것이다.
		즉, ?일당 ?개의 일정을 수행하는 것을 저장한다. 
		매일 일정이 끊이지 않는 기간이 가로길이로, 하루가 가지는 최대 일정 개수가 세로 길이가 된다.
		 */
		int answer = 0;
		int w = 0;
		int h = 0;
		for(int i=1;i<=365;i++) {
			if(days[i]!=0) {
				w++;
				h = Math.max(h, days[i]);
			}
			else {
				answer+=w*h;
				w=0;
				h=0;
			}
		}
		answer+=w*h;
		
		System.out.println(answer);

	}

}
