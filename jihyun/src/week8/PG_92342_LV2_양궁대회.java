package week8;

public class PG_92342_LV2_양궁대회 {
	public static void main(String[] args) {
		int n = 10;
		int[] info = { 0,0,0,0,0,0,0,0,3,4,3 };
		Solution s = new Solution();
		int[] result = s.solution(n, info);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

class Solution {
	static int[] temp = new int[11]; // dfs로 나온 라이언의 결과. 
	static int max = 0; // 어피치 와 라이언의 최대 차이. max가 끝까지 0이면 {-1}을 리턴해야함.
	static int[] max_arr = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }; //현재 최대 점수차이를 가지는 라이언의 결과

	public int[] solution(int n, int[] info) {
		int[] answer = max_arr;

		dfs(0, 0, n, info); 
		
		if(max==0)
			return new int[]{-1};
		else
			return answer;
	}

	private static void dfs(int start, int count, int n, int[] info) {
		for (int i = start; i < 11; i++) {
			if (count + info[i] + 1 <= n) { //어피치가 쏜 개수보다 1발 더 쏘는게 가능하다면
				temp[i] = info[i] + 1; 
				dfs(i + 1, count + info[i] + 1, n, info);
				temp[i] = 0;
			}
		}
		
		int apeach_sum = 0;
		int ryan_sum = 0;
		for(int i=0; i<11; i++) {
			if(info[i]==0 && temp[i]==0) //둘다 1발도 맞추지 못했다면 아무도 점수획득하지 못한다.
				continue;
			else if(info[i]>=temp[i]) //어피치가 라이언보다 같거나많은 개수를 쐈다면 어피치 점수 획득
				apeach_sum+=10-i;
			else //라이언이 어피치보다 많은 개수를 쐈다면 라이언 점수 획득
				ryan_sum+=10-i;
		}
		temp[10]+=(n-count); //남은 화살은 0점에 추가해준다. (우승할 방법이 여러가지 인 경우 가장 낮은 점수를 더 많이 쏴야 하므로)
		
		if(ryan_sum<=apeach_sum) { //라이언의 점수가 어피치 보다 낮은 경우
			temp[10]-=(n-count); //다시 0점 화살에 추가한 개수를 빼준다.
			return;
		}
		
		if(ryan_sum-apeach_sum > max) { //라이언이 최대점수차로 어피치를 이겼다면
			max = ryan_sum-apeach_sum; //최대점수차를 갱신하고
			for(int i=0;i<11;i++) { //정답을 갱신한다.
				max_arr[i]=temp[i];
			}
		}
		else if(ryan_sum-apeach_sum == max) { //라이언의 최대점수차와 같게 어피치를 이겼다면
			for(int i=10; i>=0; i--) { //낮은 점수부터 비교한다.
				if(max_arr[i]==temp[i]) //같은 발을 쐈다면 넘어가고
					continue;
				else if(max_arr[i] < temp[i] ) { //현재 라이언이 더 많이 쐈다면
					for(int j=0;j<11;j++) { //정답을 갱신한다.
						max_arr[j]=temp[j];
					}
					break;
				}
				else //과거 라이언이 더 많이 쐈다면 현재 라이언은 정답을 갱신할 수 없다.
					break;
			}
		}
		
		temp[10]-=(n-count); //다시 0점 화살에 추가한 개수를 빼준다.
	}
}
