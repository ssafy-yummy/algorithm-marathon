package com.boj;

import java.util.*;

public class BOJ_2252_줄세우기 {
    static int n, m;
    static int[] arr;
    static List<List<Integer>> nodes;
    static Queue<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        nodes = new ArrayList<>();
        result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            nodes.get(from).add(to);

            arr[to]++;
        }

        topologySort();
        for (Integer integer : result) {
            System.out.print((integer + 1) + " ");
        }
    }

    static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.offer(node);

            for (Integer i : nodes.get(node)) {
                arr[i]--;
                if(arr[i] == 0){
                    queue.offer(i);
                }
            }
        }

    }
}
