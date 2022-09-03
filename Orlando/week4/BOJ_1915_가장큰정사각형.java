package com.boj.boj1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        // 배열 내에 1이 존재할 경우에 대한 boolean type flag
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tmp[j]+"");
                if (board[i][j]== 1) flag = true;
            }
        }

        // board내에 한개의 1이라도 존재할 경우 최종 결과값은 1부터 시작한다.
        result = flag ? 1: 0;

        // 누적합으로 생각한다면 (i, j) 번에 위치하는 정사각형에 대해 (i-1, j), (i, j-1), (i-1, j-1)
        // 위치에 있는 값의 최소값을 가져올 수 있다.
        // 다만 해당 위치의 값이 0이 아닌 경우에 성립이 된다.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(board[i][j] == 1
                        && board[i][j-1] > 0
                        && board[i-1][j] > 0
                        && board[i-1][j-1] > 0) {
                    board[i][j] += Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]);
                }
                result = Math.max(board[i][j], result);
            }
        }
        // 넓이이므로 최종 결과값^2의 값을 출력한다.
        System.out.println(result * result);
    }
}
