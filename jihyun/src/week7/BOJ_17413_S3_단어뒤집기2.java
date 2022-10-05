package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413_S3_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='<') { //태그가 열리면
				sb.append(temp); //뒤집힌 문자열 정답에 추가
				temp = new StringBuilder(); //뒤집힌 문자열 저장할 공간 초기화
				while(str.charAt(i)!='>') { //태그가 닫힐때까지
					sb.append(str.charAt(i)); //문자를 바로 정답 문자열에 더한다.
					i++; //다음 문자열로 이동
				}
				sb.append(">"); //닫힘태그 추가
			}
			else if(str.charAt(i)==' ') { //띄어쓰기면 단어가 끝난다.
				sb.append(temp).append(" "); //뒤집힌 문자열과 띄어쓰기 정답 문자열에 더한다
				temp = new StringBuilder(); //뒤집힌 문자열 저장할 공간 초기화
			}
			else {
				temp.insert(0,str.charAt(i)); //단어 문자열을 뒤집어야 하므로 맨 앞에 한글자씩 추가
			}
		}
		sb.append(temp);
		System.out.println(sb.toString());
	}
}
