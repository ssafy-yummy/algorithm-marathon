package com.boj;

import java.util.Scanner;

public class BOJ_2225_합분해 {
    static int n, k;
    static int[][] arr;
    static int MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() + 1;
        k = sc.nextInt();

        arr = new int[k][n];

        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0; i < k; i++) {
            arr[i][0] = 1;
        }


        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % MOD;
            }
        }

        System.out.println(arr[k-1][n-1] % MOD);
    }
}
