package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2293_동전1 {
    static int n, k;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coins = new int[n];
        dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j >=coins[i])
                    dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
