package com.boj;

import java.util.Scanner;

public class BOJ_14889_스타트와링크 {
    static int n;
    static int[][] arr;
    static int[] start, link;
    static boolean[] visited;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ncr(0, 0);
        System.out.println(result);
    }

    private static void ncr(int cnt, int start) {
        if(cnt == n/2){
            result = Math.min(result, getResult());
            return;
        }
        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            ncr(cnt+1, i+1);
            visited[i] = false;
        }
    }

    private static int getResult(){
        start = new int[n/2];
        link = new int[n/2];

        int startCnt = 0;
        int linkCnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) start[startCnt++]= i;
            else{
                link[linkCnt++] = i;
            }
        }

        int startVal = 0;
        int linkVal = 0;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                if(i == j) continue;
                startVal+= arr[start[i]][start[j]];
                linkVal += arr[link[i]][link[j]];
            }
        }

        return Math.abs(startVal - linkVal);
    }
}
