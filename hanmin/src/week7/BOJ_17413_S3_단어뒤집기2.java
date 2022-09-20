package hanmin.src.week7;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413_S3_단어뒤집기2 {
	static String answer = "";

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// start
		int tagFlg = 0;
		String tmp = "";
		for (int i = 0; i < input.length(); ++i) {
			char now = input.charAt(i);
			//태그 구분
			if (tagFlg == 1) {
				answer += now;
				if (now == '>') {
					tagFlg = 0;
				}
			} else {//태그가 아니라면 뒤집기
				if (now == '<' || now == ' ') {
					for (int j = tmp.length() - 1; j >= 0; --j) {
						answer += tmp.charAt(j);
					}
					tmp = "";
					if (now == '<') {
						tagFlg = 1;
						i--;
					} else {
						answer += ' ';
					}
					continue;
				}
				tmp += now;
			}
		}
		//마지막 값 추가
		if (tmp.length() != 0)
			for (int j = tmp.length() - 1; j >= 0; --j) {
				answer += tmp.charAt(j);
			}
		// end

		// 출력
		System.out.println(answer);
	}
}
