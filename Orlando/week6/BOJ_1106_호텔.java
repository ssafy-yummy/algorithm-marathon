package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {
    static int c, n;
    static int[] customers;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        //입력 부분
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 회원 수 별 비용을 찾기 위한 배열 선언
        customers = new int[c + 101];
        // 각각의 최소비용을 찾기위해 overflow가 발생하지 않을 만큼 값을 채운다
        Arrays.fill(customers, Integer.MAX_VALUE - 1001);

        // 시작 지점 0으로 초기화
        customers[0] = 0;

        // 구현 부분
        for (int i = 0; i < n; i++) {
            // 비용과 고객 수 입력
            st = new StringTokenizer(bf.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            // 현재 고객의 위치서 부터 * n 만큼의 값을 비교해가며 삽입
            for (int j = customer; j < customers.length; j++) {
                customers[j] = Math.min(customers[j], customers[j - customer] + cost);
            }
        }

        // customer의 위치부터 가장 작은 값을 탐색
        for (int i = c; i < customers.length; i++) {
            result = Math.min(customers[i], result);
        }

        // 결과 출력
        System.out.println(result);
    }
}
