package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17281_야구 {
    static int n;
    static int[][] innings;
    static boolean[] visited;
    static int[] hitter;

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        innings = new int[n+1][10];
        visited = new boolean[10];
        hitter = new int[10];
        
        hitter[4] = 1;
        visited[4] =true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                innings[i][j] = sc.nextInt();
            }
        }

        npr(2);
        System.out.println(result);
    }

    private static void npr(int cnt) {
        if(cnt == 10){
            playball();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            hitter[i] = cnt;
            npr(cnt+1);
            visited[i] = false;
        }
    }

    private static void playball() {
        int score = 0;
        int start = 1;
        int inning = 1;
        int out = 0;
        int[] base = new int[4];

        while(inning <= n){
            if(out == 3){
                inning++;
                out = 0;
                base = new int[4];
                continue;
            }

            int htr = hitter[start];
            int tmp = innings[inning][htr];

            base[0] = 1;

            switch (tmp){
                case 1:
                    score+= base[3];
                    for (int i = 3; i >= 1; i--) {
                        base[i] = base[i-1];
                    }
                    base[0] = 0;
                    break;
                case 2:
                    score += base[2] + base[3];
                    base[3] = base[1];
                    base[2] = base[0];
                    base[1] = 0;
                    base[0] = 0;
                    break;
                case 3:
                    score += base[3] + base[2] + base[1];
                    base[3] = base[0];
                    for (int i = 0; i < 3; i++) {
                        base[i] = 0;
                    }
                    break;
                case 4:
                    score += Arrays.stream(base).sum();
                    Arrays.fill(base, 0);
                    break;
                default:
                    out++;
                    base[0] = 0;
                    break;
            }
            if(start == 9)
                start = 1;
            else start ++;
        }
        result = Math.max(result, score);
    }
}
