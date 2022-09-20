package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17413_S3_단어뒤집기2 {

	static char[] cs;
	static ArrayList<Character> tmp, ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tmp = new ArrayList<>();
		ans = new ArrayList<>();

		cs = br.readLine().toCharArray();

		boolean isTag = false;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '<') {
				if (tmp.size() > 0) {
					for (int j = tmp.size() - 1; j >= 0; j--) {
						ans.add(tmp.get(j));

					}
					tmp.clear();
				}
				isTag = true;
			}

			if (cs[i] == '>') {
				isTag = false;
				ans.add(cs[i]);
				continue;
			}
			if (isTag) {
				ans.add(cs[i]);
				continue;
			}

			if (cs[i] == ' ') {
				for (int j = tmp.size() - 1; j >= 0; j--) {
					ans.add(tmp.get(j));
				}
				ans.add(' ');
				tmp.clear();
			} else {
				tmp.add(cs[i]);
			}
		}

		for (int j = tmp.size() - 1; j >= 0; j--) {
			ans.add(tmp.get(j));
		}

		for (Character c : ans) {
			System.out.print(c);
		}
	}
}
