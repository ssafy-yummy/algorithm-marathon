package com.level2;

public class PG_12980_점프와순간이동 {
    public static void main(String[] args) {
        int n =6;
        System.out.println(solution(n));
    }

    static int solution(int n){
        int result = 1;

        while(n > 1){
            if(n % 2 != 0) {
                result++;
                n-=1;
                continue;
            }
            n /= 2;
        }
        return result;
    }
}
