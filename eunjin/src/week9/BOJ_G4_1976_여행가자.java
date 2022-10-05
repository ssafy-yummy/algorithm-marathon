package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1976_여행가자 {

	static int N, M, map[][], trip[], root[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(N==0 || M==0) {	// 예외처리
			System.out.println("NO");
			return;
		}
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		trip = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			trip[i] = Integer.parseInt(st.nextToken())-1;
		} // read
		
		// 1. 각 도시의 root를 자신으로 초기화.
		make();

		// 2. root가 같은 도시 집합을 합친다.
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(map[i][j] == 1) {	// 1이라면 연결되어 있는 것이므로 root를 바꿔준다.
					//root[j] = i;
					union(i, j);
				}
			}
		}

		// 3. 여행 하려는 나라들의 root가 모두 같다면 이어져 있는 것이다.
		int first = 0;
		for (int i = 0; i < M; i++) {
			if(i==0) {
				first = find(trip[0]);	// 첫 번째 나라의 root
				continue;
			}
			
			int temp = find(trip[i]);	// 두 번째 이후의 나라 root 구하기
			
			if(first != temp) {	// 같은 root를 공유하지 않은 경우 즉, 두 도시는 만나지 않는다.
				System.out.println("NO");
				break;
			}
			
			if(i==M-1) System.out.println("YES");
		}
	}
	

	private static void union(int a, int b) {
		if(root[a] == root[b]) return;
		a = find(a);
		b = find(b);
		if(a<b) root[b] = root[a];
		else root[a] = root[b];
	}

	private static int find(int x) {
		if(root[x] == x) return x;
		return root[x] = find(root[x]);
	}

	private static void make() {
		root = new int[N];
		for (int i = 0; i < N; i++) {
			root[i] = i;
		}
	}

}
