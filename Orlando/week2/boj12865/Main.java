package com.boj.boj12865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] weight;
    static int[] value;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        weight = new int[n];
        value = new int[n];
        result = Integer.MIN_VALUE;
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
                result = Math.max(dp[i][j], result);
            }
        }
        System.out.println(result);
    }
}

