package com.boj;

import java.util.Scanner;

public class BOJ_2436_공약수 {
    static int gcd, lcm; // 최대공약수, 최소공배수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gcd = sc.nextInt();
        lcm = sc.nextInt();

        int resultVal1 = gcd;
        int resultVal2 = lcm;

        int sum = gcd * lcm;

        for (int i = 2 * gcd; i < sum; i+=gcd) {
            if(sum  % i == 0){
                int tmp = sum / i;
                if(getGcd(i, tmp) == gcd){
                    if(resultVal1 + resultVal2 > i + tmp){
                        resultVal1 = i;
                        resultVal2 = tmp;
                    }
                }
            }
        }

        System.out.println(resultVal1 + " " + resultVal2);
    }

    private static int getGcd(int x, int y){
        return y == 0 ? x : getGcd(y, x % y);
    }
}
