package com.ssafy.algorithm.pg.파일명;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
	static String[] files1 = new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF",
			"img2.JPG" };

	static String[] files2 = new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
			"F-14 Tomcat" };

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(files1)));
		System.out.println(Arrays.toString(solution(files2)));
	}

	static String[] solution(String[] files) {
		// Comparator를 구현해서 정렬한다.

		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {

				// 비교할 문자열을 head, number, tail로 분리시켜준다.
				String[] file1 = separate(s1);
				String[] file2 = separate(s2);

				// head를 비교한다. 두 값이 같을 경우 comareTo 에서 0을 반환한다.
				int headValue = file1[0].compareTo(file2[0]);

				// head가 같을 경우
				if (headValue == 0) {
					// number를 비교한다.
					int num1 = Integer.parseInt(file1[1]);
					int num2 = Integer.parseInt(file2[1]);

					// 음수면 오름차순
					// 양수면 내림차순 으로 자리 바꿈
					return num1 - num2;
				} else {
					// head 값이 다르면 숫자 비교X
					return headValue;
				}
			}
		});
		return files;
	}

	static String[] separate(String str) {
		String head = "";
		String number = "";
		String tail = "";

		int idx = 0;
		// idx 로 str를 순회하면서 head, number, tail를 구분시켜준다.
		for (; idx < str.length(); ++idx) {
			char ch = str.charAt(idx);
			if (ch >= '0' && ch <= '9')
				break;
			head += ch;
		}

		for (; idx < str.length(); ++idx) {
			char ch = str.charAt(idx);
			if (!(ch >= '0' && ch <= '9'))
				break;
			number += ch;
		}

		for (; idx < str.length(); ++idx) {
			char ch = str.charAt(idx);
			tail += ch;
		}

		// head 는 소문자로 통일 시켜서 비교할 때 변수 차단
		String[] file = { head.toLowerCase(), number, tail };

		return file;

	}

}
