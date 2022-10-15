package com.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
    static int n,s;
    static int result;
    static int[] board;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        board = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            board[i] = sc.nextInt();
        }

        nPr(0,0, new ArrayList<Integer>());
        System.out.println(result);
    }

    private static void nPr(int start, int cnt, List<Integer> arr) {
        if(cnt==n) {
            if(arr.stream().mapToInt(Integer::intValue).sum() == s) result++;
            return;
        }

        if(!arr.isEmpty() && arr.stream().mapToInt(Integer::intValue).sum() == s) {
            result++;
        }
        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(board[i]);
            nPr(i+1, cnt+1, arr);
            visited[i] = false;
            arr.remove(arr.indexOf(board[i]));
        }
    }
}
