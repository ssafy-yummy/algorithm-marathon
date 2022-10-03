package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234_인구이동 {
    static int n, l ,r;
    static int[][] world;
    static boolean[][] visited;
    static StringTokenizer st;
    static int tmp;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Loc{
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        world = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = open();
        System.out.println(result);
    }

    static int open(){
        int result = 0;
        while(true){
            visited = new boolean[n][n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    List<Loc> list = bfs(i, j);
                    if(list.size()> 1){
                        setWorld(list);
                        flag = true;
                    }

                }
            }
            if(!flag) return result;
            result ++;

        }
    }

    private static void setWorld(List<Loc> list) {
        int avg = tmp / list.size();
        for (Loc loc : list) {
            world[loc.r][loc.c] = avg;
        }
    }


    static List<Loc> bfs(int r, int c){

        Queue<Loc> queue = new LinkedList<>();
        List<Loc> list = new ArrayList<>();
        queue.add(new Loc(r, c));
        list.add(new Loc(r,c));
        tmp = world[r][c];
        visited[r][c] = true;
        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            int pr = loc.r;
            int pc = loc.c;

            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || !isCheckBound(pr, pc, nr, nc)) continue;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc));
                list.add(new Loc(nr, nc));
                tmp += world[nr][nc];
            }
        }
        return list;
    }

    static boolean isCheck(int nr, int nc){
        return 0<= nr && nr < n && 0 <= nc && nc < n;
    }

    static boolean isCheckBound(int pr, int pc, int nr, int nc){
        int size = Math.abs(world[pr][pc] - world[nr][nc]);
        return l <= size && size <= r;
    }


}
