package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_17413_S3_단어뒤집기2 {
	static List<Character> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char st[] = new char[str.length()];
		st = str.toCharArray();
		int len = str.length();
		
		int s_index = 0;
		int e_index = 0;
		
		// 전체 문자열 길이보다 작을때 반복문
		while(s_index<len && e_index<len) {
			// 태그가 있을 경우
			if(st[e_index]=='<') {
				// '<' 나오기전에 단어가 있을 경우 출력
				for (int i = e_index-1; i >= s_index; i--) {
					System.out.print(st[i]);
				}
				s_index = e_index;
				
				// 닫는 꺽새가 나올때까지 정방향 출력
				while(st[e_index]!='>') {
					System.out.print(st[e_index]);
					s_index++; e_index++;
				}
				System.out.print(st[e_index]);
				s_index++;
			}
			// 공백이 있을 경우
			if(st[e_index]==' ') {
				// 역방향 출력
				for (int i = e_index-1; i >= s_index; i--) {
					System.out.print(st[i]);
				}
				System.out.print(st[e_index]);
				s_index = e_index+1;
				e_index = s_index;
			}
			
			e_index++;
		}
		
		// 남은 문자열이 출력이 안되었을 경우
		if(s_index!=e_index) {
			for (int i = e_index-1; i >= s_index; i--) {
				System.out.print(st[i]);
			}
		}
	}
}
