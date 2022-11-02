package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //StringBuilder를 통해서 입력 수행
        StringBuffer s = new StringBuffer(bf.readLine());
        StringBuffer t = new StringBuffer(bf.readLine());

        // s의 길이가 될 때까지 반복
        while (s.length() < t.length()){
            // 마지막이 A라면 마지막값을 뺀다.
            if(t.charAt(t.length()-1) == 'A') t.deleteCharAt(t.length()-1);
            // 마지막 값이 B라면 마지막 값을 뺴고 문자열을 뒤집는다.
            else {
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }
        // 최종적으로 문자열이 s와 일치하다면 1을 반환, 아닐 경우 0을 반환하도록 한다.
        if(s.toString().equals(t.toString())) System.out.println(1);
        else System.out.println(0);
    }
}

/*
* 그리디의 경우에는 역순으로 탐색해보는 것도 하나의 방법이다.
* */