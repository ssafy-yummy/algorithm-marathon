package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
    static char[] sen;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        sen = bf.readLine().toCharArray();
        boolean flag = false;
        for (char s : sen) {
            if(flag){
                if(s=='>') flag = false;
                result.append(s);
                continue;
            }
            if(s==' '){
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append(sb.toString() + " ");
            }
            else if(s == '<'){
                while(!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                flag = true;
                result.append(s);
            }
            else{
                stack.add(s);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result.toString());

    }

    private static void add(int start, int end) {

    }
}
