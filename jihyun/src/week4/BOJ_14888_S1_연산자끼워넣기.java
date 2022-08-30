package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_S1_연산자끼워넣기 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	static int[] order;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		order = new int[4];
		for (int i = 0; i < 4; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0]); //맨 앞 숫자는 미리 더해놓는다.

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int end, int sum) {
		if (end == n) { //끝까지 연산을 완료하면 최소값, 최대값 구하기
			min = Math.min(min, sum);
			max = Math.max(max, sum);       
			return;
		}
		for (int i = 0; i < 4; i++) { //가지고 있는 연산자에 따라 다음 연산을 준비한다.
			if (order[i] > 0) {
				order[i]--;
				dfs(end + 1, calc(sum, i, end));
				order[i]++;
			}
		}
	}

	private static int calc(int sum, int order_index, int arr_index) {
		//가지고 있는 연산자에 따라 연산을 한다.
		if (order_index == 0) {
			return sum+arr[arr_index];
		}
		else if (order_index == 1) {
			return sum-arr[arr_index];
		}
		else if (order_index == 2) {
			return sum*arr[arr_index];
		}
		else if (order_index == 3) {
			return (Integer)sum/arr[arr_index];
		}
		return 0; //그냥 
	}
}
