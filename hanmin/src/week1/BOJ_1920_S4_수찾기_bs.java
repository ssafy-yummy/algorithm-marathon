import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기_bs {
	// N, M 100000
	// 수의 범위 Integer
	// arr배열에 저장 후 정렬, 이분탐색을 사용해 존재하는지 확인
	// add O(1) * N = O(N)
	// sort O(NlogN)
	// func O(logN) * M = O(MlogN);
	// 총 시간복잡도 O(NlogN + MlogN)
	static int[] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		Arrays.sort(arr);
		for (int i = 0; i < M; ++i) {
			int flg = 1;
			int tmp = Integer.parseInt(st.nextToken());
			func(tmp);
		}
		br.close();
	}

	static void func(int num) {
		int l = 0;
		int r = N - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == num) {
				System.out.println(1);
				return;
			} else if (arr[mid] < num) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(0);
	}

}
