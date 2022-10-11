package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20207_S1_달력 {
	
	
	//정렬을 위한 클래스, 일정은 시작시간 s가 작은순서로, s가 같다면 일정의 길이 e-s가 큰 순서로 정렬.
	static class Meet implements Comparable<Meet>{
		
		int s;
		int e;
		public Meet(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		@Override
		public String toString() {
			return "Meet [s=" + s + ", e=" + e + "]";
		}
		@Override
		public int compareTo(Meet o) {
			if(this.s == o.s)
				return Integer.compare(o.e, this.e);
			else
				return Integer.compare(this.s, o.s);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 366;
		
		//일정표를 맵으로 만들어 사용. r는 일정의 갯수보다 하나 크게 만들어서 indexoutrange 방지.
		//c는 1~365 값 접근을 위해 366개 사용.
		boolean[][] map = new boolean[n+1][a];
		Meet[] meetings = new Meet[n];
		
		
		//하나의 연속일정의 값을 저장하기위한 변수들.
		//maxdept는 연속일정의 최대깊이. 코팅지의 높이
		//left는 연속일정의 가장 빠른 시작일자
		//right는 연속일정의 가장 늦은 종료일자
		//sums는 코팅지의 넓이.
		int maxDept = 0;
		int left = 0;
		int right = 0;
		int sums = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			meetings[i] = new Meet(s, e);
			
		}
		
		
		//일정 인풋이 정렬되어있지 않기 때문에 meetings배열로 받은 후 정렬.
		//정렬을 위한 compareto 메소드는 클래스에 오버라이딩 해놓음.
		Arrays.sort(meetings);
		
		
		//일정에서 하나 씩 빼서 요구사항에 맞게 구현.
		for (Meet m : meetings) {
		
			int s = m.s;
			int e = m.e;
			
			
			//현재일정이 자리잡을 수 있는 높이를 찾음. 
			int dept = 0;
			while(map[dept][s])
				 dept++;
			
			
			//찾은 높이에 일정의 길이 s~e까지를 true로 변경
			for (int i = s; i <= e ; i++) {
				map[dept][i] = true;
			}

			
			//만약 찾은 일정의 높이가 0이라면, 새로운 연속일정이 시작일 수 있기 때문에 검사
			if(dept == 0) {
				
				
				//만약 s==1이라면 무조건 연속일정의 시작이므로 left과 right값을 변경해주고 탈출
				if(s == 1) {
					left = s;
					right = e;
					continue;
				}
				
				
				//만약 탐색중인 연속일정의 right+1보다 s가 크다면, 두 일정은 연속된 날짜에
				//붙어있지 않기 때문에 연속일정이 아님. 따라서 sums에 연속일정에 붙일 코팅지 크기
				//를 더해주고 각 연속일정값들을 초기화 한 후 종료
				if(s > right+1) {
					if(right != 0)
						sums += (right-left+1)*(maxDept+1);
					maxDept = 0;
					left = s;
					right = e;
					continue;
				}
				
				
			}
			

			//새로운 연속일정의 시작이 아니라면 현재의 일정은 연속일정의 일부이므로
			//코팅지의 크기를 구하기위한 두 변수값을 업데이트.
			maxDept = Math.max(maxDept, dept);
			right = Math.max(right, e);
			
			
			
		}
		//위의 탐색을 종료하면 마지막 탐색중인 연속일정값이 sums에 저장되지 않음. 따라서 마지막
		//sums값을 추가하고 출력
		sums += (right-left+1)*(maxDept+1);
		System.out.println(sums);

		

		
	}

}
