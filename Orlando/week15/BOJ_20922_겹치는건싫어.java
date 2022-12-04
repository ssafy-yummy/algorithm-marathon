package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
    static int n, k;
    static int s, e;
    static int[] cntArray;
    static int[] arr;

    static int SIZE = 100001;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 원소가 k번 반복될 것인지 확인하기 위한 배열 선언
        cntArray = new int[SIZE];

        // 순서가 들어갈 배열 선언
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int result = 0;

        while(s<=e)
        {
            if(e<=n-1 &&cntArray[arr[e]] <k)
            {
                cntArray[arr[e]]++;
                e++;

            }
            else if(cntArray[arr[e]] == k)
            {
                cntArray[arr[s]]--;
                s++;
            }

            result = Math.max(result, e - s);
            if(e == n)
                break;
        }
    }
}
