package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23291_P5_어항정리 {
	static int n, k;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n][n];
		int answer = -1;
		for (int i = 0; i < n; i++) {
			arr[n - 1][i] = Integer.parseInt(st.nextToken()); // 그림 1
		}

		for (int c = 0;; c++) {
			
			if (!oneMore()) { // 종료 조건
				answer = c;
				break;
			}

			putOneFish(); // 그림 2
			//printArr("putOneFish");
			makeFloor(); // 그림 3 ~ 그림 6
			//printArr("makeFloor");
			spreadFish(); // 그림 7
			//printArr("spreadFish");
			makeLine(); // 그림 8
			//printArr("makeLine first- "+(c+1));
			makeFloor2(); // 그림 9 ~ 그림 10
			//printArr("makeFloor2");
			spreadFish(); // 그림 11
			//printArr("spreadFish");
			makeLine(); // 그림 12
			//printArr("makeLine second- "+(c+1));
			
		}

		System.out.println(answer);

	}

	private static void printArr(String str) {
		System.out.println("["+str+"]");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");

	}

	private static void makeFloor2() {
		for (int j = 0; j < n / 2; j++) {
			arr[n - 1 - 1][n - 1 - j] = arr[n - 1][j];
			arr[n - 1][j] = 0;
		}
		//printArr("makeFloor2 - 1");
		if(n==4) {
			arr[1][3] = arr[2][2];
			arr[2][2]=0;
			arr[0][3] = arr[3][2];
			arr[3][2]=0;
			return;
		}
		for (int i = n - 1 - 1; i < n; i++) {
			for (int j = n / 2; j < n / 2 + n / 4; j++) {
				arr[n - 1 - 1 + n - 1 - i - 2][n / 2 + n / 2 + n / 4 - 1 - j + n / 4] = arr[i][j];
				arr[i][j] = 0;
			}
		}
		//printArr("makeFloor2 - 2");

	}

	private static void makeLine() {
		int[] temp = new int[n];
		int index = 0;

		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i][j] == 0)
					continue;
				temp[index++] = arr[i][j];
				arr[i][j] = 0;
			}
		}

		for (int j = 0; j < n; j++) {
			arr[n - 1][j] = temp[j];
		}

	}

	private static void spreadFish() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					if (arr[nx][ny] == 0)
						continue;

					if (arr[i][j] > arr[nx][ny]) {
						copy[i][j] -= (int) ((arr[i][j] - arr[nx][ny]) / 5);
					} else if (arr[i][j] < arr[nx][ny]) {
						copy[i][j] += (int) ((arr[nx][ny] - arr[i][j]) / 5);
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = copy[i][j];
			}
		}

	}

	private static void makeFloor() {
		int w = 1;
		int h = 1;
		// 1x1 1x2 2x2 2x3 3x3 3x4 .......
		int start = 0;

		for (int c = 1;; c++) {
			int[][] temp1 = new int[h][w];
			int[][] temp2 = new int[w][h];

			for (int i = n - h; i < n; i++) {
				for (int j = start; j < start + w; j++) {
					temp1[i - (n - h)][j - (start)] = arr[i][j];
					arr[i][j] = 0;
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					temp2[j][h - 1 - i] = temp1[i][j];
				}

			}
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					arr[n - 1 - w + i][start + w + j] = temp2[i][j];
				}
			}

			start += w;

			if (c % 2 == 1) {
				h++;
			} else {
				w++;
			}

			if (start + w + h > n) {
				break;
			}
		}

	}

	private static void putOneFish() {
		int min = 10001;
		for (int i = 0; i < n; i++) {
			if (arr[n - 1][i] < min) {
				min = arr[n - 1][i]; // 가장 적은 물고기를 가지는 어항을 찾기 위해
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[n - 1][i] == min) {
				arr[n - 1][i]++; // 가장 적은 물고기를 가지는 어항에 물고기 +1
			}
		}

	}

	private static boolean oneMore() {
		int max = 0;
		int min = 10001;

		for (int i = 0; i < n; i++) {
			if (arr[n - 1][i] > max) {
				max = arr[n - 1][i];
			}
			if (arr[n - 1][i] < min) {
				min = arr[n - 1][i];
			}
		}
		if (max - min <= k)
			return false;
		return true;

	}

}
