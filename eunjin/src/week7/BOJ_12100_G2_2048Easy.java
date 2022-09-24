package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_G2_2048Easy {

	static int N, map[][], ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //read
		
		for (int i = 0; i < 4; i++) {	// 최대 5번 이동할 수 있음. 첫 번째 이동
			int[][] copy1 = new int[N][N];
			copy1 = move(i, map);
			for (int j = 0; j < 4; j++) {	// 두 번째 이동
				int[][] copy2 = new int[N][N];
				copy2 = move(j, copy1);
				for (int k = 0; k < 4; k++) {	// 세 번째 이동
					int[][] copy3 = new int[N][N];
					copy3 = move(k, copy2);
					for (int l = 0; l < 4; l++) {	// 네 번째 이동
						int[][] copy4 = new int[N][N];
						copy4 = move(l, copy3);
						for (int m = 0; m < 4; m++) {	// 다섯 번째 이동
							int[][] copy5 = new int[N][N];
							copy5 = move(m, copy4);
							answer(copy5);	// 가장 큰 숫자 찾아서 ans 변수에 저장
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}

	private static int[][] move(int dir, int[][] arr) {	// dir: 0:위로, 1:아래로, 2:왼쪽으로, 3:오른쪽으로
		// 새로운 2차원 배열 만들고 이를 반환할 것임
		int[][] arr2 = new int[N][N];
		
		int temp;	// 이동했을 때 같은 숫자끼리 만나서 더할 수 있는지 확인
		switch (dir) {
		case 0:
			for (int c = 0; c < N; c++) {
				temp = 0;
				for (int r = 0, k = 0; r < N; r++) {
					if(arr[r][c]!=0) {
						if(temp==arr[r][c]) {	// 같은 수 두개가 만나 합쳐짐
							arr2[--k][c] = temp*2;
							temp = 0;
						} else {
							arr2[k][c] = arr[r][c];
							temp = arr[r][c];
						}
						k++;
					}
				}
			}
			break;
			
		case 1:
			for (int c = 0; c < N; c++) {
				temp = 0;
				for (int r = N-1, k = N-1; r >= 0; r--) {
					if(arr[r][c]!=0) {
						if(temp==arr[r][c]) {	// 같은 수 두개가 만나 합쳐짐
							arr2[++k][c] = temp*2;
							temp = 0;
						} else {
							arr2[k][c] = arr[r][c];
							temp = arr[r][c];
						}
						k--;
					}
				}
			}
			break;
			
		case 2:
			for (int r = 0; r < N; r++) {
				temp = 0;
				for (int c = 0, k = 0; c < N; c++) {
					if(arr[r][c]!=0) {
						if(temp==arr[r][c]) {	// 같은 수 두개가 만나 합쳐짐
							arr2[r][--k] = temp*2;
							temp = 0;
						} else {
							arr2[r][k] = arr[r][c];
							temp = arr[r][c];
						}
						k++;
					}
				}
			}
			break;
			
		case 3:
			for (int r = 0; r < N; r++) {
				temp = 0;
				for (int c = N-1, k = N-1; c >= 0; c--) {
					if(arr[r][c]!=0) {
						if(temp==arr[r][c]) {	// 같은 수 두개가 만나 합쳐짐
							arr2[r][++k] = temp*2;
							temp = 0;
						} else {
							arr2[r][k] = arr[r][c];
							temp = arr[r][c];
						}
						k--;
					}
				}
			}
			break;
		}
		
		return arr2;
	}

	private static void answer(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, arr[i][j]);
			}
		}
	}

}
