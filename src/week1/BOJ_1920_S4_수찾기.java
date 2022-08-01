package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	static int m, n;
	static int lt, rt;
	static int[] targetArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		targetArr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < targetArr.length; i++) {
			targetArr[i] = Integer.parseInt(st.nextToken());
		}

		// 탐색 전 타겟 리스트 정렬
		Arrays.sort(targetArr);

		m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		// System.out은 느려서 String Builder 사용
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			if (findTarget(Integer.parseInt(st.nextToken()))) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());

	}

	// target을 찾아주는 함수
	static boolean findTarget(int num) {
		// 배열을 이분 탐색하기 위해 투 포인터사용
		lt = 0;
		rt = n - 1;

		while (lt <= rt) {
			// 맨 앞과 맨 뒤의 중앙값을 구해서 타켓인지 확인
			int mid = (rt + lt) / 2;
			// 타겟이면 찾았으므로 return true
			if (targetArr[mid] == num) {
				return true;

				// 찾고자 하는 값이 target보다 크면 left값을 중앙값(mid) 뒤로 당겨준다.
			} else if (num > targetArr[mid]) {
				lt = mid + 1;

				// 반대로 target보다 작으면 right 값을 mid 앞으로 당겨준다.
			} else {
				rt = mid - 1;
			}
		}

		// 못 찾으면 false;
		return false;
	}
}
