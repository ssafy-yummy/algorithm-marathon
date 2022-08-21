package com.boj.boj13305;

import java.util.Scanner;

public class Main {
    static int n;
    static long[] distance;
    static long[] price;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        distance = new long[n-1];
        price = new long[n];

        for (int i = 0; i < n-1; i++) {
            distance[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        long car = price[0];

        long result = 0;
        for (int i = 0; i < distance.length; i++) {
            if(car>price[i]) car = price[i];
            result+= car * distance[i];

        }
        System.out.println(result);
    }
}
