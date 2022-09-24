package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413_S3_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// '<', '>'를 기준으로 문자열 자르고 배열 'arr'에 저장
		String[] arr = str.split("<|>");

		// 배열'arr'의 길이
		int len = arr.length;
		
		// 출력할 문자열 만들기
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2;
		for (int i = 0; i < len; i++) {
			if(i%2==1) {	// <>안에 있는 글자
				sb.append("<").append(arr[i]).append(">");
			} else {	// <>밖에 있는 글자
				// ' '공백을 기준으로 문자열 자르고 배열 'arr2'에 저장
				String[] arr2 = arr[i].split(" ");
				for(String st: arr2) {
					sb2 = new StringBuilder();
					sb2.append(st).reverse().append(" ");	// 문자열 반전 -> 문자열 추가
					sb.append(sb2.toString());	// 마지막 공백 추가
				}
				sb.setLength(sb.length()-1);	// 마지막 공백 제거
			}
		}
		
		System.out.println(sb.toString());
			
	}
}
