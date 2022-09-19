package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_2048 {
    static int n;
    static int[][] board;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 총 다섯번의 움직임이 될 때까지 재귀 수행
        round(0);

        System.out.println(result);
    }

    static void round(int cnt){
        if(cnt == 5 || check(board)){
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }

        int[][] tmp =  copyBoard(board);

        for (int i = 0; i < 4; i++) {
            move(i);
            for (int j = 0; j < n; j++) {
            }
            round(cnt + 1);
            for (int j = 0; j < n; j++) {
                board[j] = tmp[j].clone();
            }
        }
    }

    static void move(int cnt){
        //네방향에서 한쪽으로 옮겼을 때에 대해 탐색 수행
        // 현재 배열에 대한 깊은 복사(deep copy)
        switch (cnt){
            case 0:
                    //왼쪽에서 오른쪽으로
                    for(int i = 0; i < n; i++) {
                        int index = 0;
                        int block = 0;
                        for(int j = 0; j < n; j++) {
                            if(board[j][i] != 0) {
                                if(block == board[j][i]) {
                                    board[index - 1][i] = block * 2;
                                    block = 0;
                                    board[j][i] = 0;
                                }
                                else {
                                    block = board[j][i];
                                    board[j][i] = 0;
                                    board[index][i] = block;
                                    index++;
                                }
                            }
                        }
                    }
                    break;
            case 1:
                //아래에서 위로
                for(int i = 0; i < n; i++) {
                    int index = n-1;
                    int block = 0;
                    for(int j = n-1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;

            case 2:
                //왼쪽에서 오른쪽으로
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < n; i++) {
                    int index = n-1;
                    int block = 0;
                    for(int j = n-1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    
    static int[][] copyBoard(int[][] nowBoard){
        int[][] copyBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
           copyBoard[i] = nowBoard[i].clone();
        }
        return copyBoard;
    }

    static boolean check(int[][] board){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0) count++;
            }
        }
        return count == 1;
    }
}


/*
5
2 0 0 0 0
2 0 0 0 0
4 0 0 0 0
2 0 0 0 0
2 0 0 0 0

4
2 2 4 16
0 0 0 0
0 0 0 0
0 0 0 0

3
2 2 2
2 2 2
2 2 2

10
16 16 8 32 32 0 0 8 8 8
16 0 0 0 0 8 0 0 0 16
0 0 0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

4
2 2 2 2
2 2 2 2
2 2 2 2
2 2 2 2
 */