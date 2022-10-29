package hanmin.src.week11;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14719_G5_빗물 {
	static int[] arr;
	static int H;
	static int W;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[W + 1];
		for (int i = 0; i < W; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		int mx = arr[0];
		int cnt = 0;
		//왼쪽부터 빗물의 양 계산
		for (int i = 1; i < W; ++i) {
			//현재 mx 값보다 큰 블록이 있다면 빗물의 양 계산
			if (arr[i] >= mx) {
				answer += cnt;
				cnt = 0;
				mx = arr[i];
			} else {//빗물이 고이는 영역 합
				cnt += (mx - arr[i]);
			}
		}
		mx = arr[W - 1];
		cnt = 0;
		//오른쪽부터 빗물의 양 계산
		for (int i = W - 2; i >= 0; --i) {
			if (arr[i] > mx) {
				answer += cnt;
				cnt = 0;
				mx = arr[i];
			} else {
				cnt += (mx - arr[i]);
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}
}
