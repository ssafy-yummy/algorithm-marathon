package com.boj.boj2085;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] woods;

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        woods = new int[n];

        for (int i = 0; i < n; i++) {
            woods[i] = sc.nextInt();
        }

        Arrays.sort(woods);

        // 가장 높은 높이의 절반값부터 시작
        int max = woods[n-1];
        // 최소값
        int min = 0;
        while(min<max){
            // 현재 높이에서 잘랐을 때 남는 나무의 길이 탐색
            int h = (max + min) /2;
            int tmp= 0;
            for (int w : woods) {
               tmp += Math.max(w - h, 0);
            }
            // 상근이가 원하는 값 보다 작을 경우 -> tmp의 값을 감소 시킨다.
            if(tmp < m) max = h;
            // 상근이가 원하는 값 보다 클 경우
            else min = h + 1;
        }
        System.out.println(min-1);
    }
}
