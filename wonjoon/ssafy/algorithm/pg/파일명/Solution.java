package com.ssafy.algorithm.pg.파일명;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	static List<String> files1 = Arrays.asList("img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF",
			"img2.JPG");

	static List<String> files2 = Arrays.asList("F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
			"F-14 Tomcat");

	public static void main(String[] args) {

//		System.out.println(Arrays.toString(solution(files1)));
		System.out.println(Arrays.toString(solution(files2)));
	}

	static String[] solution(List<String> files) {
		List<File> fs = new ArrayList<>();
		for (String file : files) {

			String head = "";
			String number = "";
			String tail = "";

			File f = new File();

			boolean flag = false;
			for (char c : file.toCharArray()) {

				if (!flag) {
					if (c == '.') {
						flag = true;
						tail += c;
						continue;
					}
					if (Character.isDigit(c)) {
						number += c;

					} else {
						head += c;
					}

				} else {
					tail += c;
				}

			}
			f.head = head;
			f.number = number;
			f.tail = tail;

			System.out.println(f);
			fs.add(f);
		}

		Collections.sort(fs);

		String[] ans = new String[fs.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = fs.get(i).getName();
		}

		return ans;
	}
}

class File implements Comparable<File> {

	String head;
	String number;
	String tail;

	String getName() {
		return head + number + tail;
	}

	@Override
	public String toString() {
		return "File [head=" + head + ", number=" + number + ", tail=" + tail + "]";
	}

	@Override
	public int compareTo(File o) {
		return Integer.parseInt(number) - Integer.parseInt(o.number);
	}

}