import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413_S3_단어뒤집기2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String s = sc.nextLine();
		int tag = 0;	// '<'가 등장한 횟수
		
		for (char c : s.toCharArray()) {
			switch (c) {
			case '<':
				// 태그 처리를 시작하기 전, 스택에 남아있는 문자가 있다면 먼저 출력해준다.
				while (!stk.isEmpty())
					sb.append(stk.pop());
				
				tag++;
				sb.append(c);
				break;
				
				
			case '>':
				tag--;
				sb.append(c);
				break;
				
				
			case ' ':
				// 공백 문자를 만났을 때, 태그 내부가 아니라면 스택에 있는 문자들을 출력해준다.
				if (tag == 0) {
					while (!stk.isEmpty())
						sb.append(stk.pop());
					sb.append(" ");
				}
				
				// 태그 내부에서 공백 문자를 만났다면 순서에 맞게 그대로 출력해준다.
				else sb.append(c);
				break;
				
				
			default:	// 공백도, 태그도 아닌 문자를 만났다면
				
				// 태그 밖의 문자라면 스택에 저장한다. (역순으로 출력하기 위함)
				if (tag == 0)
					stk.add(c);
				
				// 태그 안의 문자라면 순서에 맞게 그대로 출력해준다.
				else
					sb.append(c);
				break;
			}
		}
		
		// 혹시라도 스택에 남아있는 문자들이 있다면 출력해준다.
		while (!stk.isEmpty())
			sb.append(stk.pop());
		
		
		System.out.println(sb);
	}

}
