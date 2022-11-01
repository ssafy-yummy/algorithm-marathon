import java.util.Scanner;

public class BOJ_12904_G5_A와B {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 원본 문자열
		String S = sc.nextLine();
		// 변경된 문자열
		StringBuffer T = new StringBuffer(sc.nextLine());		
		
		// 역으로 T에서 문자를 제거해가며 S를 만들기
		while (T.toString().length() > S.length()) {
		
			char last = T.charAt(T.length() - 1);
			
			// 맨 뒤 글자 제거
			T.deleteCharAt(T.length() - 1);
			
			// 제거한 맨 뒤 글자가 B 였으면 뒤집기
			if (last == 'B') T.reverse();
		}
		
		System.out.println(T.toString().equals(S) ? 1 : 0);
	}

}
