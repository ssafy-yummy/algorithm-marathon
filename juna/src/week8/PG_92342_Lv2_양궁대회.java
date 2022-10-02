import java.util.Arrays;

class PG_92342_Lv2_양궁대회 {
	
	static int diff;	// 라이언과 어피치의 점수 차이 최댓값
	static int[] ret = new int[] {-1};	// 정답

	
	
	
    public int[] solution(int n, int[] info) {
       
        dfs(0, 0, 0, n, info, new int[11]);     
        return ret;
    }
    
    
    
    
    // i		: i번째 과녁을 탐색 중 (10 - i점 과녁)
    // score1	: 여태까지 라이언이 획득한 점수
    // score2	: 여태까지 어피치가 획득한 점수
    // n		: 앞으로 라이언이 쏠 수 있는 화살의 수
    // info[i]	: 어피치가 i번째 과녁에 몇 개의 화살을 맞췄는지 
    // answer[i]: 라이언이 i번째 과녁에 몇 개의 화살을 맞췄는지
	private void dfs(int i, int score1, int score2, int n, int[] info, int[] answer) {
		
		// 라이언이 정해진 화살 수 보다 더 많이 쏘았다면 유효한 탐색이 아님. 즉시 함수 종료
		if (n < 0) return ;
		
		
		// 10번째 과녁까지 모두 탐색했다면, 정답을 갱신해주기
		if (i == 11) {
			
			// 모든 과녁에 대하여 탐색을 끝마쳤는데도 불구하고 아직 남아있는 화살이 있다면,
			// 제일 점수가 작은 과녁(10번째 과녁)에 남아있는 화살을 모두 쏘아주기.
			if (n > 0) answer[10] += n;
			
			
			// 라이언과 어피치의 점수 차이(score1 - score2)가 예전에 구해놨던 점수 차이(diff)보다 더 크다면
			// 정답(ret)과 점수 차이(diff)를 갱신해주기
			if (diff < score1 - score2) {
				diff = score1 - score2;
				ret = answer;
			}
			
			// 라이언과 어피치의 점수 차이(score1 - score2)가 예전에 구해놨던 점수 차이(diff)와 같다면
			// 점수가 작은 과녁을 더 많이 맞춘 케이스가 정답이다.
			else if (diff > 0 && diff == score1 - score2) {
				
				for (int j = 10; j > -1; j--) {
					if (ret[j] == answer[j]) continue;
					
					if (ret[j] < answer[j]) ret = answer;
					
					break;
				}
			}
			
			// 함수 종료
			return ;
		}
		
		
		// (1) 10 - i점 과녁을 아무도 못 가져가는 경우
		if (info[i] == 0) {
			int[] answer0 = Arrays.copyOf(answer, 11);
			dfs(i + 1, score1, score2, n, info, answer0);
		}
		
		// (2) 10 - i점 과녁을 어피치가 가져가는 경우
		else {
			int[] answer1 = Arrays.copyOf(answer, 11);
			dfs(i + 1, score1, score2 + 10 - i, n, info, answer1);
		}
		
		// (3) 10 - i점 과녁을 라이언이 가져가는 경우
		int[] answer2 = Arrays.copyOf(answer, 11);
		answer2[i] = info[i] + 1;
		dfs(i + 1, score1 + 10 - i, score2, n - answer2[i], info, answer2);
		
		
	}
}