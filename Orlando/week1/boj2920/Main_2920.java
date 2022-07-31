package com.boj.boj2920;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2920 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/boj/boj2920/case.txt"));
        int n = sc.nextInt();

        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) nArr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) mArr[i] = sc.nextInt();

        Arrays.sort(nArr);

        Main_2920 main = new Main_2920();

        for (int i = 0; i < m; i++) {
            System.out.println(main.check(nArr, mArr[i], 0, n));
            System.out.println("--------------------");
        }
    }

    public int check(int[] arr , int n, int start, int end){
        int mid = (start + end)/2;

        if(mid >= end) return 0;

        if(n == arr[mid]) return 1;
        else if(arr[mid]<n) return check(arr, n, mid + 1, end);
        else return check(arr, n, start, mid);
    }
}
