package com.boj.boj7576;

import java.util.*;

public class Main {
    static int n ,m;
    static int[][] tomatoes;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        tomatoes = new int[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = sc.nextInt();
                if(tomatoes[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.println(getResult()-1);
    }

    private static void bfs() {
      while (!queue.isEmpty()){

          int[] tomato = queue.poll();
          int pr = tomato[0];
          int pc = tomato[1];
          int val = tomatoes[pr][pc];

          for (int i = 0; i < 4; i++) {
              int nr = pr + dr[i];
              int nc = pc + dc[i];
              if(!check(nr, nc) || tomatoes[nr][nc] > 0) continue;
              tomatoes[nr][nc] = val+1;
              queue.offer(new int[]{nr, nc});
          }
      }
    }

    private static int getResult(){
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomatoes[i][j] == 0) return -1;
                max = Math.max(max, tomatoes[i][j]);
            }
        }
        return max-1;
    }

    private static boolean check(int nr , int nc){
        return 0 <= nr && nr < n && 0<= nc && nc < m && tomatoes[nr][nc] != -1;
    }
}
