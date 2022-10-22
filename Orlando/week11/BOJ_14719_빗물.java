package com.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_14719_빗물 {
    static int r, c;
    static int[][] world;
    static int[] blocks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        world = new int[r][c];
        blocks = new int[c];

        for (int i = 0; i < c; i++) {
            blocks[i] = sc.nextInt();
        }
        // 빈 공간은 0, 블록은 1로 초기화, 이후 빗물은 2를 받을 것
        for (int i = 0; i < c; i++) {
            for (int j = r-1; j >  r-1- blocks[i]; j--) {
                world[j][i] = 1;
            }
        }

        for (int i = r-1; i >= 0; i--) {
            rain(i);
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(world[i][j] == 2) result++;
            }
        }
        System.out.println(result);
    }

    private static void rain(int pr) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            if(world[pr][i] == 1 && isWall(pr, i)){
                tmp.add(i);
            }
        }

        for (Integer loc : tmp) {
            for (int i = loc+1; i < c; i++) {
                if(world[pr][i] == 1) break;
                world[pr][i] = 2;
            }
        }
    }

    // 빗물을 담을 벽이 있는지 체크하는 함수
    public static boolean isWall(int nr, int nc){
        if(world[nr][nc] == 0) return false; // 시작지점에 벽이 없으면 false
        for (int i = nc+1; i < c; i++) {
            if(world[nr][i] == 1) return true;
        }
        return false;
    }

    // 빗물 담기
}
