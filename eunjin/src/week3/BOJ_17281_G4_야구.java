package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구 {

	static int N, ans;
	static int[][] pScore;
	static int[] pCombi = new int[9];
	static boolean visited[] = new boolean[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pScore = new int[N][9];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				pScore[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 선수들의 순열 구하기 (4번타자는 0번 선수로 고정)
		perm(0);
		
		System.out.println(ans);
	}
	private static void perm(int cnt) {	// 8P8 = 40,320
		if(cnt==9) {
			// 2. 경기시작
			int score = round();
			
			// 스코어 계산
			ans = Math.max(ans, score);
			return;
			
		}
		for (int i = 1; i < 9; i++) {
			if(cnt==3) {
				perm(cnt+1);
				break;
			} else {
				if(visited[i]) continue;
				visited[i]=true;
				pCombi[cnt] = i;
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}
	
	private static int round() {
		int pNum = -1;
		int score = 0;
		int temp;
		
		for(int i=0; i<N; i++) {	// 총 이닝수만큼 돌기
			
			int outCount = 0;	// 아웃 카운트
			int[] on = new int[3];	// 1루, 2루, 3루에 사람이 있는지
			
			while(true) {
				pNum = (pNum+1)%9;	// 다음 타자가 선다
				temp=0;
				
				if(pScore[i][pCombi[pNum]]==0) {	// 아웃
					if(++outCount==3) break;	// 3번 아웃 당하면 공수교대
				} else if(pScore[i][pCombi[pNum]]==1) {	// 안타
					temp = on[2];
					on[2] = on[1];
					on[1] = on[0];
					on[0] = 1;
				} else if(pScore[i][pCombi[pNum]]==2) {	// 2루타
					temp = on[2]+on[1];
					on[2] = on[0];
					on[1] = 1;
					on[0] = 0;
				} else if(pScore[i][pCombi[pNum]]==3) {	// 3루타
					temp = on[2]+on[1]+on[0];
					on[2] = 1;
					on[1] = 0;
					on[0] = 0;
				} else if(pScore[i][pCombi[pNum]]==4) {	// 홈런
					temp = on[2]+on[1]+on[0]+1;
					on[2] = 0;
					on[1] = 0;
					on[0] = 0;
				}
				score += temp;
			}
		}
		return score;
	}
}
