package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {
    static int n, m, dep, ari;

    static int[][] bus;
    static boolean[] visited;
    static int[] dis;

    static int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        bus = new int[n][n];

        // 방문한 노드를 체크하기 위한 것
        visited = new boolean[n];
        visited[0] = true;
        //최단거리를 구하기 위한 1차원 배열 초기화
        dis = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    bus[i][j] = 0;
                    continue;
                }
                bus[i][j] = MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int cost = sc.nextInt();
            bus[start][end] = cost;
            bus[end][start] = cost;
        }

        // 출발, 도착 정보®
        dep = sc.nextInt()-1;
        ari = sc.nextInt()-1;

        dijkstra(dep);
        System.out.println(dis[ari]);
    }

    static int getSmallIndex(){
        int min = MAX;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(dis[i] < min && !visited[i]){
                min = dis[i];
                index = i;
            }
        }
        return index;
    }

    //다익스트라
    static void dijkstra(int start){
        dis = bus[start].clone();
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            int cur = getSmallIndex();

            visited[cur] = true;
            for (int j = 0; j < n; j++) {
                if(!visited[j])
                    if(dis[cur] + bus[cur][j] < dis[j]){
                        dis[j] = dis[cur] + bus[cur][j];
                    }
            }
        }
    }
}
