package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_24843_콘센트 {
    static int n, m;
    static PriorityQueue<Integer> pq;
    static int[] sockets;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 내림차순으로 정렬하기 위한 정렬
        pq = new PriorityQueue<>((a, b)-> b-a);
        sockets = new int[m];
        
        st = new StringTokenizer(bf.readLine());


        for (int i = 0; i < n; i++) pq.offer(Integer.parseInt(st.nextToken()));

       while(!pq.isEmpty()){
           boolean flag = true;
           int tmp = pq.poll();
           for (int i = 0; i < m; i++) {
               if(sockets[i] == 0) {
                   sockets[i] += tmp;
                   flag = false;
                   break;
               }
               else if(i > 0 && sockets[i] + tmp <= sockets[i-1]){
                   sockets[i] += tmp;
                   flag = false;
                   break;
               }
           }

           if(flag) sockets[0] += tmp;
       }

       int result = sockets[0];
       System.out.println(result);
    }
}
