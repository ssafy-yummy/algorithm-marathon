package com.boj.boj14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = Integer.MIN_VALUE;    // 최댓값
    public static int MIN = Integer.MAX_VALUE;    // 최솟값
    public static int[] op;
    public static int[] num;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs(int val, int idx) {
        if (idx == n) {
            MAX = Math.max(MAX, val);
            MIN = Math.min(MIN, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        dfs(val + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(val - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(val * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(val / num[idx], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}