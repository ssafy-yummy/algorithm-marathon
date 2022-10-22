package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_동물원 {
    static int n;
    static int NUM = 9901;
    static int[][] cage;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        cage = new int[n+1][3];

        // 시작 지점 초기화
        for (int i = 0; i < 3; i++) {
            cage[1][i] = 1;
        }

        for (int i = 2; i <=n; i++) {
            cage[i][0] = cage[i-1][0] + cage[i-1][1] +  cage[i-1][2];
            cage[i][1] = cage[i-1][0] + cage[i-1][2];
            cage[i][2] = cage[i-1][0] + cage[i-1][1];
            cage[i][0] %= NUM;
            cage[i][1] %= NUM;
            cage[i][2] %= NUM;
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += cage[n][i];
        }
        System.out.println(result % NUM);
    }
}
/*
* 완전 탐색으로 돌리게 되면 터진다.
*
* */
