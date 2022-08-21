package com.boj.boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] video;

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                video[i][j] = tmp[j] - '0';
            }
        }
        quadTree(0,0, n);
        System.out.println(result.toString());
    }

    public static void quadTree(int r, int c, int size){
        if (isCheck(r, c, size)) {
            result.append(video[r][c]);
            return;
        }

        int nextSize = size/2;
        result.append('(');

        quadTree(r,c, nextSize);
        quadTree(r, c+ nextSize, nextSize);
        quadTree(r+nextSize, c, nextSize);
        quadTree(r+nextSize, c+nextSize, nextSize);

        result.append(')');
    }

    public static boolean isCheck(int r, int c, int size){
        int result = video[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(video[i][j] != result) return false;
            }
        }
        return true;
    }
}
