package com.boj.boj14501;

import java.util.Scanner;

public class Main {
    static int n, result;

    static int[] days, profits;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        days = new int[n];
        profits = new int[n];

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        working(0, 0);
        System.out.println(result);
    }
    
    private static void working(int day, int profit){
        if(day >= n){
            result = Math.max(result, profit);
            return;
        }

        if(day + days[day] <= n)
            working(day + days[day], profit + profits[day]);
        else
            working(day + days[day], profit);
        working(day + 1, profit);
    }
}
