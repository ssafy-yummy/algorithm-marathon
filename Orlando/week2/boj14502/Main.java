package com.boj.boj14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // static 변수 선언
    static int n ,m;
    static int[][] map;
    static int wall = 3;

    // 방향 조절
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        result = Integer.MIN_VALUE;

        setWall(0);
        System.out.println(result);
    }
    
    public static void setWall(int cnt){
        if(cnt == wall) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    setWall(cnt+1);
                    map[i][j]  = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Loc> queue = new LinkedList<>();
        int[][] tmpMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmpMap[i][j] == 2) queue.offer(new Loc(i, j));
            }
        }

        while(!queue.isEmpty()){
            Loc l = queue.poll();
            int r = l.r;
            int c = l.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(isCheck(nr, nc)){
                    if(tmpMap[nr][nc] == 0){
                        tmpMap[nr][nc] = 2;
                        queue.add(new Loc(nr, nc));
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmpMap[i][j] == 0) count ++;
            }
        }


        result = Math.max(result, count);
    }

    private static boolean isCheck(int nr, int nc){
        return (0<=nr && nr < n && 0<=nc && nc < m);
    }

    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
