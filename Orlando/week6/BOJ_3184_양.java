package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_양 {
    static int r, c;
    static String[][] board;
    static boolean[][] visited;

    static StringTokenizer st;

    static int lamb;
    static int wolf;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp[j] + "";
                if(board[i][j].equals("#")) visited[i][j] = true;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && (board[i][j].equals("v") || board[i][j].equals("o"))) bfs(i, j);
            }
        }

        System.out.println(lamb+ " " + wolf);
    }

    private static void bfs(int pr, int pc) {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(pr, pc));
        int nowLamb = 0;
        int nowWolf = 0;

        if(board[pr][pc].equals("v")) nowWolf+=1;
        else nowLamb+=1;

        visited[pr][pc] = true;

        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = loc.r + dr[i];
                int nc = loc.c + dc[i];

                if(!check(nr, nc)|| visited[nr][nc]) continue;
                if(board[nr][nc].equals("v")) nowWolf+=1;
                else if(board[nr][nc].equals("o")) nowLamb+=1;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc));
            }
        }

        if(nowLamb > nowWolf){
            lamb += nowLamb;
        }else{
            wolf += nowWolf;
        }
    }

    private static boolean check(int nr, int nc){
        return 0<=nr && nr < r && 0<= nc && nc < c;
    }
}
