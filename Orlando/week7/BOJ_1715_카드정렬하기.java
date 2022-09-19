package com.boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715_카드정렬하기 {
    static int n;
    static PriorityQueue<Integer> queue;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new PriorityQueue<>();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        while (queue.size() > 1){
            int card1 = queue.poll();
            int card2 = queue.poll();
            result +=  card1 + card2;
            queue.offer(card1 + card2);
        }
        System.out.println(result);
    }
}
