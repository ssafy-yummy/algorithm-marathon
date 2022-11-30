package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_역테_디저트카페 {
    static int T, n, r, c, result;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] num;
    static int SIZE = 101;


    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(bf.readLine());
            result = 0;
            board = new int[n][n];
            visited = new boolean[n][n];
            num = new boolean[SIZE];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    r = i;
                    c = j;
                    bfs(i, j,0, 0, 0);
                    visited = new boolean[n][n];
                    num = new boolean[SIZE];
                }
            }

            result = result == 0 ? -1 : result;
            System.out.println("#" + t + " " + result);
        }
    }

    static void bfs(int pr, int pc, int dir, int cnt, int size){
        visited[pr][pc] = true;
        num[board[pr][pc]] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            int tmpDir = dir;
            int tmpCnt = cnt;
            if(i != dir) {
                tmpDir = i;
                tmpCnt++;
            }

            if(cnt == 4) continue; // 4번 방향을 전환했을 경우 무시한다.

            if(isRec(nr, nc) && size >= 3) { //다음 위치가 초기 위치와 같고 size가 4 이상일 경우
                result = Math.max(result, size);
                continue;
            }



            if(!isCheck(nr, nc) || visited[nr][nc] || num[board[nr][nc]]) continue; // 배열을 벗어나거나 방문한 지점이거나 먹은 디저트일 경우

            bfs(nr, nc, tmpDir, tmpCnt, size);
        }
        visited[pr][pc] = false;
        num[board[pr][pc]] = false;
    }

    static boolean isCheck(int nr, int nc){
        return 0<=nr && nr < n && 0 <= nc && nc < n;
    }
    static boolean isRec(int nr, int nc){
        return r == nr && c == nc;
    }
}
/*

1
7
7 4 1 5 1 7 9
9 4 6 1 4 6 8
9 6 4 8 4 7 4
3 2 6 2 4 2 8
4 9 4 6 2 4 7
1 7 6 8 9 5 8
1 9 4 7 2 9 7


1
8
18 18 7 16 15 3 5 6
3 6 8 3 15 13 15 2
4 1 11 17 3 4 3 17
16 2 18 10 2 3 11 12
11 17 16 2 9 16 5 4
17 7 6 16 16 11 15 8
2 1 7 18 12 11 6 2
13 12 12 15 9 11 12 18

* */