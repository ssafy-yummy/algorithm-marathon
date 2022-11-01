import java.util.Scanner;

public class BOJ_8394_S3_악수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 회의에 참석한 사람 수
				
		int prev0;	// 내 왼쪽 사람이 악수를 안 하는 경우의 수
		int prev1;	// 내 왼쪽 람이 왼쪽 사람과 악수를 하는 경우의 수

		int now0;	// 현재 탐색 중인 사람이 악수를 안 하는 경우의 수
		int now1;	// 현재 탐색 중인 사람이 왼쪽 사람과 악수를 하는 경우의 수

		prev0 = 1;	// 0번째 사람이 악수를 안 하는 경우의 수는 1가지
		prev1 = 0;	// 0번째 사람이 왼쪽 사람과 악수를 하는 경우의 수는 0가지
		now0 = now1 = 0;
		
		for (int i = 1; i < N; i++) {
			now0 = (prev0 + prev1) % 10;	// 현재 사람이 악수를 안하는 경우의 수는, 왼쪽 사람의 모든 경우의 수와 같다.
			now1 = prev0 % 10;				// 현재 사람이 왼쪽 사람과 악수를 하려면, 왼쪽 사람이 왼쪽 왼쪽 사람과 악수를 해선 안 된다.
			prev0 = now0;
			prev1 = now1;
		}
		
		System.out.println((now0 + now1) % 10);
	}

}
