package com.boj.boj2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = 0;
    static int cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];

        ArrayList<Integer> resultArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                 map[i][j] = tmp[j] - '0';
            }
        }

        cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j)) {
                    result++;
                    resultArr.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(result);
        Collections.sort(resultArr);
        for (Integer r : resultArr) {
            System.out.println(r);
        }

    }

    static boolean dfs(int x, int y){
        if(x<0 || x>=n || y <0 || y >=n)
            return false;

        if(map[y][x] == 1){
            map[y][x] = 0;
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            return true;
        }
        return false;
    }
}
