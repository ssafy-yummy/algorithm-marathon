package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_S3_퇴사 {
	
	static int N, R, day, ans, mn;
	static int[] T, P, selected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 입력 받기
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		selected = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 문제 풀이 (NC1 ~ NCN)
		for (int i = 1; i <= N; i++) {
			R = i;
			combination(0, 0);
		}
		
		// 3. 출력
		System.out.print(ans);
	}
	
	// N개의 날짜 중에서 R개를 조합하여 selected 배열에 담는 메서드
	private static void combination(int start, int cnt) {
		
		if (cnt == R) {		// 조합 완성
			mn = 0;
			day = 0;
			
			for (int today : selected) {	// today : 오늘 날짜 (현재 탐색 중인 날짜)
				
				if (day > today) continue;	// 앞서서 진행한 상담의 종료일(day)이 오늘 날짜(today)보다 나중이라면 continue
				
				day = today + T[today];		// day : 오늘의 상담을 진행하고, 상담 종료 날짜를 업데이트하기
				if (day > N) break;			// 상담 종료 날짜(day)가 퇴사일(N)보다 나중이라면 break
				
				mn += P[today];
			}
			
			ans = Math.max(ans, mn);
		}
		else {
			
			for (int i = start; i < N; i++) {
				selected[cnt] = i;
				combination(i + 1, cnt + 1);
			}
		}
	}
}