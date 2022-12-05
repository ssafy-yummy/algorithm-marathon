package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_133335_트럭 {
    static int n, w, L;
    static int[] road;
    static Queue<Integer> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        road = new int[w];

        st = new StringTokenizer(bf.readLine());
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;

        while(!queue.isEmpty()){
            cnt++;
            for (int i = w-1; i >= 1; i--) {
                road[i] = road[i-1];
            }
            road[0] = 0;
            int t = queue.peek();
            if(checkWeight(t)) road[0] = queue.poll();
        }
        for (int i = 0; i < w; i++) {
            if(road[i]!=0) {
                cnt+= w - i;
                break;
            }
        }

        System.out.println(cnt);
    }
    // 다리의 무게를 검사하는 메서드
    static boolean checkWeight(int t){
        int weight = t;
        for (int i = 0; i < w; i++) {
            if(road[i] != 0) weight+= road[i];
        }
        return weight <= L;
    }
}
