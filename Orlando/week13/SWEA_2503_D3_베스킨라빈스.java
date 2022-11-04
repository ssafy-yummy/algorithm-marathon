package com.swea;

import java.util.Scanner;

public class SWEA_2503_D3_베스킨라빈스 {
    static int T;
    static int n;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            int cnt = 4;
            boolean user = true; // 선공일 경우 true, 후공일 경우 false
            user = n % cnt == 1;
            result = user ? 1 : 0;
            System.out.printf("#%d %d\n", t, result);
        }
    }
}
