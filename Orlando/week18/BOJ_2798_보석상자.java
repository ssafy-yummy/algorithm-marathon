package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_2798_보석상자 {

    static int n, m;
    static int[] colors;

    // left가 1이 되는 이유는 최소한 한명에게 모든 보석을 분해해야하기 떄문에
    static int left = 1, right, mid, sum;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        colors = new int[m];// 색 배열 초가화
        for (int i = 0; i < m; i++) { // 색 배열 값 할당
            int tmp = Integer.parseInt(bf.readLine());
            colors[i] = tmp;
            if(right < tmp) right = tmp;
        }

        search();
        System.out.println(result);
    }

    static void search(){
        while (left <= right){ // 이분탐색의 종료조건 지정
            mid = (left + right) /2; // 최소값과 최대값의 합
            sum = 0;
            for(int color : colors){
                int child = color % mid == 0 ? color / mid : color / mid + 1;
                sum += child;
            }
            if(n >= sum){
                result = Math.min(result, mid);
                right = mid -1;
                continue;
            }
            left = mid + 1;
        }
    }
}
