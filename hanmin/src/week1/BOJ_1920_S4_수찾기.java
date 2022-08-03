import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	// N, M 100000
	// 수의 범위 Integer
	// HashSet에 저장 후 contains를 사용해 존재하는지 확인
	// add O(1) * N = O(N)
	// contains O(1) * M = O(M);
	// 총 시간복잡도 O(N+M)
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Set<Integer> s = new HashSet<>();
		// HashSet에 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			int flg = 1;
			// contains를 사용해 존재하는지 확인
			// 없을 시 0
			if (!s.contains(Integer.parseInt(st.nextToken()))) {
				flg = 0;
			}
			// 출력
			System.out.println(flg);
		}
		br.close();
	}
}
