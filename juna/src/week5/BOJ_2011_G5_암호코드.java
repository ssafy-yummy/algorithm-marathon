import java.util.Scanner;

public class BOJ_2011_G5_암호코드 {

	public static void main(String[] args) {
		
		// 1. 입력 받기
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		int[] password = new int[tmp.length()];	// 입력받은 문자열 tmp를 int형으로 변환하여 담을 배열 
		int size = 0;							// password 배열의 크기
		
		
		
		for (int j = 0; j < tmp.length(); j++) {
			
			password[size] = tmp.charAt(j) - '0';
			
			// 현재 탐색 중인 숫자가 0이라면 -> 반드시 그 전의 숫자와 합쳐서 저장한다.
			// 예를 들어 문자열 '120'이 입력되었다면 password에는 {1}, {2}, {0}이 아닌 {1}, {20}이 저장된다.
			if (password[size] == 0) {	 
				if (size > 0 && password[size - 1] < 3 && password[size - 1] > 0)
					password[size - 1] *= 10;
				else {
					// 만일 입력받은 숫자 0을 그 전의 숫자와 합치는 것이 불가능하다면,
					// 암호 자체가 잘못된 것이므로 0을 출력하고 프로그램을 종료한다.
					System.out.println(0);
					return ;
				}
			}
			else
				size++;	// 숫자 0이 입력된 경우를 제외하고는 password의 배열 크기가 1개 증가한다.
		}
		
		
		
		// password에 담긴 숫자가 단 1개뿐이라면, 정답은 1이고 프로그램을 종료한다.
		if (size == 1) {
			System.out.println(1);
			return;
		}

		
		
		// chk[i] : i번째 숫자와 i + 1번째 숫자를 결합시켰을 때, 알파벳을 만들 수 있는가?
		boolean[] chk = new boolean[size - 1];
		
		for (int i = 0; i < size - 1; i++)
			if (password[i] == 1 || (password[i] == 2 && password[i + 1] < 7))
				chk[i] = true;
		
		
		// dp[i] : 0번째 부터 i번째 까지 숫자들을 가지고 만들 수 있는 암호의 개수
		// 일반적으로는 dp[i] = dp[i - 2] + dp[i - 1]이 성립한다. 단 예외 상황이 2가지 있다.
		int[] dp = new int[size];
		dp[0] = 1;
		dp[1] = chk[0] ? 2 : 1;
		
		for (int i = 2; i < size; i++) {
			// 1번. 두 개의 숫자를 결합시켜 알파벳을 만들 수 없는 경우(!chk[i - 1]),
			// 2번. 중간에 0이 껴 있는 경우(password[i] > 9 || password[i - 1] > 9)
			// 이 두 가지 경우에는 dp[i - 2]값을 취할 수 없다.
			dp[i] = !chk[i - 1] || password[i] > 9 || password[i - 1] > 9 ? dp[i - 1] : (dp[i - 2] + dp[i - 1]) % 1000000;
		}
		
		System.out.println(dp[size - 1]);
	}
}