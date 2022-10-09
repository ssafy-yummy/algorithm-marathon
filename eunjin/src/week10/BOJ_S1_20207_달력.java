package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S1_20207_달력 {

	static int N, start, end, ans;
	static PriorityQueue<int[]> pq;
	static List<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(new Comparator<int[]>() {	// {시작날짜, 종료날짜} 일정 정보를 저장
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];	// 시작날짜가 같다면 마지막날짜를 기준으로 오름차순 정렬
				return o1[0] - o2[0];	// 시작날짜를 기준으로 오름차순 정렬
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {a,b});
		} //read
		
		start = -1; end = -1; ans = 0;
		list = new ArrayList<>();
		while(!pq.isEmpty()) {
			int days[] = pq.poll();
			int s = days[0];	// 시작날짜
			int e = days[1];	// 종료날짜
			
			if(end < s && end+1 != s) {	// 1-1. 코팅지가 새로 시작하는 영역
				if(list.size()!=0) count();	// 이전에 사용하던 코팅지가 있다면, 코팅지 영역 계산하기
				
				// 새로운 코팅지 시작
				start = s;
				end = e;
				list.add(new int[] {s,e});
			}
			else {	// 1-2. 현재 코팅지에 이어서 붙일 영역
				int idx = -1;
				
				for (int i = 0, n = list.size(); i < n; i++) {
					if(list.get(i)[1] < s) {	// 해당 list에 이어서 붙임.
						idx = i;
						list.get(i)[1] = e;		// 끝나는 날짜를 현재 스케줄의 끝나는 날짜로 저장
						break;
					}
				}
				
				if(idx == -1) {	// 이어 붙일 영역이 없다면 새로운 row에 추가함
					list.add(new int[] {s,e});
				}
				
				end = Math.max(end, e);
			}
		}
		
		if(list.size()!=0) count();	// 이전에 사용하던 코팅지가 있다면, 코팅지 영역 계산하기
		
		System.out.println(ans);
		
	}

	private static void count() {
		ans += (end-start+1) * list.size();
		list.clear();
	}

}
