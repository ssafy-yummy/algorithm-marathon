package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_S2_스타트와링크 {   // Point : 조합의 조합
	static int N;
	static int[][] map; // 시너지표
	static int[] teamA;
	static int[] teamB;
	static boolean[] chk; // teamB만들기 위한 boolean배열
	static int[] sinA = new int[2]; //A팀 2명씩 시너지
	static int[] sinB = new int[2]; //B팀 2명씩 시너지
	static int sumA; //A팀의 총 시너지
	static int sumB; //B팀의 총 시너지
	static int result=Integer.MAX_VALUE; //결과값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		teamA = new int[N / 2];
		for (int i = 0; i < N / 2; i++) {
			teamA[i] = i;
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of reading

		makeTeam(0, 0); // 조합으로 각 팀의 경우의수 만들기
		System.out.println(result);
	}

	private static void makeTeam(int start, int cnt) {
		if (cnt == N / 2) { // 각 경우의 수 마다 계산 실행
//			System.out.println("A:"+Arrays.toString(teamA));
			solve();
			return;
		}

		for (int i = start; i < N; i++) {// 경우의 수 만드는 로직
			teamA[cnt] = i;
			makeTeam(i + 1, cnt + 1);
		}
	}

	private static void solve() {
		chk = new boolean[N];
		teamB = new int[N / 2];
		int idx = 0;

		// teamA에 없는 인원 teamB로 만들기
		for (int i = 0; i < N / 2; i++) {
			chk[teamA[i]] = true;
		}

		for (int i = 0; i < N; i++) {
			if (!chk[i])
				teamB[idx++] = i;
		}
		
		sumA=0;
		sumB=0;
		makeSum(0,0); //각 팀이 가지고 있는 인원으로 시너지 계산(조합)
		
		result = Math.min(result, Math.abs(sumA-sumB));
		
		
//		System.out.println("B:"+Arrays.toString(teamB));

	}

	private static void makeSum(int start,int cnt) {
		if(cnt ==2) { //각 팀에서 2명씩 뽑아서 시너지 계산
			sumA += map[teamA[sinA[0]]][teamA[sinA[1]]] + map[teamA[sinA[1]]][teamA[sinA[0]]];
			sumB += map[teamB[sinB[0]]][teamB[sinB[1]]] + map[teamB[sinB[1]]][teamB[sinB[0]]];
			return;
		}
		
		for (int i = start; i < N/2; i++) {
			sinA[cnt]=i;
			sinB[cnt]=i;
			makeSum(i+1,cnt+1);
		}
	}
}
