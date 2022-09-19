package hanmin.src.week6;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20115_S3_에너지드링크 {
	static double[] arr;
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new double[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		// start
		//가장 많은 양의 드링크를 남기는게 최선의 선택
		//1부터 n-2까지 마지막 드링크에 합치기
		Arrays.sort(arr);
		for (int i = 0; i < N - 1; ++i) {
			arr[N - 1] += arr[i] / 2;
		}
		// end

		// 출력
		System.out.println(arr[N - 1]);
	}
}
