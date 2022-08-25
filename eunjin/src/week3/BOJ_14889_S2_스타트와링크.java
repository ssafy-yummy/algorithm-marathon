package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_S2_스타트와링크 {
	
	static int N, R, map[][];
	static int[] teamA, teamB;
	static int[] select = new int[2];
	static int scoreA, scoreB, minScore=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		R = N/2;
		map = new int[N][N];
		teamA = new int[R];
		teamB = new int[R];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // read

		combi(1,1);
		System.out.println(minScore);
	}

	private static void combi(int start, int cnt) {
		if(cnt==R) {
			for(int i=0, a=0, b=0; i<N; i++) {
				if(b==R) break;
				else if(a==R) teamB[b++] = i;
				else if(teamA[a]==i) a++;
				else teamB[b++] = i;
			}
			scoreA = combi2(teamA);
			scoreB = combi2(teamB);
			minScore = Math.min(minScore, Math.abs(scoreA-scoreB));
			return;
		}
		for(int i=start; i<N; i++) {
			teamA[cnt] = i;
			combi(i+1, cnt+1);
		}
	}

	private static int combi2(int[] arr) {
		int total = 0;
		for(int i=0; i<R; i++) {
			select[0] = arr[i];
			for(int j=i+1; j<R; j++) {
				select[1] = arr[j];
				total += map[select[0]][select[1]] + map[select[1]][select[0]];
			}
		}
		return total;
	}
}
