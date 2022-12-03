package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20922_S1_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int len = 0;
		int start = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int end = 0; end < n; end++) {
			int x = arr[end];
			if (map.containsKey(x)) { // map에서 원소를 가지고 있다
				if (map.get(x) + 1 > m) { // 제한 개수를 넘기면
					answer=Math.max(answer, len);
					while (arr[start] != x) {
						map.put(arr[start], map.get(arr[start]) - 1); // 보유 감소
						if (map.get(arr[start]) == 0)
							map.remove(arr[start]);
						len--;
						start++;
					}
					start++;
				} else {
					map.put(x, map.get(x) + 1); // 보유 개수 증가
					len++;
				}
			} else { // 처음보는 원소
				map.put(x, 1);
				len++;
			}
		}
		answer=Math.max(answer, len);

		System.out.println(answer);
	}
}
