package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2115_S3_에너지드링크 {

	static int N;
	static Double[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new Double[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		double sum = arr[0];
		for (int i = 1; i < N; i++)
			sum += arr[i] / 2;

		System.out.println(sum);

	}
}