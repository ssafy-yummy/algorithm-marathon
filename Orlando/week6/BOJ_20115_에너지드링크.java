package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20115_에너지드링크 {
    static int n;
    static int[] drinks;
    static double result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        drinks = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drinks);

        for (int i = 0; i < n-1; i++) {
            result += drinks[i]/2.0;
        }
        result+=drinks[n-1];
        System.out.println(result);
    }
}
